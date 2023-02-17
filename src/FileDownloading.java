import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class FileDownloading{

	Connection conn;
	InstallApplication ia =new InstallApplication();
	long startTime;
	String URLS;
	String datetime;
	float finishs;
	int iteration;
	int selection;
	int withoutAVDone;
	int withAVDone;
	List<Float> timeaddition=new ArrayList<Float>();
	float addition;
	float totalavgtime;
	File file;
	int progresscount=0;
	String userdir=System.getProperty("user.dir");
	boolean shutdown=false;
	String Destinationpath;

	public void fetchfromdb() throws ClassNotFoundException, SQLException {

		conn=ia.tests();
		String query1="select * from settings";
		ResultSet rs12=null;
		Statement st=conn.createStatement();
		rs12=st.executeQuery(query1);

		while(rs12.next())
		{
			selection=rs12.getInt("Linkselection");
			withoutAVDone=rs12.getInt("LinkWithoutAV");
			withAVDone=rs12.getInt("LinkWithAV");
			iteration=rs12.getInt("LinkIteration");
		}

		conn.close();
		rs12.close();
		st.close();
	}


	public void fetchurl() throws ClassNotFoundException, SQLException, IOException, InterruptedException
	{
		conn=ia.tests();
		ResultSet rs1=null;
		String query="select * from DownloadURLS";
		Statement st=conn.createStatement();
		rs1=st.executeQuery(query);

		fetchfromdb();
		while(rs1.next() && shutdown!=true)
		{

			int itrationfromdb=iteration;
			URLS =rs1.getString("Url");
			URL urllink=new URL(URLS);
			String filename=URLS.substring(URLS.lastIndexOf("/")+1);
			Destinationpath="C:\\Windows\\Temp\\"+filename;
			progresscount++;

			do {
				if(shutdown==true)
				{
					break;
				}
				System.out.println("Downloading.."+URLS);
				startTime = System.currentTimeMillis();
				try {
				File theDir = new File("C:\\Windows\\Temp\\");
				if (!theDir.exists()){
				    theDir.mkdirs();
				}
				}
				catch(Exception e)
				{
					
				}
				URLDnldFile(urllink, "C:\\Windows\\Temp\\"+filename);
				long finish = System.currentTimeMillis();
				long totalTime = finish - startTime;
				finishs=(float)totalTime/1000;
				itrationfromdb--;
				System.out.println("Total Installation Time:"+finishs);
				timeaddition.add(finishs);

				if(itrationfromdb==0)
				{
					for(float totaltime:timeaddition) {
						addition=addition+totaltime;

					}
				}

				

			}while(itrationfromdb!=0 && shutdown!=true);

			totalavgtime=(addition/iteration);
			System.out.println("Total Avg time"+totalavgtime);
			insertinDB();
			timeaddition.clear();
			addition=0;
			if(shutdown==true)
			{
				break;
			}	
		}
		
		
		if(selection==0 && withoutAVDone==0)
		{
			System.out.println("Going for WithoutScanDone=1");
			FileUtils.deleteDirectory(new File("C:\\Windows\\Temp\\Max secure total Security\\"));
			conn=ia.tests();
			String queryscandone="update Settings set LinkWithoutAV=1";
			Statement query1  = conn.createStatement();
			query1.executeQuery(queryscandone);
			conn.close();
			query1.close();
			

		}
		else if(selection==1 && withAVDone==0)
		{
			System.out.println("Going for WithScanDone=1");
			FileUtils.deleteDirectory(new File("C:\\Windows\\Temp\\Max secure total Security\\"));
			conn=ia.tests();
			String queryscandone="update Settings set LinkWithAV=1";
			Statement query1  = conn.createStatement();
			query1.executeQuery(queryscandone);
			conn.close();
			query1.close();
			
		}
		
		
		rs1.close();
		st.close();
		System.gc();
		
		
	}
	
	public void insertinDB() throws ClassNotFoundException, SQLException {

		try {
			fetchfromdb();
			conn=ia.tests();
			Statement sts=conn.createStatement();
			time();
			String sql="insert into LinkDownloadTime(DateTime,Url,WithoutAV,WithAV,Iteration)values('"+datetime+"','"+URLS+"','"+totalavgtime+"','0','"+iteration+"')";
			String sql1="insert into LinkDownloadTime(DateTime,Url,WithoutAV,WithAV,Iteration)values('"+datetime+"','"+URLS+"','0','"+totalavgtime+"','"+iteration+"')";
			String update="update LinkDownloadTime set WithAV='"+totalavgtime+"' where Id= (SELECT max(Id) from linkDownloadTime Where Url='"+URLS+"')";
			String update1="update LinkDownloadTime set WithoutAV='"+totalavgtime+"' where Id= (SELECT max(Id) from linkDownloadTime Where Url='"+URLS+"')";

			if(selection==0 && withoutAVDone==0 && withAVDone==0)
			{
				try {
					time();
					sts.executeQuery(sql);
					sts.close();
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else if(selection==1 && withoutAVDone==1)
			{
				try {
					time();
					sts.executeQuery(update);
					sts.close();
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

			}
			else if(selection==1 && withoutAVDone==0 && withAVDone==0)
			{
				try {
					time();
					sts.executeQuery(sql1);
					sts.close();
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

			else if(selection==0 && withAVDone==1)
			{
				try {
					time();
					sts.executeQuery(update1);
					sts.close();
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
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

		}
		System.gc();
	}

	public void time() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		datetime=dtf.format(now);


	}
	public static void URLDnldFile(URL urlink, String fileName) throws IOException{
		try (InputStream inp = urlink.openStream();
				BufferedInputStream bis = new BufferedInputStream(inp);
				FileOutputStream fops = new FileOutputStream(fileName)){

			byte[] d = new byte[1024];
			int i;
			while ((i = bis.read(d, 0, 1024)) != -1){
				fops.write(d, 0, i);
			}

			inp.close();
			bis.close();
			fops.close();
			System.gc();
		}


	}

	public void FiledownloadtimeReport() throws ClassNotFoundException, SQLException, IOException {

		Connection Reportconn = null;

		try {

			String s=System.getProperty("user.dir");
			String url = "jdbc:sqlite:"+userdir+"\\DB\\Data.Db";
			Class.forName("org.sqlite.JDBC");

			Reportconn = DriverManager.getConnection(url);
			System.out.println("Connected");


		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Disconnected");

		}
		Statement statement = Reportconn.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from LinkDownloadTime");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet1 = workbook.createSheet("FileDownloadTime");
		CellStyle style = workbook.createCellStyle();
		XSSFRow row = spreadsheet1.createRow(1);
		XSSFCell cell;


		cell = row.createCell(0);
		cell.setCellValue("Id");

		cell = row.createCell(1);
		cell.setCellValue("DateTime");

		cell = row.createCell(2);
		cell.setCellValue("URL");

		cell = row.createCell(3);
		cell.setCellValue("WithoutAV");

		cell = row.createCell(4);
		cell.setCellValue("WithAV");

		cell = row.createCell(5);
		cell.setCellValue("Iteration");
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(3);

		int i = 2;
		while (resultSet.next()) {


			row = spreadsheet1.createRow(i);
			int columncount=0;

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("Id"));

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("DateTime"));

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("Url")); 

			cell = row.createCell(columncount++);
			double t2=resultSet.getDouble("WithoutAV");
			cell.setCellValue((df.format(t2)));


			cell = row.createCell(columncount++);
			double t1=resultSet.getDouble("WithAV");
			cell.setCellValue(df.format(t1));

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getInt("Iteration"));
			i++;

			FileOutputStream output = new FileOutputStream(new File(userdir+"\\Report-xslx\\File Download Time.xlsx"));
			workbook.write(output);
			output.flush();
			output.close();
			System.out.println("exceldatabase.xlsx written successfully" +output);

		}

	}
	public static void main(String[] args) throws Exception{

		FileDownloading fd=new FileDownloading();

		fd.fetchurl();
	}}