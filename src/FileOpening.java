import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import io.appium.java_client.windows.WindowsDriver;


public class FileOpening {

	InstallApplication ia =new InstallApplication();
	String userdir=System.getProperty("user.dir");
	Connection conn;
	int selectionfromdb;
	int scandonewithoutAV;
	int scandonewithtAV;
	int iteration;
	String filePath;
	String datetime;
	float finishs; 
	String filename = null;
	WiniumDriver driver;
	float addition;
	List<Float> timewithoutantivirus=new ArrayList<Float>();
	float totalavgtime;
	int counts;
	int progresscount=0;
	boolean shutdown=false;

	public void fetchselectionsettingfromDB() throws ClassNotFoundException, SQLException {



		Connection	conns =ia.tests();
		String sql = "select * from Settings";
		ResultSet rs1 = null;
		Statement stmts  = conns.createStatement();
		rs1= stmts.executeQuery(sql);
		while (rs1.next()) {

			selectionfromdb=rs1.getInt("OpenSelection");
			scandonewithoutAV=rs1.getInt("OpenWithoutAvDone");
			scandonewithtAV=rs1.getInt("OpenWithAvDone");
			iteration =rs1.getInt("OpenIteration");
			filePath=rs1.getString("OpenPath");


		}
		conns.close();
		rs1.close();
		stmts.close();
	}

	public void enumnosoffile() throws ClassNotFoundException, SQLException {

		fetchselectionsettingfromDB();
		File Directory = new File(filePath);
		File[] files = Directory.listFiles();
		counts=files.length;
		System.out.println(counts);

	}

	public void startopen() throws InterruptedException, SQLException, ClassNotFoundException, IOException {

		try {
			fetchselectionsettingfromDB();
		}
		catch(Exception e)
		{
			System.out.println("Unable to fetch from DB");
		}
		
		Thread.sleep(1000);

		File Directory = new File(filePath);
		File[] files = Directory.listFiles();
		int count=files.length;
		System.out.println(count);

		do{

			for(int i=0;i<=files.length-1;i++)
			{
				fetchselectionsettingfromDB();
				int newiterate=iteration;
				try {
					filename = files[i].toString();
					progresscount++;
					System.out.println(filename);
					WebElement aboutMe;
					while(newiterate!=0) {
						System.out.println("Running second do");
						DesktopOptions option = new DesktopOptions();
						option.setApplicationPath(filename);
						long start = System.currentTimeMillis();
						driver=new WiniumDriver(new URL("http://localhost:9999"),option);
						WebDriverWait wait = new WebDriverWait(driver,1300);
						aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("File Tab")));
						long finish = System.currentTimeMillis();
						long totalTime = finish - start;
						finishs=(float)totalTime/1000;
						System.out.println("Total Loading Time for is - "+finishs +"Sec");
						timewithoutantivirus.add(finishs);
						newiterate--;
						driver.quit();

						if(newiterate==0)
						{
							for(float totaltime:timewithoutantivirus) {
								addition=addition+totaltime;

							}

						}
						if(shutdown==true)
						{
							break;
						}
					}
					totalavgtime=(addition/iteration);
					insertinDatabase();
					count--;
					timewithoutantivirus.clear();
					addition=0;
					System.out.println("Shutted down final while "+shutdown);
				}

				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Task Done");


				}
				if(shutdown==true)
				{
					break;
				}
			}

			if(shutdown==true)
			{
				break;
			}
		}while(count!=0 && shutdown!=true);



		if(selectionfromdb==0 && scandonewithoutAV==0)
		{
			System.out.println("Going for WithoutAVInstall=1");
			conn=ia.tests();
			String queryscandone="update Settings set OpenWithoutAvDone=1";
			Statement query  = conn.createStatement();
			query.executeQuery(queryscandone);
			query.close();
			conn.close();

		}
		else if(selectionfromdb==1 && scandonewithtAV==0)
		{
			System.out.println("Going for WithAVInstall=1");
			conn=ia.tests();
			String queryscandone="update Settings set OpenWithAvDone=1";
			Statement query  = conn.createStatement();
			query.executeQuery(queryscandone);
			query.close();
			conn.close();


		}
		System.gc();

	}


	public void insertinDatabase() throws ClassNotFoundException, SQLException, ParseException {

		try {
			time();
			fetchselectionsettingfromDB();
			conn=ia.tests();
			Statement inserttime  = conn.createStatement();

			String sqlinsert_1 ="insert into FileOpeningTime(DateTime,Name,WithoutAV,WithAV,Iteration)values(" ;
			String sqlinsert_2 = "'"+datetime+"','"+filename+"','"+""+finishs+"','"+ "0" +"','"+iteration+"')";

			String sqlinsert_3 ="insert into FileOpeningTime(DateTime,Name,WithoutAV,WithAV,Iteration)values(" ;
			String sqlinsert_4 ="'"+datetime+"','"+filename+"','"+ "0" +"','"+finishs+"' ,'"+iteration+"')";

			String sqlinsert_5 ="update FileOpeningTime set WithAV='"+finishs+"' where Id= (SELECT max(Id) from FileOpeningTime Where Name='"+filename+"')";

			String sqlinsert_6 ="update FileOpeningTime set WithoutAV='"+finishs+"' where Id= (SELECT max(Id) from FileOpeningTime Where Name='"+filename+"')";
			System.out.println(sqlinsert_5);


			String sqlinsert_Time_in_Db=sqlinsert_1+sqlinsert_2;
			String sqlinsert_Time_WithAntivirus=sqlinsert_3+sqlinsert_4;

			System.out.println(selectionfromdb);

			if(selectionfromdb==0 && scandonewithoutAV==0 && scandonewithtAV==0) //FOR SELECTION WITH AND WITHOUT ANTIVIRUS
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

			else if(selectionfromdb==1 && scandonewithoutAV==1 )
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

			else if(selectionfromdb==1 && scandonewithoutAV==0 && scandonewithtAV==0)
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

			else if(selectionfromdb==0 && scandonewithtAV==1 )
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
				shutdown=true;
			}
		}
		catch(Exception e)
		{

			e.printStackTrace();
		}
		System.gc();
	}
	public void time() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		datetime=dtf.format(now);

	}
	public void FileopentimeReport() throws ClassNotFoundException, SQLException, IOException {

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
		ResultSet resultSet = statement.executeQuery("select * from FileOpeningTime");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet1 = workbook.createSheet("FileOpenTime");
		CellStyle style = workbook.createCellStyle();
		XSSFRow row = spreadsheet1.createRow(1);
		XSSFCell cell;


		cell = row.createCell(0);
		cell.setCellValue("Id");

		cell = row.createCell(1);
		cell.setCellValue("DateTime");

		cell = row.createCell(2);
		cell.setCellValue("Name");

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
			cell.setCellValue(resultSet.getString("Name"));

			cell = row.createCell(columncount++);
			double t2=resultSet.getDouble("WithoutAV");
			cell.setCellValue((df.format(t2)));


			cell = row.createCell(columncount++);
			double t1=resultSet.getDouble("WithAV");
			cell.setCellValue(df.format(t1));

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getInt("Iteration"));
			i++;

			FileOutputStream output = new FileOutputStream(new File(userdir+"\\Report-xslx\\File Open Time.xlsx"));
			workbook.write(output);
			output.flush();
			output.close();
			System.out.println("exceldatabase.xlsx written successfully" +output);

		}

	}
	

	public static void main(String[] args) throws Exception {

		FileOpening fo=new FileOpening();
	
	}



}
