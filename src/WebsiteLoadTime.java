import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebsiteLoadTime {
	String datetime;
	float TotalTimeFromWebsiteloadMethod;
	String Error="";
	Connection conn;
	int iterationcount=3;
	//0=for with Without Antivirus && 1= With Antivirus
	int selection=0;
	int scandoneWithantivirus;
	int scandoneWithoutantivirus;
	List<Float> timewithoutantivirus=new ArrayList<Float>(); 
	float totalavgtime;
	String ip="";
	String userdir=System.getProperty("user.dir");
	int selectionfromdb;
	int scandonewithoutAV;
	int scandonewithtAV;
	int iterationfromdb;
	int progresscount=0;
	int	properclose=0;
	boolean rounddone=false;
	int numberofwebsite;
	boolean shutdown=false;
	public static final String USER_AGENT_INTERNET_EXPLORER = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36";

	public void fetchselectionsettingfromDB() throws ClassNotFoundException, SQLException {

		conn =this.tests(); 
		String sql = " select * from Settings";

		ResultSet rs1 = null;

		Statement stmts  = conn.createStatement();
		rs1= stmts.executeQuery(sql);

		while (rs1.next()) {

			selectionfromdb=rs1.getInt("Selection");
			scandonewithoutAV=rs1.getInt("WithoutScanDone");
			scandonewithtAV=rs1.getInt("WithScanDone");
			iterationfromdb=rs1.getInt("Iteration");

			selection=selectionfromdb;
			scandoneWithoutantivirus=scandonewithoutAV;
			scandoneWithantivirus=scandonewithtAV;
			iterationcount=iterationfromdb;

		}

		rs1.close();
		stmts.close();
		conn.close();
	}
	//	@org.testng.annotations.Test(priority = 1)
	public Connection tests() throws ClassNotFoundException {
		try {
			String wal="PRAGMA journal_mode = WAL;";
			String s=System.getProperty("user.dir");
			String url ="jdbc:sqlite:"+userdir+"\\DB\\Data.Db ";
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
	synchronized public String findinDB() throws ClassNotFoundException, IOException, InterruptedException, SQLException, ParseException, KeyManagementException, NoSuchAlgorithmException{

		fetchselectionsettingfromDB();
		String sql = " select * from Websites";
		float addition=0;
		ResultSet rs = null;

		try {
			conn = this.tests();
			Statement stmt  = conn.createStatement();
			rs= stmt.executeQuery(sql);
			while (rs.next() && shutdown==false) {
				ip=rs.getString("DefaultSite");
				int take_iteration_input=iterationcount;
				progresscount++;//FOR TAKING ITERATION COUNT
				rounddone=false;
				System.out.println(ip);
				do {

					websiteload(ip);//

					//Inserting Website and Time in DB
					timewithoutantivirus.add(TotalTimeFromWebsiteloadMethod);
					take_iteration_input--;
					System.out.println("");


					if(take_iteration_input==0)
					{
						for(float totaltime:timewithoutantivirus) {
							addition=addition+totaltime;
							System.out.println("TT"+totaltime);
							System.out.println("AA"+addition);
						}

						System.out.println("addition time"+addition);
						totalavgtime=(addition/iterationcount);
						System.out.println("TotalAvg"+totalavgtime);
						time();
						insertinDatabase();
						rounddone=true;
						timewithoutantivirus.clear();
						addition=0;
					}
				}while(take_iteration_input!=0 );
			}
			shutdown=false;
			rs.close();
			stmt.close();
			conn.close();
			System.gc();
			if(selection==0 && scandoneWithoutantivirus==0)
			{
				System.out.println("Going for WithoutScanDone=1");
				conn=this.tests();
				String queryscandone="update Settings set WithoutScanDone=1";
				Statement query  = conn.createStatement();
				query.executeQuery(queryscandone);
				conn.close();
				query.close();

			}
			else if(selection==1 && scandoneWithantivirus==0)
			{
				System.out.println("Going for WithScanDone=1");
				conn=this.tests();
				String queryscandone="update Settings set WithScanDone=1";
				Statement query  = conn.createStatement();
				query.executeQuery(queryscandone);
				conn.close();
				query.close();
			}


		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		System.gc();
		return ip;


	}
	public void insertinDatabase() throws SQLException {

		try {


			Statement inserttime  = conn.createStatement();

			String sqlinsert_1 ="insert into WebsiteLoadTime(DateTime,Website,TimeWithoutAntivirus,TimeWithAntivirus,TimeUnit,Iteration)values(" ;
			String sqlinsert_2 = "'"+datetime+"','"+ip+"','"+""+totalavgtime+"','"+ "0" +"','"+ Error +"','"+ iterationcount +"')";

			String sqlinsert_3 ="insert into WebsiteLoadTime(DateTime,Website,TimeWithoutAntivirus,TimeWithAntivirus,TimeUnit,Iteration)values(" ;
			String sqlinsert_4 = "'"+datetime+"','"+ip+"','"+""+"0"+"','"+ totalavgtime +"','"+ Error +"','"+ iterationcount +"')";

			String sqlinsert_5 ="update WebsiteLoadTime set TimeWithAntivirus='"+totalavgtime+"' where Id= (SELECT max(Id) from WebsiteLoadTime Where Website='"+ip+"')";

			String sqlinsert_6 ="update WebsiteLoadTime set TimeWithoutAntivirus='"+totalavgtime+"'where Id= (SELECT max(Id) from WebsiteLoadTime Where Website='"+ip+"')";
			System.out.println(sqlinsert_5);

			String sqlinsert_Time_in_Db=sqlinsert_1+sqlinsert_2;
			String sqlinsert_Time_WithAntivirus=sqlinsert_3+sqlinsert_4;

			System.out.println(selection);

			if(selection==0 && scandoneWithoutantivirus==0 && scandoneWithantivirus==0) //FOR SELECTION WITH AND WITHOUT ANTIVIRUS
			{
				try {
					time();
					inserttime.executeQuery(sqlinsert_Time_in_Db);
					conn.close();
					inserttime.close();
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
						conn.close();
						inserttime.close();
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
					conn.close();
					inserttime.close();
				}
				catch(Exception e)
				{
				}

			}


			else if(selection==0 && scandoneWithantivirus==1 )
			{
				{
					try {
						time();

						inserttime.executeQuery(sqlinsert_6);
						conn.close();
						inserttime.close();
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
		System.out.println("Checking total Time"+totalavgtime);
		System.gc();
		
	}


	public void websiteload(String websitename) throws IOException, NoSuchAlgorithmException, KeyManagementException
	{
		
		float finishs = 0;
		String url = websitename; // replace with the website URL you want to measure
		
		TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
    };
		
		 SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		
		
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            }
	        };
		
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		
		try {
        // Create a URL object and open a connection
        URL websiteURL = new URL(url);
        HttpsURLConnection connection = (HttpsURLConnection) websiteURL.openConnection();
        
       // URLConnection connection = websiteURL.openConnection();
      //  connection.setRequestProperty("User-Agent", USER_AGENT_INTERNET_EXPLORER);
      
        // Measure the time it takes to receive the entire response
        long start = System.currentTimeMillis();
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        while (inputStream.read() != -1); // read the entire response to force the connection to finish
       
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        finishs=(float)totalTime/1000;

        // Print the load time
        System.out.println("Website load time: " + finishs + " seconds");

        // Clean up the connection and input stream
        inputStream.close();
       // connection.disconnect();
       // connection.cl
       // connection.setDoOutput(true);
        Error="Sec";
        TotalTimeFromWebsiteloadMethod=finishs;
		}
        catch(Exception e) {
       	  System.out.println("Unable to Load Website"); 
       	  finishs=0;
       	  TotalTimeFromWebsiteloadMethod=finishs; 
       	  Error="Unable to Load";
       	  System.out.println("Load"+finishs); 
       	  e.printStackTrace();
       	  
       	  } 
		System.gc();
		
    }
	public HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                HostnameVerifier hv =
                        HttpsURLConnection.getDefaultHostnameVerifier();
                return hv.verify("com.example.com", session);
            }
        };
        return hostnameVerifier;
    }
	
	
	
	/*
	 * public void websiteload(String websitename) throws IOException {
	 * 
	 * long totalTime=0; float finishs = 0;
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * userdir+"\\chromedriver\\chromedriver.exe"); ChromeOptions options = new
	 * ChromeOptions(); options.addArguments("start-maximized"); WebDriver driver =
	 * new ChromeDriver(options); //driver.manage().window().maximize(); long start
	 * = System.currentTimeMillis(); try {
	 * 
	 * driver.get(websitename); long finish = System.currentTimeMillis(); totalTime
	 * = finish - start; finishs=(float)totalTime/1000;
	 * System.out.println("Total Loading Time for "+websitename+"\tis - "+finishs
	 * +"Sec"); driver.close(); driver.quit(); Error="Sec";
	 * TotalTimeFromWebsiteloadMethod=finishs; } catch(Exception e) {
	 * System.out.println("Unable to Load Website"); finishs=0;
	 * TotalTimeFromWebsiteloadMethod=finishs; Error="Unable to Load";
	 * System.out.println("Load"+finishs); driver.close(); driver.quit();
	 * e.printStackTrace(); } System.gc(); }
	 */

	public void WebsiteloadtimeReport() throws ClassNotFoundException, SQLException, IOException {

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
		ResultSet resultSet = statement.executeQuery("select * from WebsiteLoadTime");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet1 = workbook.createSheet("WebsiteLoadTime");
		CellStyle style = workbook.createCellStyle();
		XSSFRow row = spreadsheet1.createRow(1);
		XSSFCell cell;


		cell = row.createCell(0);
		cell.setCellValue("DateTime");

		cell = row.createCell(1);
		cell.setCellValue("Website");

		cell = row.createCell(2);
		cell.setCellValue("TimeWithoutAntivirus");

		cell = row.createCell(3);
		cell.setCellValue("TimeWithAntivirus");

		cell = row.createCell(4);
		cell.setCellValue("TimeUnit");

		cell = row.createCell(5);
		cell.setCellValue("Iteration");
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(3);

		int i = 2;
		while (resultSet.next()) {

			row = spreadsheet1.createRow(i);
			int columncount=0;

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("DateTime"));

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("Website"));

			cell = row.createCell(columncount++);
			double t1=resultSet.getDouble("TimeWithoutAntivirus");
			cell.setCellValue((df.format(t1)));


			cell = row.createCell(columncount++);
			double t2=resultSet.getDouble("TimeWithAntivirus");
			cell.setCellValue((df.format(t2)));


			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getString("TimeUnit"));

			cell = row.createCell(columncount++);
			cell.setCellValue(resultSet.getInt("Iteration"));
			i++;

			FileOutputStream output = new FileOutputStream(new File(userdir+"\\Report-xslx\\Website Load Time.xlsx"));
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
	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException, SQLException, ParseException, KeyManagementException, NoSuchAlgorithmException {

		WebsiteLoadTime ws=new WebsiteLoadTime();
		ws.findinDB();
	}

}
