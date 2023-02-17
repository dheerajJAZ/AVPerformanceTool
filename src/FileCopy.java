import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileCopy {

	String userdir=System.getProperty("user.dir");
	Connection conn;
	String ftpaddr;
	int ftpport;
	String username;
	String password;
	String fromlocation;
	String tolocation;
	String datetime;
	float finishs;
	int copyselection;
	int scandoneWithoutantivirus;
	int scandoneWithantivirus;
	String remotePath;
	int totalcountonftp;
	int fileCountonlocal;
	int ftpdeleteflag;
	File filestobedeleted;
	public static String filename;
	boolean	shutdown=false;


	public boolean downloadSingleFile(FTPClient ftpClient,
			String remoteFilePath, String savePath) throws IOException {
		File downloadFile = new File(savePath);

		File parentDir = downloadFile.getParentFile();
		if (!parentDir.exists()) {
			parentDir.mkdir();
		}

		OutputStream outputStream = new BufferedOutputStream(
				new FileOutputStream(downloadFile));
		try {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			return ftpClient.retrieveFile(remoteFilePath, outputStream);
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (outputStream != null) {
				outputStream.close();

			}
		}
	}
	public void downloadDirectory(FTPClient ftpClient, String parentDir,
			String currentDir, String saveDir) throws IOException, ClassNotFoundException, SQLException
	{
		String dirToList = parentDir;
		if (!currentDir.equals(""))
		{
			dirToList += "/" + currentDir;
		}

		FTPFile[] subFiles = ftpClient.listFiles(dirToList);

		if (subFiles != null && subFiles.length > 0) {
			for (FTPFile aFile : subFiles) {
   
				totalfiledownloadonlocal();
				String currentFileName = aFile.getName();
				filename=currentFileName;
				if (currentFileName.equals(".") || currentFileName.equals("..")) {

					continue;
				}
				String filePath = parentDir + "/" + currentDir + "/"+ currentFileName;

				if (currentDir.equals("")) {
					filePath = parentDir + "/" + currentFileName;
				}

				String newDirPath = saveDir + parentDir + File.separator+ currentDir + File.separator + currentFileName;
				if (currentDir.equals("")) {
					newDirPath = saveDir + parentDir + File.separator+ currentFileName;
				}

				if (aFile.isDirectory()) {

					File newDir = new File(newDirPath);
					boolean created = newDir.mkdirs();
					if (created) {
						System.out.println("CREATED the directory: " + newDirPath);
					} else {
						System.out.println("COULD NOT create the directory: " + newDirPath);
					}


					downloadDirectory(ftpClient, dirToList, currentFileName,
							saveDir);
				} else {

					boolean success = downloadSingleFile(ftpClient, filePath, newDirPath);

					if (success) {
						System.out.println("DOWNLOADED the file: " + filename);

					} else {
						System.out.println("COULD NOT download the file: "+ filePath);

					}
				}
				if(shutdown==true)
				{
					System.out.println("for break"+shutdown);
					break;
				}
			}
		}
	}

	synchronized public void startdownload() throws IOException, ClassNotFoundException, SQLException, ParseException {

		fetchselectionsettingfromDB();
		String server = ftpaddr;
		int port = ftpport;
		String user = username;
		String pass =password;
		FTPClient ftpClient = new FTPClient();

		String fromtrim1= fromlocation.substring(fromlocation.indexOf("/")+2);
		String fromtrim2=fromtrim1.substring(fromtrim1.indexOf("/"));
		String finalspaceremoval=fromtrim2.replaceAll("%20", " ");
		System.out.println(finalspaceremoval);

		remotePath=finalspaceremoval;
		String localPath=tolocation;

		String remoteDirPath = remotePath;
		String saveDirPath = localPath;

		try {
			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			System.out.println("Connected");
			long start = System.currentTimeMillis();
			FileCopy fileCopy = new FileCopy();
			fileCopy.downloadDirectory(ftpClient, remoteDirPath, "", saveDirPath);
			long finish = System.currentTimeMillis();
			long totalTime = finish - start;
			finishs=(float)totalTime/1000;
			insertinDatabase();
			filestobedeleted=new File(localPath);


			if(copyselection==0 && scandoneWithoutantivirus==0)
			{
				System.out.println("Going for WithoutCP=1");
				conn=this.tests();
				String queryscandone="update Settings set CpWithoutAV=1";
				Statement query  = conn.createStatement();
				query.executeQuery(queryscandone);
				conn.close();
			}
			else if(copyselection==1 && scandoneWithantivirus==0)
			{
				System.out.println("Going for WithAVCP=1");
				conn=this.tests();
				String queryscandone="update Settings set CpWithAV=1";
				Statement query  = conn.createStatement();
				query.executeQuery(queryscandone);
				conn.close();

			}
			System.out.println(finishs);
			ftpClient.logout();
			ftpClient.disconnect();


			System.out.println("Disconnected");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("for dowhile"+shutdown);

	}
	public void fetchselectionsettingfromDB() throws ClassNotFoundException, SQLException {

		conn=this.tests();
		String sql = " select * from FTPSetting";
		String sql2 = " select * from Settings";
		ResultSet rs1 = null;
		ResultSet rs2=null;
		Statement stmts  = conn.createStatement();
		rs1= stmts.executeQuery(sql);
		while (rs1.next()) {
			String ftp=rs1.getString("FTPAddress");
			int port=rs1.getInt("Port");
			String user=rs1.getString("Username");
			String pass=rs1.getString("Password");
			String from=rs1.getString("FromLocation");
			String to=rs1.getString("ToLocation");
			int ftpdelete=rs1.getInt("FTPDelete");

			ftpaddr=ftp;
			ftpport=port;
			username=user;
			password=pass;
			fromlocation=from; 
			tolocation=to;
			ftpdeleteflag=ftpdelete;

			System.out.println(ftpaddr);
			System.out.println(ftpport);


		}
		rs2= stmts.executeQuery(sql2);
		while (rs2.next()) {

			int Copyselec=rs1.getInt("CopySelection");
			int withoutav=rs1.getInt("CpWithoutAV");
			int withav=rs1.getInt("CpWithAV");

			copyselection=Copyselec;
			scandoneWithoutantivirus=withoutav;
			scandoneWithantivirus=withav;
		}

		rs1.close();
		rs2.close();
		stmts.close();
		conn.close();

	}

	public Connection tests() throws ClassNotFoundException {

		try {
			String wal="PRAGMA journal_mode = WAL;";
			String s=System.getProperty("user.dir");
			String url = "jdbc:sqlite:"+userdir+"\\DB\\Data.Db";
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
			Statement walstatement=conn.createStatement();
			walstatement.executeUpdate(wal);
			System.out.println("Connected");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Disconnected");

		}
		return conn;

	}

	public void insertinDatabase() throws ClassNotFoundException, SQLException, ParseException {

		try {
			time();
			fetchselectionsettingfromDB();
			conn=this.tests();
			Statement inserttime  = conn.createStatement();

			String sqlinsert_1 ="insert into NetworkCopy(DateTime,Info,WithoutAV,WithAV,Unit)values(" ;
			String sqlinsert_2 = "'"+datetime+"','"+"CopyFrom:-\t" +fromlocation +"\tto:-" + tolocation+"','"+""+finishs+"','"+ "0" +"','"+ "Sec" +"')";

			String sqlinsert_3 ="insert into NetworkCopy(DateTime,Info,WithoutAV,WithAV,Unit)values(" ;
			String sqlinsert_4 = "'"+datetime+"','"+ fromlocation +"','"+""+"0"+"','"+ finishs +"','"+ "Sec" +"')";

			String sqlinsert_5 ="update NetworkCopy set WithAV='"+finishs+"' where info='"+"CopyFrom:-\t" +fromlocation +"\tto:-" + tolocation+"'AND rowid=(SELECT count(last_insert_rowid()) from NetworkCopy)";

			String sqlinsert_6 ="update NetworkCopy set WithoutAV='"+finishs+"' where info='"+"CopyFrom:-\t" +fromlocation +"\tto:-" + tolocation+"'AND rowid='(SELECT count(last_insert_rowid()) from NetworkCopy)";
			System.out.println(sqlinsert_5);


			String sqlinsert_Time_in_Db=sqlinsert_1+sqlinsert_2;
			String sqlinsert_Time_WithAntivirus=sqlinsert_3+sqlinsert_4;

			System.out.println(copyselection);

			if(copyselection==0 && scandoneWithoutantivirus==0 && scandoneWithantivirus==0) //FOR SELECTION WITH AND WITHOUT ANTIVIRUS
			{
				try {
					time();
					inserttime.executeQuery(sqlinsert_Time_in_Db);
					inserttime.close();
					conn.close();

				}
				catch(Exception e)
				{

					e.printStackTrace();

				}
			}

			else if(copyselection==1 && scandoneWithoutantivirus==1 )
			{
				{
					try {
						time();

						inserttime.executeQuery(sqlinsert_5);
						inserttime.close();
						conn.close();

					}
					catch(Exception e)
					{
						e.printStackTrace();

					}
				}

			}

			else if(copyselection==1 && scandoneWithantivirus==0 && scandoneWithantivirus==0)
			{

				try {
					time();

					inserttime.executeQuery(sqlinsert_Time_WithAntivirus);
					inserttime.close();
					conn.close();

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

			}

			else if(copyselection==0 && scandoneWithantivirus==1 )
			{
				{
					try {
						time();
						inserttime.executeQuery(sqlinsert_6);
						inserttime.close();
						conn.close();


					}
					catch(Exception e)
					{
						e.printStackTrace();

					}
				}

			}
			else
			{
				JOptionPane.showMessageDialog(null,"DB Insertion Failed ,Please Reset or Change Selection","Failure",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e)
		{

			e.printStackTrace();
		}

	}
	public long[] calculateDirectoryInfo(FTPClient ftpClient, String parentDir, String currentDir) throws IOException
	{
		long[] info = new long[3];
		long totalSize = 0;
		int totalDirs = 0;
		int totalFiles = 0;

		String dirToList = parentDir;
		if (!currentDir.equals("")) {
			dirToList += "/" + currentDir;
		}

		try {
			FTPFile[] subFiles = ftpClient.listFiles(dirToList);

			if (subFiles != null && subFiles.length > 0) {
				for (FTPFile aFile : subFiles) {
					String currentFileName = aFile.getName();
					if (currentFileName.equals(".")
							|| currentFileName.equals("..")) {
						// skip parent directory and the directory itself
						continue;
					}

					if (aFile.isDirectory()) {
						totalDirs++;
						long[] subDirInfo =
								calculateDirectoryInfo(ftpClient, dirToList, currentFileName);
						totalDirs += subDirInfo[0];
						totalFiles += subDirInfo[1];
						totalSize += subDirInfo[2];
					} else {
						totalSize += aFile.getSize();
						totalFiles++;
					}
				}
			}

			info[0] = totalDirs;
			info[1] = totalFiles;
			info[2] = totalSize;

			return info;
		} catch (IOException ex) {
			throw ex;
		}
	}

	public void findtotalfileonftp() throws ClassNotFoundException, SQLException
	{
		fetchselectionsettingfromDB();
		String host = ftpaddr;
		int port = ftpport;
		String username1 = username;
		String password1 = password;

		FTPClient ftpClient = new FTPClient();
		{
			try {
				ftpClient.connect(host, port);
				ftpClient.login(username1, password1);
				ftpClient.enterLocalPassiveMode();
				String fromtrim1= fromlocation.substring(fromlocation.indexOf("/")+2);
				String fromtrim2=fromtrim1.substring(fromtrim1.indexOf("/"));
				String finalspaceremoval=fromtrim2.replaceAll("%20", " ");
				String remotePath1=finalspaceremoval;
				System.out.println("remote"+remotePath1);
				String remoteDirPath = remotePath1;

				long[] dirInfo = calculateDirectoryInfo(ftpClient, remoteDirPath, "");
				System.out.println("Total files: " + dirInfo[1]);
				totalcountonftp=(int) dirInfo[1];

				ftpClient.logout();
				ftpClient.disconnect();
			} catch (IOException ex) {
				System.err.println(ex);

			}
		}
	}

	public  void totalfiledownloadonlocal() throws ClassNotFoundException, SQLException
	{
		fetchselectionsettingfromDB();
		calculateDirectoryInfo(tolocation);
		System. out. println("File Count:"+fileCountonlocal);
	}



	public long[] calculateDirectoryInfo(String dirPath) {
		long[] result = new long[] {0, 0, 0};
		int totalFiles = 0;
		int totalDirs = 0;
		long totalSize = 0;

		File dir = new File(dirPath);

		if (!dir.exists()) {
			throw new IllegalArgumentException("The given path does not exist.");
		}

		if (dir.isFile()) {
			throw new IllegalArgumentException("The given path is a file. A directory is expected.");
		}

		File[] subFiles = dir.listFiles();

		if (subFiles != null && subFiles.length > 0) {
			for (File aFile : subFiles) {
				if (aFile.isFile()) {
					totalFiles++;
					totalSize += aFile.length();
				} else {
					totalDirs++;
					long[] info = calculateDirectoryInfo(aFile.getAbsolutePath());
					totalDirs += info[0];
					totalFiles += info[1];
					totalSize += info[2];
				}
			}


			result[1] = totalFiles;
			fileCountonlocal=(int)result[1];

		}

		return result;
	}
	public void networkcopytimeReport() throws ClassNotFoundException, SQLException, IOException {

		Connection Reportconn = null;

		try {
			String url = "jdbc:sqlite:"+userdir+"\\DB\\Data.Db";
			Class.forName("org.sqlite.JDBC");
			Reportconn = DriverManager.getConnection(url);
			System.out.println("Connected");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Disconnected");

		}
		Statement statement = Reportconn.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from NetworkCopy");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet1 = workbook.createSheet("Network Copy");
		CellStyle style = workbook.createCellStyle();
		XSSFRow row = spreadsheet1.createRow(1);
		XSSFCell cell;

		cell = row.createCell(0);
		cell.setCellValue("DateTime");

		cell = row.createCell(1);
		cell.setCellValue("Info");

		cell = row.createCell(2);
		cell.setCellValue("WithoutAV");

		cell = row.createCell(3);
		cell.setCellValue("WithAV");

		cell = row.createCell(4);
		cell.setCellValue("Unit");

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(3);

		int i = 2;
		while (resultSet.next()) {


			row = spreadsheet1.createRow(i);
			int columncount=0;

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("DateTime"));

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("Info"));

			cell = row.createCell(columncount++);
			double t1=resultSet.getDouble("WithoutAV");
			cell.setCellValue((df.format(t1)));


			cell = row.createCell(columncount++);
			double t2=resultSet.getDouble("WithAV");
			cell.setCellValue((df.format(t2)));


			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("Unit"));
			i++;


			FileOutputStream output = new FileOutputStream(new File(userdir+"\\Report-xslx\\NetworkCopy Time.xlsx"));
			workbook.write(output);
			output.flush();
			output.close();
			System.out.println("exceldatabase.xlsx written successfully" +output);

		}
		resultSet.close();
		statement.close();
		Reportconn.close();
	}



	public void time() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		datetime=dtf.format(now);

	}
	public void deletedirectory(File files) {

		try {
			for (File subfile : files.listFiles()) {

				if (subfile.isDirectory()) {
					deletedirectory(subfile);
				}

				// delete files and empty subfolders
				subfile.delete();
				System.out.println(subfile+"Folder Deleted Successfully");
				conn.close();
			}
		}
		catch(Exception ee) {}
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {


	}
}








