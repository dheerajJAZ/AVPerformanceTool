import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class InstallApplication {

	int foundservice =0;
	boolean flag1;
	String exe_name_extracted;
	String exe_name_extractedwithexe;
	String parameter;
	long startTime;
	String datetime;
	float finishs;
	int selection;
	int scandoneWithoutantivirus;
	int scandoneWithantivirus;
	Connection conn;
	int terminate=0;
	String userdir=System.getProperty("user.dir");
	String pathfromdb;
	String path;
	int progresscount=0;
	int installid;
	boolean shutdown=false;

	public void fetchselectionsettingfromDB() throws ClassNotFoundException, SQLException {

		conn =this.tests();
		String sql = "select * from Settings";
		ResultSet rs1 = null;
		Statement stmts  = conn.createStatement();
		rs1= stmts.executeQuery(sql);
		while (rs1.next()) {

			int selectionfromdb=rs1.getInt("InstallSelection");
			int scandonewithoutAV=rs1.getInt("WithoutAVInstall");
			int scandonewithtAV=rs1.getInt("WithAVInstall");
			String softwarespath=rs1.getString("SoftInstallPath");

			selection=selectionfromdb;
			scandoneWithoutantivirus=scandonewithoutAV;
			scandoneWithantivirus=scandonewithtAV;
			path=softwarespath;
		}
		conn.close();
		rs1.close();
		stmts.close();
	}

	public Connection tests() throws ClassNotFoundException {

		try {
			String wal="PRAGMA journal_mode = WAL;";
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

	//@org.testng.annotations.Test
	synchronized public void getfilname() throws ClassNotFoundException, SQLException {
		PreparedStatement stmt1 = null;
		ResultSet new1 = null;

		do {
			fetchselectionsettingfromDB();
			String filename = null;
			File Directory = new File(path);
			File[] files = Directory.listFiles();
			for(int i=0;i<files.length;i++)
			{
				filename = files[i].toString();
				System.out.println(filename);
				progresscount++;
				exe_name_extractedwithexe = filename.substring(filename.lastIndexOf("\\") +1);
				exe_name_extracted=exe_name_extractedwithexe.replace(".exe","");
				conn=this.tests();

				ResultSet rs =null;
				Statement stmt  = conn.createStatement();
				String sql="Select * from InstallParam";
				rs= stmt.executeQuery(sql);

				while (rs.next()==true) {
					String name=rs.getString("Software");
					if(exe_name_extracted.contains(name))
					{
						rs.close();
						stmt1  = conn.prepareStatement("select Parameter from InstallParam where Software='"+name+"'");
						new1=stmt1.executeQuery();
						parameter=new1.getString("Parameter");
						conn.close();
						startinstall(exe_name_extractedwithexe,parameter);
						new1.close();
						stmt1.close();
					}
					else {
						terminate=1;
					}
					flag1=false;

					if(shutdown==true)
					{
						break;
					}
				}
				if(shutdown==true)
				{
					break;
				}
			}
		}while(foundservice==1 && terminate==0 && shutdown!=true);

		if(selection==0 && scandoneWithoutantivirus==0)
		{
			System.out.println("Going for WithoutAVInstall=1");
			conn=this.tests();
			String queryscandone="update Settings set WithoutAVInstall=1";
			Statement query  = conn.createStatement();
			query.executeQuery(queryscandone);
			query.close();
			conn.close();

		}
		else if(selection==1 && scandoneWithantivirus==0)
		{
			System.out.println("Going for WithAVInstall=1");
			conn=this.tests();
			String queryscandone="update Settings set WithAVInstall=1";
			Statement query  = conn.createStatement();
			query.executeQuery(queryscandone);
			query.close();
			conn.close();


		}
		flag1=false;
		System.gc();
	}
	//@org.testng.annotations.Test
	public void startinstall(String filename ,String parameterinmethod) {

		try {
			String installCommand = "cmd /c "+path+filename+" "+parameterinmethod;
			//getfilname();
			System.out.println("Install " +installCommand);
			
			startTime = System.currentTimeMillis();
	        Process installProcess = Runtime.getRuntime().exec(installCommand);
	        int installExitCode = installProcess.waitFor();
	        long endTime = System.currentTimeMillis();
	        long totalTime = endTime - startTime;
	        finishs=(float)totalTime/1000;
	        System.out.println("Installation exit code: " + installExitCode);
	        System.out.println("Installation time: " + finishs + " seconds");
	        System.out.println("Installation Finished");
	        time();
	        insertinDatabase();
			
//			ProcessBuilder builder = new ProcessBuilder( "cmd.exe", "/c",path+filename+" "+parameterinmethod );
//			startTime = System.currentTimeMillis();
//			System.out.println(path+filename+" "+parameterinmethod);
//			Process p = builder.start();
//			Thread.sleep(500);
			//install();

			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

//	public boolean install() throws InterruptedException, IOException {
//
//		String[] words=null;
//		String letter = null;
//		boolean flag = false;
//		boolean	present=false;
//		long startTime = System.currentTimeMillis(); //fetch starting time
//		do {
//			flag=false;
//			try {
//				String process1;
//				
//
//				ProcessBuilder builder = new ProcessBuilder( "cmd.exe", "/c","tasklist.exe");
//				Process p = builder.start();
//				BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
//				FileWriter writer = new FileWriter("C:\\Windows\\Temp\\Task.txt");
//				BufferedWriter buffer=new BufferedWriter(writer);
//				while((process1=input.readLine())!=null){
//
//					buffer.write(process1);
//					buffer.newLine();
//				}
//
//				buffer.close();
//
//
//			}
//			catch(Exception e)
//			{
//
//				e.printStackTrace();
//			}
//			//Thread.sleep(2000);
//			File file = new File("C:\\Windows\\Temp\\Task.txt");
//			BufferedReader br = new BufferedReader(new FileReader(file));
//			String st;
//			String s=exe_name_extractedwithexe;
//			String topass=s.substring(0,8);
//			while ((st = br.readLine()) != null)
//			{
//				words=st.split("\t");
//				for (String word:words)
//				{
//					if(word.contains(topass))
//					{
//						present=true;
//						flag=true;
//						foundservice =1;
//						System.out.println("Installing Please Wait.........");
//						break;
//					}
//				}
//			}
//			br.close();
//			//System.out.println("exename"+exe_name_extracted);
//			System.out.println("Checking if Installer in Running or not...");
//
//		}	while(flag==true ||(System.currentTimeMillis()-startTime)<1000);
//
//		if(flag==false && foundservice==1)
//		{
//			System.out.println("Checking For Time.....");
//			long finish = System.currentTimeMillis();
//			long totalTime = finish - startTime;
//			finishs=(float)totalTime/1000;
//			System.out.println("Total Installation Time:"+finishs);
//			time();
//			insertinDatabase();
//			return flag1=true;
//
//		}
//		System.gc();
//		return false;
//
//	}

	public void insertinDatabase() {

		try {
			fetchselectionsettingfromDB();
			conn=this.tests();
			Statement inserttime  = conn.createStatement();
			String sqlinsert_1 ="insert into SoftwareInstallationTime(DateTime,SoftwareName,WithoutAntivirus,WithAntivirus,TimeUnit)values(" ;
			String sqlinsert_2 = "'"+datetime+"','"+exe_name_extractedwithexe+"','"+""+finishs+"','"+ "0" +"','"+ "Sec" +"')";

			String sqlinsert_3 ="insert into SoftwareInstallationTime(DateTime,SoftwareName,WithoutAntivirus,WithAntivirus,TimeUnit)values(" ;
			String sqlinsert_4 = "'"+datetime+"','"+exe_name_extractedwithexe+"','"+ "0" +"','"+""+finishs+"','"+ "Sec" +"')";

			String sqlinsert_5 ="update SoftwareInstallationTime set WithAntivirus='"+finishs+"' where Id= (SELECT max(Id) from SoftwareInstallationTime Where SoftwareName='"+exe_name_extractedwithexe+"')";

			String sqlinsert_6 ="update SoftwareInstallationTime set WithoutAntivirus='"+finishs+"' where Id= (SELECT max(Id) from SoftwareInstallationTime Where SoftwareName='"+exe_name_extractedwithexe+"')";

			String sqlinsert_Time_in_Db=sqlinsert_1+sqlinsert_2;
			String sqlinsert_Time_WithAntivirus=sqlinsert_3+sqlinsert_4;
			System.out.println(sqlinsert_5);
			System.out.println(sqlinsert_6);


			if(selection==0 && scandoneWithoutantivirus==0 && scandoneWithantivirus==0) //FOR SELECTION WITH AND WITHOUT ANTIVIRUS
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

			else if(selection==1 && scandoneWithoutantivirus==1 )
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


					}
				}

			}
			else if(selection==1 && scandoneWithantivirus==0 && scandoneWithantivirus==0)
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

			else if(selection==0 && scandoneWithantivirus==1 )
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
						System.out.println("Uanble to Insert in DB selection 2");


					}
				}

			}
			else
			{
				JOptionPane.showMessageDialog(null,"DB Insertion Failed ,Please Reset or Change Selection","Failure",JOptionPane.ERROR_MESSAGE);
				shutdown=true;
			}
		}
		catch(Exception e)
		{

			e.printStackTrace();
		}
		System.gc();
	}

	public void installationtimeReport() throws ClassNotFoundException, SQLException, IOException {

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
		ResultSet resultSet = statement.executeQuery("select * from SoftwareInstallationTime");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet1 = workbook.createSheet("Software Installation");
		CellStyle style = workbook.createCellStyle();
		XSSFRow row = spreadsheet1.createRow(1);
		XSSFCell cell;


		cell = row.createCell(0);
		cell.setCellValue("DateTime");

		cell = row.createCell(1);
		cell.setCellValue("SoftwareName");

		cell = row.createCell(2);
		cell.setCellValue("WithoutAntivirus");

		cell = row.createCell(3);
		cell.setCellValue("WithAntivirus");

		cell = row.createCell(4);
		cell.setCellValue("TimeUnit");

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(3);



		int i = 2;
		while (resultSet.next()) {

			row = spreadsheet1.createRow(i);
			int columncount=0;

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("DateTime"));

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("SoftwareName"));

			cell = row.createCell(columncount++);
			double t1=resultSet.getDouble("WithoutAntivirus");
			cell.setCellValue((df.format(t1)));


			cell = row.createCell(columncount++);
			double t2=resultSet.getDouble("WithAntivirus");
			cell.setCellValue((df.format(t2)));


			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("TimeUnit"));
			i++;


			FileOutputStream output = new FileOutputStream(new File(userdir+"\\Report-xslx\\SoftwareInstallation Time.xlsx"));
			workbook.write(output);
			output.flush();
			output.close();

			System.out.println("exceldatabase.xlsx written successfully" +output);

		}

	}


	public void time() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		datetime=dtf.format(now);

	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		InstallApplication ia=new InstallApplication();
		ia.getfilname();
	}
}

