import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.apache.commons.math3.linear.IllConditionedOperatorException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.SessionNotCreatedException;
import org.sqlite.SQLiteException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Button;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import schemasMicrosoftComOfficeOffice.DetectmouseclickAttribute;

import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.JProgressBar;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JCheckBox;
import java.awt.Window.Type;
import javax.swing.JLayeredPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	JTabbedPane tabbedPane;
	private JTextField textField;
	Connection conn;
	WebsiteLoadTime ws = new WebsiteLoadTime();
	InstallApplication is=new InstallApplication();
	FileOpening fo=new FileOpening();
	FileDownloading fd=new FileDownloading();
	FileCopy fc=new FileCopy();
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_5; 
	JButton btnNewButton_6;
	JButton btnNewButton_1_1;
	JButton btnNewButton_1_2;
	JButton btnNewButton_2_1;
	JButton btnNewButton_1_4;
	Thread t1;
	Thread t1_1;//for launching start
	Thread t2;
	Thread t3;
	Thread t4;
	Thread t5;
	Thread t6;
	Thread t7;
	Thread t8;
	Thread t9;
	Thread t10;
	Thread t11;
	Thread t12;//for launching progress bar
	Thread t4_1;
	Thread t5_1;
	Thread t8_1;

	JProgressBar progressBar; //for website load
	JProgressBar progressBar_1;
	JProgressBar progressBar_2;//for software installtion
	JProgressBar progressBar_3;
	JProgressBar progressBar_4;
	JPanel panel_8;
	JPanel panel_10;
	JPanel panel_11;
	JPanel panel_13;
	JPanel panel_9;

	int numberofwebsite;
	String directory=System.getProperty("user.dir");
	int numberofsoft;
	int numberofdownloadlink;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_4;
	private JTextField textField_5;
	static JTable table;
	ResultSet rs, rs1;
	Statement st, st1;
	JPanel panel_12;
	PreparedStatement pst;
	String textforsoftadderrorhandling;
	Image Reset;
	ImageIcon maxsecurereporticon;
	ImageIcon failed;
	ImageIcon green;
	ButtonGroup g;
	ButtonGroup h;
	ButtonGroup i;
	ButtonGroup j;
	ButtonGroup k;
	JLabel lblNewLabel_10;
	Image newimg101;
	JButton btnNewButton_5_1;
	JButton btnNewButton_5_1_2;///
	JRadioButton rdbtnNewRadioButton_2_2;
	JRadioButton rdbtnNewRadioButton_2_1_1;

	String url;
	String website;
	String softwarename;
	String netwrkcopyfilename;
	String fileopenname;

	//SelectionfromdbSetting
	int selectionfromdb;
	int selecWebsite;
	int iterationfromdb;
	String softwarespath;
	int Copyselec;
	int ports;
	String user;
	String pass;
	String from;
	String to;
	String ftp;
	int ftpdelflag;
	int linkSelection;
	int linkiteration;
	int loopincountfo;

	int opensele;
	int openinteration;
	String Openpath;
	boolean clickedWlt=false;
	boolean clickedfdt=false;
	boolean clickedsit=false;
	boolean clickednc=false;
	boolean clickedfileop=false;
	boolean clickedreport=false;
	

	JPanel panel_2;
	JPanel panel_3;
	JPanel panel_4;
	JPanel panel_5;
	JPanel panel_6;
	JPanel panel_6_1;
	BasicProgressBarUI ui;
	Image newimg11;
	static String userdir=System.getProperty("user.dir");

	String[] columnNamesforsoftwareinstall = {"DateTime", "SoftwareName", "WithoutAntivirus", "WithAntivirus","TimeUnit"};
	String[] columnNamesforWebsiteLoadTime = {"DateTime", "Website", "WithoutAntivirus", "WithAntivirus","TimeUnit","Iteration"};
	String[] columnNamesfornetworkcopy = {"DateTime", "Info", "WithoutAntivirus", "WithAntivirus","TimeUnit"};
	String[] columnNamesforFileOpening = {"DateTime", "Name", "WithoutAV", "WithAV","Iteration"};
	String[] columnNamesforFiledownloading = {"DateTime", "URL", "WithoutAV", "WithAV","Iteration"};

	JInternalFrame internalFrame;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ProcessBuilder p= new ProcessBuilder(userdir+"\\chromedriver\\Winium.Desktop.Driver.exe");
					p.start();
					Main frame = new Main();
					frame.setVisible(true);
					frame.setResizable(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	public Main() throws ClassNotFoundException, SQLException, ParseException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				try {

					Runtime.getRuntime().exec("TASKKILL /F /IM Winium.Desktop.Driver.exe");
				} 
				catch(Exception e9)
				{
					System.out.println("Winium Driver Already Terminated");
				}
			}
		});
		setResizable(false);
		setForeground(Color.LIGHT_GRAY);
		getsettingindb();

		ImageIcon reset = new ImageIcon(directory+"\\Icon\\reset.png");
		Image reset1 = reset.getImage();
		Reset = reset1.getScaledInstance(40, 40,java.awt.Image.SCALE_SMOOTH);

		ImageIcon icon =new ImageIcon(directory+"\\Icon\\internet.png");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

		ImageIcon icon1 =new ImageIcon(directory+"\\Icon\\download.png");
		Image img1 = icon1.getImage();
		Image newimg1 = img1.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);


		ImageIcon icon77 =new ImageIcon(directory+"\\Icon\\start.png");
		Image img77 = icon77.getImage();
		Image newimg77 = img77.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);

		ImageIcon icon88 =new ImageIcon(directory+"\\Icon\\stop.png");
		Image img88 = icon88.getImage();
		Image newimg88 = img88.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);

		green =new ImageIcon(directory+"\\Icon\\greentick.png");
		Image green1 = green.getImage();
		Image green11 = green1.getScaledInstance(60, 50,java.awt.Image.SCALE_SMOOTH);
		green = new ImageIcon(green11);

		failed = new ImageIcon(directory+"\\Icon\\failed.png");
		Image failed1 = failed.getImage();
		Image failed11 = failed1.getScaledInstance(60, 50,java.awt.Image.SCALE_SMOOTH);
		failed = new ImageIcon(failed11);

		ImageIcon icon14 =new ImageIcon(directory+"\\Icon\\Reports.png");
		Image img14 = icon14.getImage();
		Image newimg14 = img14.getScaledInstance(60, 50, java.awt.Image.SCALE_SMOOTH);

		ImageIcon icon20 =new ImageIcon(directory+"\\Icon\\plus.png");
		Image img20 = icon20.getImage();
		Image newimg20 = img20.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);

		ImageIcon icon10 =new ImageIcon(directory+"\\Icon\\maxsecureicon.png");
		Image img10 = icon10.getImage();
		Image newimg10 = img10.getScaledInstance(18, 18, java.awt.Image.SCALE_SMOOTH);
		maxsecurereporticon =new ImageIcon(newimg10);

		ImageIcon icon101 =new ImageIcon(directory+"\\Icon\\apply.png");
		Image img101 = icon101.getImage();
		newimg101= img101.getScaledInstance(60, 50, java.awt.Image.SCALE_SMOOTH);

		ImageIcon icon11 =new ImageIcon(directory+"\\Icon\\Reports.png");
		Image img11 = icon11.getImage();
		newimg11= img11.getScaledInstance(60, 50, java.awt.Image.SCALE_SMOOTH);


		ui = new BasicProgressBarUI() {
			@Override
			protected Color getSelectionBackground() {
				return Color.black; // string color over the background
			}
			@Override
			protected Color getSelectionForeground() {
				return Color.black; // string color over the foreground
			}
		};

		setBackground(Color.LIGHT_GRAY);
		setTitle("Performance Testing Tool");
		setIconImage(Toolkit.getDefaultToolkit().getImage(directory+"\\Icon\\oneclicklogosingle.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 585);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		System.out.println(directory);
		JPanel panel = new JPanel();

		panel.setBounds(22, 0, 254, 546);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		ImageIcon mainicon =new ImageIcon(directory+"\\Icon\\oneclicklogo.png");
		Image mainicon1 = mainicon.getImage();
		Image companyicon = mainicon1.getScaledInstance(110, 100, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(companyicon));
		lblNewLabel.setBounds(64, 0, 179, 104);

		panel.add(lblNewLabel);

		panel_2= new JPanel();

		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(clickedWlt==true)return;
				panel_2.setBackground(new Color(240,240,240));

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setBackground(new Color(173,255,47));
				tabbedPane.setSelectedIndex(0);
				clickedWlt=true;
				clickedfdt=false;
				clickedsit=false;
				clickednc=false;
				clickedfileop=false;
				clickedreport=false;
				panel_3.setBackground(new Color(240,240,240));
				panel_4.setBackground(new Color(240,240,240));
				panel_5.setBackground(new Color(240,240,240));
				panel_6.setBackground(new Color(240,240,240));
				panel_6_1.setBackground(new Color(240,240,240));

			}

		});
		panel_2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {

				panel_2.setBackground(new Color(173,255,47));

			}
		});
		panel_2.setBackground(new Color(173,255,47));
		panel_2.setBounds(0, 104, 253, 60);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(newimg));
		lblNewLabel_1.setBounds(10, 0, 49, 60);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Website Loading");
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_2.setBounds(62, 0, 181, 60);
		panel_2.add(lblNewLabel_2);

		panel_3 = new JPanel();
		panel_3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				panel_3.setBackground(new Color(173,255,47));
			}
		});
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(clickedfdt==true)return;

				panel_3.setBackground(new Color(240,240,240));
			}
		});
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_3.setBackground(new Color(173,255,47));
				tabbedPane.setSelectedIndex(1);
				clickedfdt=true;
				clickedWlt=false;
				clickedsit=false;
				clickednc=false;
				clickedfileop=false;
				clickedreport=false;
				panel_2.setBackground(new Color(240,240,240));
				panel_4.setBackground(new Color(240,240,240));
				panel_5.setBackground(new Color(240,240,240));
				panel_6.setBackground(new Color(240,240,240));
				panel_6_1.setBackground(new Color(240,240,240));
			}
		});

		panel_3.setBounds(0, 174, 253, 60);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");

		lblNewLabel_3.setIcon(new ImageIcon(newimg1));
		lblNewLabel_3.setBounds(10, 0, 49, 60);
		panel_3.add(lblNewLabel_3);

		JLabel lblNewLabel_2_1 = new JLabel("File Downloading");
		lblNewLabel_2_1.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(62, 0, 191, 60);
		panel_3.add(lblNewLabel_2_1);

		panel_4 = new JPanel();
		panel_4.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				panel_4.setBackground(new Color(173,255,47));
			}
		});
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(clickedsit==true)return;
				panel_4.setBackground(new Color(240,240,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
				clickedsit=true;
				clickedWlt=false;
				clickedfdt=false;
				clickednc=false;
				clickedfileop=false;
				clickedreport=false;
				panel_4.setBackground(new Color(173,255,47));
				panel_2.setBackground(new Color(240,240,240));
				panel_3.setBackground(new Color(240,240,240));
				panel_5.setBackground(new Color(240,240,240));
				panel_6.setBackground(new Color(240,240,240));
				panel_6_1.setBackground(new Color(240,240,240));
			}
		});
		panel_4.setBounds(0, 245, 253, 60);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		ImageIcon icon3 =new ImageIcon(directory+"\\Icon\\layers.png");
		Image img3 = icon3.getImage();
		Image newimg3 = img3.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg1);

		lblNewLabel_4.setIcon(new ImageIcon(newimg3));
		lblNewLabel_4.setBounds(10, 0, 49, 60);
		panel_4.add(lblNewLabel_4);

		JLabel lblNewLabel_2_1_1 = new JLabel("Software Installation");
		lblNewLabel_2_1_1.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_2_1_1.setBounds(59, 0, 194, 60);
		panel_4.add(lblNewLabel_2_1_1);

		panel_5 = new JPanel();
		panel_5.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				panel_5.setBackground(new Color(173,255,47));

			}
		});
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(clickednc==true)return;
				panel_5.setBackground(new Color(240,240,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				panel_5.setBackground(new Color(173,255,47));
				tabbedPane.setSelectedIndex(3);
				clickedfileop=false;
				clickednc=true;
				clickedWlt=false;
				clickedsit=false;
				clickedfdt=false;
				clickedreport=false;
				panel_4.setBackground(new Color(240,240,240));
				panel_2.setBackground(new Color(240,240,240));
				panel_3.setBackground(new Color(240,240,240));
				panel_6.setBackground(new Color(240,240,240));
				panel_6_1.setBackground(new Color(240,240,240));
			}
		});
		panel_5.setBounds(0, 316, 253, 60);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		ImageIcon icon4 =new ImageIcon(directory+"\\Icon\\folder.png");
		Image img4 = icon4.getImage();
		Image newimg4 = img4.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg4);
		lblNewLabel_5.setIcon(new ImageIcon(newimg4));
		lblNewLabel_5.setBounds(10, 0, 49, 60);
		panel_5.add(lblNewLabel_5);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Network Copy");
		lblNewLabel_2_1_1_1.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_2_1_1_1.setBounds(62, 0, 191, 60);
		panel_5.add(lblNewLabel_2_1_1_1);

		panel_6 = new JPanel();
		panel_6.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				panel_6.setBackground(new Color(173,255,47));
			}
		});
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(clickedfileop==true)return;
				panel_6.setBackground(new Color(240,240,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				panel_6.setBackground(new Color(173,255,47));
				tabbedPane.setSelectedIndex(5);
				clickedfileop=true;
				clickedsit=false;
				clickedWlt=false;
				clickedfdt=false;
				clickednc=false;
				clickedreport=false;

				panel_4.setBackground(new Color(240,240,240));
				panel_2.setBackground(new Color(240,240,240));
				panel_3.setBackground(new Color(240,240,240));
				panel_5.setBackground(new Color(240,240,240));
				panel_6_1.setBackground(new Color(240,240,240));
			}
		});
		panel_6.setBounds(0, 387, 253, 60);
		panel.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("");
		ImageIcon icon5 =new ImageIcon(directory+"\\Icon\\browser.png");
		Image img5 = icon5.getImage();
		Image newimg5 = img5.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg5);
		lblNewLabel_6.setIcon(new ImageIcon(newimg5));
		lblNewLabel_6.setBounds(10, 0, 49, 60);
		panel_6.add(lblNewLabel_6);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("File Opening");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_2_1_1_1_1.setBounds(62, 0, 191, 60);
		panel_6.add(lblNewLabel_2_1_1_1_1);

		panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBounds(0, 458, 253, 60);
		panel.add(panel_6_1);

		panel_6_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {

				panel_6_1.setBackground(new Color(173,255,47));
			}
		});
		panel_6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(clickedreport==true)return;
				panel_6_1.setBackground(new Color(240,240,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				panel_6_1.setBackground(new Color(173,255,47));
				tabbedPane.setSelectedIndex(4);
				clickedWlt=false;
				clickedfdt=false;
				clickedsit=false;
				clickednc=false;
				clickedfileop=false;
				clickedreport=true;
				panel_3.setBackground(new Color(240,240,240));
				panel_4.setBackground(new Color(240,240,240));
				panel_5.setBackground(new Color(240,240,240));
				panel_6.setBackground(new Color(240,240,240));
				panel_2.setBackground(new Color(240,240,240));

			}
		});

		JLabel lblNewLabel_6_1 = new JLabel("");
		ImageIcon icon23 =new ImageIcon(directory+"\\Icon\\document.png");
		Image img23= icon23.getImage();
		Image newimg23 = img23.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg23);
		lblNewLabel_6_1.setIcon(new ImageIcon(newimg23));
		lblNewLabel_6_1.setBounds(10, 0, 49, 60);
		panel_6_1.add(lblNewLabel_6_1);

		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Reports");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_2_1_1_1_1_1.setBounds(62, 0, 191, 60);
		panel_6_1.add(lblNewLabel_2_1_1_1_1_1);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(52, 152, 219)); //Orange
		panel_7.setBounds(0, 0, 23, 546);
		contentPane.add(panel_7);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(274, -30, 635, 586);
		contentPane.add(tabbedPane);

		panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_8, null);
		panel_8.setLayout(null);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Scan Without Antivirus");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					conn=ws.tests();
					String sql="update Settings set Selection=0";
					Statement query  = conn.createStatement();
					query.executeQuery(sql);
					conn.close();

				} catch (ClassNotFoundException | SQLException e1) {


				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton.setBackground(SystemColor.text);
		rdbtnNewRadioButton.setBounds(131, 94, 171, 34);
		panel_8.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Scan With Antivirus");
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


				try {
					conn=ws.tests();
					String sql="update Settings set Selection=1";
					Statement query  = conn.createStatement();
					query.executeQuery(sql);
					conn.close();

				} catch (ClassNotFoundException | SQLException e1) {


				}
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_1.setBackground(SystemColor.text);
		rdbtnNewRadioButton_1.setBounds(320, 94, 171, 34);
		panel_8.add(rdbtnNewRadioButton_1);

		g= new ButtonGroup();
		g.add(rdbtnNewRadioButton_1);
		g.add(rdbtnNewRadioButton);
		g.getElements();
		int select=selecWebsite;
		System.out.println("selection:-"+select);
		if(select==0)
		{
			rdbtnNewRadioButton.setSelected(true);
		}
		else if(select==1)
		{
			rdbtnNewRadioButton_1.setSelected(true);
		}

		JLabel lblNewLabel_7 = new JLabel("Add Websites:-");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(32, 141, 99, 14);
		panel_8.add(lblNewLabel_7);

		textField = new JTextField();
		textField.setBounds(118, 135, 416, 26);
		panel_8.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text =textField.getText();
				System.out.println(text);

				if(text.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter Website ..Blank is not Allowed","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}
				else if(!text.equals(""))
				{
					try {
						conn=ws.tests();
						String sql="insert into Websites(DefaultSite) values('https://"+text+"')";
						Statement query = conn.createStatement(); query.executeUpdate(sql);

						JOptionPane.showMessageDialog(null,"Added Sucessfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
						conn.close();
					}
					catch(Exception e3)
					{
						e3.printStackTrace();

						JOptionPane.showMessageDialog(null,"Unable to Add Please Check DB","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
					}
				}

			}

		});

		btnNewButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton.setBackground(new Color(173,255,47));
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(240,240,240));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnNewButton.setBorder(emptyBorder);
		btnNewButton.setBackground(SystemColor.text);
		ImageIcon icon6 =new ImageIcon(directory+"\\Icon\\plus.png");
		Image img6 = icon6.getImage();
		Image newimg6 = img6.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg6);
		btnNewButton.setIcon(new ImageIcon(newimg6));
		btnNewButton.setBounds(540, 133, 90, 29);
		panel_8.add(btnNewButton);

		JLabel lblNewLabel_7_1 = new JLabel("Number of Iteration:-");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1.setBounds(32, 228, 131, 14);
		panel_8.add(lblNewLabel_7_1);


		int iterate=iterationfromdb;
		SpinnerModel sm = new SpinnerNumberModel(iterate, 1, 100, 1); //default value,lower bound,upper bound,increment by
		JSpinner spinner = new JSpinner(sm);
		spinner.setBackground(SystemColor.activeCaption);
		spinner.setValue(Integer.valueOf(iterate));
		JFormattedTextField tf = ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField();
		tf.setEditable(false);
		spinner.setBounds(162, 223, 61, 24);
		panel_8.add(spinner);

		JLabel lblNewLabel_8_1 = new JLabel("*Note:- Number of Times You want to open Website");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_1.setForeground(Color.RED);
		lblNewLabel_8_1.setBounds(108, 281, 416, 14);
		panel_8.add(lblNewLabel_8_1);

		JLabel lblNewLabel_8_1_1 = new JLabel("*Note:- Entered Website will be Added in Database");
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_1_1.setForeground(Color.RED);
		lblNewLabel_8_1_1.setBounds(108, 172, 416, 14);
		panel_8.add(lblNewLabel_8_1_1);

		btnNewButton_1 = new JButton("");//start button
		btnNewButton_1.setIcon(new ImageIcon(newimg77));
		btnNewButton_1.setBorder(emptyBorder);

		btnNewButton_2 = new JButton("");//stop button
		btnNewButton_2.setIcon(new ImageIcon(newimg88));
		btnNewButton_2.setBorder(emptyBorder);

		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean clicked=true;

				btnNewButton_1.setVisible(false);
				btnNewButton_2.setVisible(true);
				clicked=false;
				Demothread d=new Demothread();
				Demothread1 d1=new Demothread1();
				try {
					t1=new Thread(d);
					t1.start();
					Enumeration<AbstractButton> enumeration = g.getElements();
					while (enumeration.hasMoreElements()) {
						enumeration.nextElement().setEnabled(false);

					}

					System.out.println(g.getButtonCount());
				}
				catch(Exception e2)
				{
				}

				t2=new Thread(d1);
				t2.start();

				Demothread12 d3=new Demothread12();
				t7=new Thread(d3);

				webisteloadingtext f4=new webisteloadingtext();
				t1_1=new Thread(f4);
				t1_1.start();



			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean clicked=true;
				if(clicked=true) {

					btnNewButton_2.setVisible(false);
					btnNewButton_1.setVisible(true);
					clicked=false;
					if(t1.isAlive()==true)
					{

						ws.shutdown=true;
						Enumeration<AbstractButton> enumeration = g.getElements();
						while (enumeration.hasMoreElements()) {
							enumeration.nextElement().setEnabled(true);
						}


						//t1.stop();
						//t2.stop();
					}

				}

			}
		});
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setBounds(262, 405, 114, 47);

		btnNewButton_2.setBackground(SystemColor.text);
		btnNewButton_2.setBounds(262, 405, 114, 47);
		panel_8.add(btnNewButton_1);
		panel_8.add(btnNewButton_2);

		JLabel lblNewLabel_2_2 = new JLabel("Website Loading Time");
		lblNewLabel_2_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2_2.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		lblNewLabel_2_2.setBounds(189, 27, 266, 60);
		panel_8.add(lblNewLabel_2_2);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					spinner.commitEdit();
				} catch ( java.text.ParseException ef )
				{

				}
				int value = (Integer) spinner.getValue();
				System.out.println(value);

				try {
					conn=ws.tests();
					String sql="update Settings set Iteration=='"+value+"'";
					Statement query  = conn.createStatement();
					query.executeUpdate(sql);

					JOptionPane.showMessageDialog(null,"Applied Sucessfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
					conn.close();

				} catch (SQLException e1) {


					JOptionPane.showMessageDialog(null,"Failed to Apply!!! Please Check DB","Failure",JOptionPane.INFORMATION_MESSAGE,failed);

				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				}
			}

		});
		lblNewLabel_8.setIcon(new ImageIcon(newimg101));
		lblNewLabel_8.setBounds(254, 223, 99, 47);
		panel_8.add(lblNewLabel_8);


		JLabel lblNewLabel_7_1_1 = new JLabel("Progress:-");
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1.setBounds(35, 331, 68, 14);
		panel_8.add(lblNewLabel_7_1_1);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_3.setBackground(new Color(173,255,47));
			}
		});
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3.setBackground(new Color(240,240,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					ws.WebsiteloadtimeReport();
					JEditorPane myPane = new JEditorPane();
					myPane.setContentType("text/html");
					String location=System.getProperty("user.dir");
					myPane.setText("Report Generated Successfully <br><a href>"+location+"\\Report-xslx\\Website Load Time.xlsx");
					JOptionPane.showMessageDialog(null,myPane,"Success",JOptionPane.INFORMATION_MESSAGE,green);

				}
				catch(Exception e6){

					JOptionPane.showMessageDialog(null,"Failed to Generate Report!!!","Failure",JOptionPane.INFORMATION_MESSAGE,failed);


				}
			}


		});

		btnNewButton_3.setIcon(new ImageIcon(newimg11));
		btnNewButton_3.setBorder(emptyBorder);
		btnNewButton_3.setBounds(532, 468, 61, 51);
		Border emptyBorder1 = BorderFactory.createEmptyBorder();
		btnNewButton_3.setBorder(emptyBorder1);
		btnNewButton_3.setBackground(SystemColor.text);


		panel_8.add(btnNewButton_3);

		JLabel lblNewLabel_7_1_1_1 = new JLabel("Generate Reports");
		lblNewLabel_7_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_1.setBounds(510, 521, 114, 14);
		panel_8.add(lblNewLabel_7_1_1_1);

		JButton btnNewButton_9_2 = new JButton("");
		btnNewButton_9_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					conn=ws.tests();
					String Sql="update Settings set Selection=0 ,WithoutScanDone=0,WithScanDone=0";
					Statement st=conn.createStatement();
					st.executeUpdate(Sql);

					JOptionPane.showMessageDialog(null,"Reset Successful to Default","Success",JOptionPane.INFORMATION_MESSAGE,green);
					conn.close();

				} catch (SQLException | ClassNotFoundException e1) {

					e1.printStackTrace();

					JOptionPane.showMessageDialog(null,"Reset Unsuccessful to Default","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}
			}
		});
		btnNewButton_9_2.setIcon(new ImageIcon(Reset));
		btnNewButton_9_2.setBackground(Color.WHITE);
		btnNewButton_9_2.setBorder(emptyBorder1);
		btnNewButton_9_2.setBounds(565, 27, 40, 40);

		panel_8.add(btnNewButton_9_2);

		JLabel lblNewLabel_9_2 = new JLabel("     Reset DB");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9_2.setBounds(544, 68, 80, 14);
		panel_8.add(lblNewLabel_9_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(620, 0, 10, 10);
		panel_8.add(panel_1);


		JButton btnNewButton_10 = new JButton("See website present in DB");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


				DefaultTableModel model = new DefaultTableModel();
				String[] columnNameswebsite = {"Websites"};
				model.setColumnIdentifiers(columnNameswebsite);
				JTable table = new JTable();
				table.setModel(model);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(table);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


				String Websites = "";

				try {

					conn=is.tests();
					pst = conn.prepareStatement("select * from Websites");
					ResultSet rs = pst.executeQuery();
					int i = 0;
					while (rs.next()) {
						Websites = rs.getString("DefaultSite");

						model.addRow(new Object[]{Websites});
						i++;
					}
					if (i < 1) {
						JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

					}
					if (i == 1) {
						System.out.println(i + " Record Found");
					} else {
						System.out.println(i + " Records Found");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

				JOptionPane.showMessageDialog(null ,new JScrollPane(table));

			}
		});
		btnNewButton_10.setBounds(446, 212, 171, 23);
		//	panel_8.add(btnNewButton_10);




		panel_9= new JPanel();
		panel_9.setBackground(SystemColor.WHITE);
		tabbedPane.addTab("New tab", null, panel_9, null);
		panel_9.setLayout(null);

		JLabel lblNewLabel_2_2_1_2 = new JLabel("File Downloading Time");
		lblNewLabel_2_2_1_2.setBounds(186, 34, 280, 40);
		lblNewLabel_2_2_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2_2_1_2.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		panel_9.add(lblNewLabel_2_2_1_2);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Scan Without Antivirus");
		rdbtnNewRadioButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


				try {
					conn=ws.tests();
					String sql="update Settings set LinkSelection=0";
					Statement query  = conn.createStatement();
					query.executeQuery(sql);
					conn.close();

				} catch (ClassNotFoundException | SQLException e1) {


				}
			}
		});
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_3.setBackground(Color.WHITE);
		rdbtnNewRadioButton_3.setBounds(141, 96, 171, 34);
		panel_9.add(rdbtnNewRadioButton_3);

		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Scan With Antivirus");
		rdbtnNewRadioButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


				try {
					conn=ws.tests();
					String sql="update Settings set LinkSelection=1";
					Statement query  = conn.createStatement();
					query.executeQuery(sql);
					conn.close();

				} catch (ClassNotFoundException | SQLException e1) {


				}
			}
		});

		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_1_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1_1.setBounds(330, 96, 171, 34);
		panel_9.add(rdbtnNewRadioButton_1_1);

		k= new ButtonGroup();
		k.add(rdbtnNewRadioButton_3);
		k.add(rdbtnNewRadioButton_1_1);

		int select1=linkSelection;
		if(select1==0)
		{
			rdbtnNewRadioButton_3.setSelected(true);
		}
		else if(select1==1)
		{
			rdbtnNewRadioButton_1_1.setSelected(true);
		}

		JLabel lblNewLabel_7_2 = new JLabel("Add Link:-");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_2.setBounds(47, 158, 68, 14);
		panel_9.add(lblNewLabel_7_2);

		JLabel lblNewLabel_7_1_3 = new JLabel("Number of Iteration:-");
		lblNewLabel_7_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_3.setBounds(47, 231, 131, 14);
		panel_9.add(lblNewLabel_7_1_3);

		int iterate1=linkiteration;
		SpinnerModel sm2 = new SpinnerNumberModel(iterate1, 1, 100, 1);
		JSpinner spinner_1 = new JSpinner(sm2);
		spinner_1.setBackground(SystemColor.activeCaption);
		spinner_1.setValue(Integer.valueOf(iterate1));
		JFormattedTextField tf2 = ((JSpinner.DefaultEditor)spinner_1.getEditor()).getTextField();
		tf2.setEditable(false);
		spinner_1.setBounds(173, 226, 61, 24);
		panel_9.add(spinner_1);

		JLabel lblNewLabel_8_3 = new JLabel("");
		lblNewLabel_8_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					spinner_1.commitEdit();
				} catch ( java.text.ParseException ef )
				{

				}
				int value = (Integer) spinner_1.getValue();
				System.out.println(value);

				try {
					conn=ws.tests();
					String sql="update Settings set LinkIteration=='"+value+"'";
					Statement query  = conn.createStatement();
					query.executeUpdate(sql);

					JOptionPane.showMessageDialog(null,"Applied Sucessfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
					conn.close();

				} catch (SQLException e1) {


					JOptionPane.showMessageDialog(null,"Failed to Apply!!! Please Check DB","Failure",JOptionPane.INFORMATION_MESSAGE,failed);

				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				}
			}

		});
		lblNewLabel_8_3.setIcon(new ImageIcon(newimg101));
		lblNewLabel_8_3.setBounds(262, 226, 99, 47);
		panel_9.add(lblNewLabel_8_3);

		JLabel lblNewLabel_7_1_1_3 = new JLabel("Progress:-");
		lblNewLabel_7_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_3.setBounds(47, 297, 68, 14);
		panel_9.add(lblNewLabel_7_1_1_3);

		btnNewButton_1_4= new JButton("");
		btnNewButton_1_4.setIcon(new ImageIcon(newimg77));
		btnNewButton_1_4.setBorder(emptyBorder);
		btnNewButton_1_4.setBackground(Color.WHITE);
		btnNewButton_1_4.setBounds(273, 385, 114, 47);


		btnNewButton_2_1 = new JButton("");//stop button
		btnNewButton_2_1.setIcon(new ImageIcon(newimg88));
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(273, 385, 114, 47);
		btnNewButton_2_1.setBorder(emptyBorder);

		btnNewButton_1_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean clicked=true;
				fd.shutdown=false;
				btnNewButton_1_4.setVisible(false);
				btnNewButton_2_1.setVisible(true);
				//clicked=false;
				filedownloadstart  d=new filedownloadstart();
				filedownlodingclass d1=new filedownlodingclass();
				filedownlodingtext d2=new filedownlodingtext();
				try {
					t10=new Thread(d);
					t10.start();
					Enumeration<AbstractButton> enumeration = k.getElements();
					while (enumeration.hasMoreElements()) {
						enumeration.nextElement().setEnabled(false);
					}
				}
				catch(Exception e2)
				{
				}

				t11=new Thread(d1);
				t11.start();

				t12=new Thread(d2);
				t12.start();






			}
		});
		btnNewButton_2_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				fd.shutdown=true;
				btnNewButton_2_1.setVisible(false);
				btnNewButton_1_4.setVisible(true);

				if(t10.isAlive()==true)
				{

					Enumeration<AbstractButton> enumeration = k.getElements();
					while (enumeration.hasMoreElements()) {
						enumeration.nextElement().setEnabled(true);
					}

				}

			}
		});

		panel_9.add(btnNewButton_1_4);
		panel_9.add(btnNewButton_2_1);


		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(105, 152, 416, 26);

		panel_9.add(textField_8);

		JButton btnNewButton_11 = new JButton("ADD");

		btnNewButton_11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text =textField_8.getText();
				System.out.println(text);

				if(text.equals(""))
				{

					JOptionPane.showMessageDialog(null,"Please Enter Download Link ..Blank is not Allowed","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}
				else if(!text.equals(""))
				{
					try {
						conn=ws.tests();
						String sql="insert into DownloadURLS(Url) values('"+text+"')";
						Statement query = conn.createStatement(); query.executeUpdate(sql);


						JOptionPane.showMessageDialog(null,"Added Sucessfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
						conn.close();
					}
					catch(Exception e3)
					{
						e3.printStackTrace();

						JOptionPane.showMessageDialog(null,"Unable to Add Please Check DB","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
					}
				}

			}

		});

		btnNewButton_11.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_11.setBackground(new Color(173,255,47));
			}
		});
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_11.setBackground(new Color(240,240,240));
			}
		});
		btnNewButton_11.setBorder(emptyBorder);
		btnNewButton_11.setBackground(SystemColor.text);
		icon = new ImageIcon(newimg6);
		btnNewButton_11.setIcon(new ImageIcon(newimg6));
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_11.setBounds(531, 150, 90, 29);
		panel_9.add(btnNewButton_11);

		JButton btnNewButton_3_1 = new JButton("");


		btnNewButton_3_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_3_1.setBackground(new Color(173,255,47));
			}
		});
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3_1.setBackground(new Color(240,240,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					fd.FiledownloadtimeReport();
					JEditorPane myPane = new JEditorPane();
					myPane.setContentType("text/html");
					String location=System.getProperty("user.dir");
					myPane.setText("Report Generated Successfully <br><a href>"+location+"\\Report-xslx\\File Download Time.xlsx");
					JOptionPane.showMessageDialog(null,myPane,"Success",JOptionPane.INFORMATION_MESSAGE,green);

				}
				catch(Exception e6){

					JOptionPane.showMessageDialog(null,"Failed to Generate Report!!!","Failure",JOptionPane.INFORMATION_MESSAGE,failed);


				}
			}


		});

		btnNewButton_3_1.setIcon(new ImageIcon(newimg11));
		btnNewButton_3_1.setBorder(emptyBorder);
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setBounds(532, 468, 61, 51);
		panel_9.add(btnNewButton_3_1);

		JLabel lblNewLabel_7_1_1_1_2 = new JLabel("Generate Reports");
		lblNewLabel_7_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_1_2.setBounds(510, 521, 114, 14);
		panel_9.add(lblNewLabel_7_1_1_1_2);

		JButton btnNewButton_9_2_1 = new JButton("");

		btnNewButton_9_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					conn=ws.tests();
					String Sql="update Settings set LinkSelection=0 ,LinkWithoutAV=0 ,LinkWithAV=0";
					Statement st=conn.createStatement();
					st.executeUpdate(Sql);
					JOptionPane.showMessageDialog(null,"Reset Successful to Default","Success",JOptionPane.INFORMATION_MESSAGE,green);
					conn.close();

				} catch (SQLException | ClassNotFoundException e1) {

					e1.printStackTrace();


					JOptionPane.showMessageDialog(null,"Reset Unsuccessful to Default","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}
			}
		});

		btnNewButton_9_2_1.setIcon(new ImageIcon(Reset));
		btnNewButton_9_2_1.setBorder(emptyBorder1);
		btnNewButton_9_2_1.setBackground(Color.WHITE);
		btnNewButton_9_2_1.setBounds(565, 27, 40, 40);
		panel_9.add(btnNewButton_9_2_1);

		JLabel lblNewLabel_9_2_1 = new JLabel("     Reset DB");
		lblNewLabel_9_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9_2_1.setBounds(544, 68, 80, 14);
		panel_9.add(lblNewLabel_9_2_1);





		panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_10, null);
		panel_10.setLayout(null);

		JLabel lblNewLabel_2_2_1 = new JLabel("Software Installation Time");
		lblNewLabel_2_2_1.setBounds(171, 34, 306, 42);
		lblNewLabel_2_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_2_2_1.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		panel_10.add(lblNewLabel_2_2_1);


		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Install Without Antivirus");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2.setBounds(119, 106, 171, 34);
		panel_10.add(rdbtnNewRadioButton_2);

		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("Install With Antivirus");
		rdbtnNewRadioButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_2_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2_1.setBounds(322, 106, 171, 34);
		panel_10.add(rdbtnNewRadioButton_2_1);



		rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					conn=is.tests();
					String sql="update Settings set InstallSelection=0";
					Statement query  = conn.createStatement();
					query.executeQuery(sql);
					conn.close();

				} catch (ClassNotFoundException | SQLException e1) {


				}
			}
		});

		rdbtnNewRadioButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


				try {
					conn=is.tests();
					String sql="update Settings set InstallSelection=1";
					Statement query  = conn.createStatement();
					query.executeQuery(sql);
					conn.close();

				} catch (ClassNotFoundException | SQLException e1) {


				}
			}
		});

		h= new ButtonGroup();
		h.add(rdbtnNewRadioButton_2);
		h.add(rdbtnNewRadioButton_2_1);

		int selectlink=selectionfromdb;
		if(selectlink==0)
		{
			rdbtnNewRadioButton_2.setSelected(true);
		}
		else if(selectlink==1)
		{
			rdbtnNewRadioButton_2_1.setSelected(true);
		}

		JLabel lblNewLabel_7_1_1_2 = new JLabel("Progress:-");
		lblNewLabel_7_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_2.setBounds(27, 238, 68, 14);
		panel_10.add(lblNewLabel_7_1_1_2);


		btnNewButton_1_1 = new JButton("");//start button

		btnNewButton_1_1.setIcon(new ImageIcon(newimg77));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(263, 334, 114, 47);
		btnNewButton_1_1.setBorder(emptyBorder);

		btnNewButton_1_2 = new JButton("");//start button
		btnNewButton_1_2.setIcon(new ImageIcon(newimg88));
		btnNewButton_1_2.setBackground(Color.WHITE);
		btnNewButton_1_2.setBounds(263, 334, 114, 47);
		btnNewButton_1_2.setBorder(emptyBorder);

		panel_10.add(btnNewButton_1_1);
		panel_10.add(btnNewButton_1_2);

		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String text1=textField_6.getText();
					if(text1.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Enter Software Path ..Blank is not Allowed","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
					}
					else if	(!text1.equals(""))
					{
						boolean clicked=true;
						is.shutdown=false;
						btnNewButton_1_1.setVisible(false);
						btnNewButton_1_2.setVisible(true);

						try {
							Demothreadforsoftinstall d3=new Demothreadforsoftinstall();
							t3=new Thread(d3);
							t3.start();
							Enumeration<AbstractButton> enumeration = h.getElements();
							while (enumeration.hasMoreElements()) {
								enumeration.nextElement().setEnabled(false);
							}


						}
						catch(Exception e6)
						{

						}
						Demothread1forsoftinstall d4=new Demothread1forsoftinstall();
						t4=new Thread(d4);
						t4.start();

						installsoftware ist=new installsoftware();
						t4_1=new Thread(ist);
						t4_1.start();
					}


				}catch(Exception e3)
				{

				}
			}
		});

		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				boolean clicked=true;
				is.shutdown=true;
				btnNewButton_1_2.setVisible(false);
				btnNewButton_1_1.setVisible(true);
				if(t3.isAlive()==true)
				{
					Enumeration<AbstractButton> enumeration = h.getElements();
					while (enumeration.hasMoreElements()) {
						enumeration.nextElement().setEnabled(true);
					}
					//t3.stop();
					//t4.stop();

				}
				panel_10.revalidate();
				panel_10.repaint();

			}
		});


		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_1_3.setBackground(new Color(173,255,47));
			}
		});
		btnNewButton_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1_3.setBackground(new Color(240,240,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					is.installationtimeReport();

					JEditorPane myPane = new JEditorPane();
					myPane.setContentType("text/html");
					String location=System.getProperty("user.dir");
					myPane.setText("Report Generated Successfully <br><a href>"+location+"\\Report-xslx\\SoftwareInstallation Time.xlsx");
					JOptionPane.showMessageDialog(null,myPane,"Success",JOptionPane.INFORMATION_MESSAGE,green);

				}
				catch(Exception e6){

					JOptionPane.showMessageDialog(null,"Failed to Generate Report!!!","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}
			}

		});

		btnNewButton_1_3.setIcon(new ImageIcon(newimg11));
		btnNewButton_1_3.setBorder(emptyBorder);
		btnNewButton_1_3.setBounds(532, 468, 61, 51);
		Border emptyBorder2 = BorderFactory.createEmptyBorder();
		btnNewButton_1_3.setBorder(emptyBorder2);
		btnNewButton_1_3.setBackground(SystemColor.text);


		panel_10.add(btnNewButton_1_3);

		JLabel lblNewLabel_7_1_1_1_1 = new JLabel("Generate Reports");
		lblNewLabel_7_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_1_1.setBounds(510, 521, 114, 14);
		panel_10.add(lblNewLabel_7_1_1_1_1);

		JLabel lblNewLabel_7_1_1_2_2 = new JLabel("Software Location:-");
		lblNewLabel_7_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_2_2.setBounds(27, 179, 114, 14);
		panel_10.add(lblNewLabel_7_1_1_2_2);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(140, 173, 378, 26);
		String path=softwarespath;
		textField_6.setText(path);
		panel_10.add(textField_6);

		JButton btnNewButton_8 = new JButton("ADD");
		btnNewButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textforsoftadderrorhandling =textField_6.getText();

				if(textforsoftadderrorhandling.equals(""))
				{

					JOptionPane.showMessageDialog(null,"Please Enter Software Path ..Blank is not Allowed","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}
				else if(!textforsoftadderrorhandling.equals(""))
				{
					try {

						conn=is.tests();
						String sql="update Settings set SoftInstallPath=('"+textforsoftadderrorhandling+"\\')";
						Statement query = conn.createStatement(); query.executeUpdate(sql);


						JOptionPane.showMessageDialog(null,"Added Sucessfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
						conn.close();
					}
					catch(Exception e3)
					{
						e3.printStackTrace();

						JOptionPane.showMessageDialog(null,"Unable to Add Please Check DB","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
					}
				}
			}
		});


		btnNewButton_8.setIcon(new ImageIcon(newimg20));
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setBorder(emptyBorder);
		btnNewButton_8.setBounds(528, 171, 90, 29);
		panel_10.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("");

		btnNewButton_9.setIcon(new ImageIcon(Reset));
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					conn=ws.tests();
					String Sql="update Settings set InstallSelection=0 ,WithoutAVInstall=0,WithAVInstall=0";
					Statement st=conn.createStatement();
					st.executeUpdate(Sql);

					JOptionPane.showMessageDialog(null,"Reset Successful to Default","Success",JOptionPane.INFORMATION_MESSAGE,green);
					conn.close();

				} catch (SQLException | ClassNotFoundException e1) {

					e1.printStackTrace();


					JOptionPane.showMessageDialog(null,"Reset Unsuccessful to Default","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}


			}
		});
		btnNewButton_9.setBounds(565, 27, 40, 40);
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.setBorder(emptyBorder2);
		panel_10.add(btnNewButton_9);

		JLabel lblNewLabel_9 = new JLabel("     Reset DB");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(544, 68, 80, 14);
		panel_10.add(lblNewLabel_9);
		
		JButton btnNewButton_9_3 = new JButton("");
		btnNewButton_9_3.setIcon(new ImageIcon(directory+"\\Icon\\Uninstallicon.png"));
		btnNewButton_9_3.setBorder(emptyBorder2);
		btnNewButton_9_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Are you Sure You Want to Uninstall All the Application", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					ToastMessage toastMessage = new ToastMessage("Uninstallation Started....Please Wait!!",4000);
	                toastMessage.setVisible(true);
				
					//resource intensive operation. Takes about 3-5seconds to execute

					    
				} else {
				    JOptionPane.showMessageDialog(null, "GOODBYE");
				    System.exit(0);
				}
			}
		});
		
		btnNewButton_9_3.setBackground(Color.WHITE);
		btnNewButton_9_3.setBounds(55, 479, 40, 40);
		panel_10.add(btnNewButton_9_3);
		
		JLabel lblNewLabel_7_1_1_1_1_1 = new JLabel("Uninstall All Apps");
		lblNewLabel_7_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_1_1_1.setBounds(27, 521, 114, 14);
		panel_10.add(lblNewLabel_7_1_1_1_1_1);


		//	51561


		panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_11, null);
		panel_11.setLayout(null);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Network Copy Time");
		lblNewLabel_2_2_1_1.setBounds(196, 23, 236, 42);
		lblNewLabel_2_2_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_2_2_1_1.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		panel_11.add(lblNewLabel_2_2_1_1);

		rdbtnNewRadioButton_2_2 = new JRadioButton("Copy Without Antivirus");
		rdbtnNewRadioButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					conn=fc.tests();
					String sql="update Settings set CopySelection=0";
					Statement query  = conn.createStatement();
					query.executeQuery(sql);
					conn.close();

				} catch (ClassNotFoundException | SQLException e1) {


				}
			}
		});

		rdbtnNewRadioButton_2_2.setBounds(106, 98, 171, 34);
		rdbtnNewRadioButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_2_2.setBackground(Color.WHITE);
		panel_11.add(rdbtnNewRadioButton_2_2);



		rdbtnNewRadioButton_2_1_1 = new JRadioButton("Copy With Antivirus");
		rdbtnNewRadioButton_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


				try {
					conn=fc.tests();
					String sql="update Settings set CopySelection=1";
					Statement query  = conn.createStatement();
					query.executeQuery(sql);
					conn.close();

				} catch (ClassNotFoundException | SQLException e1) {


				}
			}
		});

		rdbtnNewRadioButton_2_1_1.setBounds(306, 98, 171, 34);
		rdbtnNewRadioButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_2_1_1.setBackground(Color.WHITE);
		panel_11.add(rdbtnNewRadioButton_2_1_1);

		i= new ButtonGroup();
		i.add(rdbtnNewRadioButton_2_2);
		i.add(rdbtnNewRadioButton_2_1_1);

		int select11=Copyselec;
		if(select11==0)
		{
			rdbtnNewRadioButton_2_2.setSelected(true);
		}
		else if(select11==1)
		{
			rdbtnNewRadioButton_2_1_1.setSelected(true);
		}


		MaskFormatter formatter = new MaskFormatter("###.###.###.###");
		panel_11.add(new JTextField());

		JLabel lblNewLabel_7_1_1_2_1 = new JLabel("IP Address:-");
		lblNewLabel_7_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_2_1.setBounds(79, 146, 79, 14);
		panel_11.add(lblNewLabel_7_1_1_2_1);

		textField_1 = new JTextField();
		textField_1.setBounds(427, 139, 50, 28);
		String port=new Integer(ports).toString();
		textField_1.setText(port);
		panel_11.add(textField_1);

		textField_1.setColumns(10);

		JLabel lblNewLabel_7_1_1_2_1_1 = new JLabel("Port:-");
		lblNewLabel_7_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_2_1_1.setBounds(354, 145, 42, 18);
		panel_11.add(lblNewLabel_7_1_1_2_1_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(168, 139, 152, 28);
		textField_2.setText(ftp);
		panel_11.add(textField_2);

		JLabel lblNewLabel_7_1_1_2_1_2 = new JLabel("Username:-");
		lblNewLabel_7_1_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_2_1_2.setBounds(79, 185, 79, 14);

		panel_11.add(lblNewLabel_7_1_1_2_1_2);

		JLabel lblNewLabel_7_1_1_2_1_3 = new JLabel("Password:-");
		lblNewLabel_7_1_1_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_2_1_3.setBounds(354, 185, 79, 14);
		panel_11.add(lblNewLabel_7_1_1_2_1_3);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(168, 178, 152, 28);
		textField_3.setText(user);
		panel_11.add(textField_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(428, 178, 152, 28);
		panel_11.add(passwordField);

		JLabel lblNewLabel_7_1_1_2_1_2_1 = new JLabel("Source Address:-");
		lblNewLabel_7_1_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_2_1_2_1.setBounds(79, 222, 109, 14);
		panel_11.add(lblNewLabel_7_1_1_2_1_2_1);

		JLabel lblNewLabel_7_1_1_2_1_2_1_1 = new JLabel("Destination Location:-");
		lblNewLabel_7_1_1_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_2_1_2_1_1.setBounds(79, 269, 125, 14);
		panel_11.add(lblNewLabel_7_1_1_2_1_2_1_1);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(213, 219, 370, 20);
		textField_4.setText(from);
		panel_11.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(213, 266, 370, 20);
		textField_5.setText(to);
		panel_11.add(textField_5);

		JLabel lblNewLabel_8_1_2 = new JLabel("Eg:- ftp://192.168.1.201:22/Software/");
		lblNewLabel_8_1_2.setForeground(Color.RED);
		lblNewLabel_8_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_1_2.setBounds(213, 241, 199, 14);
		panel_11.add(lblNewLabel_8_1_2);

		JButton btnNewButton_4 = new JButton("ADD");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String ipadd =textField_2.getText();
				String iport= textField_1.getText();
				String usernm= textField_3.getText();
				String pass= passwordField.getText();
				String source= textField_4.getText();
				String destination= textField_5.getText();



				if(ipadd.equals("") ||  iport.equals("")|| usernm.equals("") ||source.equals("")|| destination.equals(""))
				{

					JOptionPane.showMessageDialog(null,"Please Fill All Mandatory Fields","Failure",JOptionPane.INFORMATION_MESSAGE,failed);

				}
				else if(!ipadd.equals("") && !iport.equals("")&& !usernm.equals("")&& !source.equals("")&& !destination.equals(""))
				{
					try{
						conn=fc.tests();
						String sql="update FTPSetting set FTPAddress='"+ipadd+"',Port='"+iport+"',Username='"+usernm+"',Password='"+pass+"',FromLocation='"+source+"',ToLocation='"+destination+"'";
						Statement st=conn.createStatement();
						st.executeUpdate(sql);

						JOptionPane.showMessageDialog(null,"Applied Sucessfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
						conn.close();
					}
					catch(Exception e1)
					{
						e1.printStackTrace();

						JOptionPane.showMessageDialog(null,"Unable to Add Please Check DB","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
					}

				}
			}
		});

		btnNewButton_4.setIcon(new ImageIcon(newimg20 ));
		btnNewButton_4.setBounds(332, 291, 90, 29);
		Border emptyBorder9 = BorderFactory.createEmptyBorder();
		btnNewButton_4.setBorder(emptyBorder);
		btnNewButton_4.setBackground(SystemColor.text);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_11.add(btnNewButton_4);

		JLabel lblNewLabel_7_1_1_2_1_2_1_2 = new JLabel("Progress:-");
		lblNewLabel_7_1_1_2_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_2_1_2_1_2.setBounds(79, 347, 109, 14);
		panel_11.add(lblNewLabel_7_1_1_2_1_2_1_2);

		btnNewButton_5 = new JButton("");//start button
		btnNewButton_5.setIcon(new ImageIcon(newimg77));
		btnNewButton_5.setBorder(emptyBorder);

		btnNewButton_6 = new JButton("");//stop button
		btnNewButton_6.setIcon(new ImageIcon(newimg88));
		btnNewButton_6.setBorder(emptyBorder);

		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean clicked=true;
				fc.shutdown=false;
				btnNewButton_5.setVisible(false);
				btnNewButton_6.setVisible(true);
				clicked=false;

				DemothreadforNetworkCopy d1=new DemothreadforNetworkCopy();
				t5=new Thread(d1);
				t5.start();

				Demothread1forNetworkCopy d2=new Demothread1forNetworkCopy();
				t6=new Thread(d2);
				t6.start();

				netcoptetxt nct=new netcoptetxt();
				t5_1=new Thread(nct);
				t5_1.start();


			}
		});

		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean clicked=true;
				if(clicked=true) {

					btnNewButton_6.setVisible(false);
					btnNewButton_5.setVisible(true);
					clicked=false;

					if(t5.isAlive())
					{

						t5.stop();
						//t6.stop();

						Enumeration<AbstractButton> enumerationi = i.getElements();
						while (enumerationi.hasMoreElements()) {
							enumerationi.nextElement().setEnabled(true);

						}

					}
					panel_11.revalidate();
					panel_11.repaint();
				}
			}
		});
		btnNewButton_5.setBackground(SystemColor.text);
		btnNewButton_5.setBounds(298, 417, 114, 47);

		btnNewButton_6.setBackground(SystemColor.text);
		btnNewButton_6.setBounds(298, 417, 114, 47);
		panel_11.add(btnNewButton_5);
		panel_11.add(btnNewButton_6);


		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_6.setBackground(new Color(173,255,47));
			}
		});
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_6.setBackground(new Color(240,240,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					fc.networkcopytimeReport();
					JEditorPane myPane = new JEditorPane();
					myPane.setContentType("text/html");
					String location=System.getProperty("user.dir");
					myPane.setText("Report Generated Successfully <br><a href>"+location+"\\Report-xslx\\NetworkCopy Time.xlsx");
					JOptionPane.showMessageDialog(null,myPane,"Success",JOptionPane.INFORMATION_MESSAGE,green);

				}
				catch(Exception e6){



					JOptionPane.showMessageDialog(null,"Failed to Generate Report!!!","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}
			}

		});

		btnNewButton_6.setIcon(new ImageIcon(newimg11));
		btnNewButton_6.setBorder(emptyBorder);
		btnNewButton_6.setBounds(532, 468, 61, 51);
		btnNewButton_6.setBorder(emptyBorder1);
		btnNewButton_6.setBackground(SystemColor.text);


		panel_11.add(btnNewButton_6);

		JLabel lblNewLabel_7_1_1_1_3 = new JLabel("Generate Reports");
		lblNewLabel_7_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_1_3.setBounds(510, 521, 114, 14);
		panel_11.add(lblNewLabel_7_1_1_1_3);

		JLabel lblNewLabel_8_1_2_1_1 = new JLabel("*");
		lblNewLabel_8_1_2_1_1.setForeground(Color.RED);
		lblNewLabel_8_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_1_2_1_1.setBounds(145, 139, 13, 14);
		panel_11.add(lblNewLabel_8_1_2_1_1);

		JLabel lblNewLabel_8_1_2_1_2 = new JLabel("*");
		lblNewLabel_8_1_2_1_2.setForeground(Color.RED);
		lblNewLabel_8_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_1_2_1_2.setBounds(145, 185, 13, 14);
		panel_11.add(lblNewLabel_8_1_2_1_2);

		JLabel lblNewLabel_8_1_2_1_3 = new JLabel("*");
		lblNewLabel_8_1_2_1_3.setForeground(Color.RED);
		lblNewLabel_8_1_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_1_2_1_3.setBounds(383, 139, 13, 14);
		panel_11.add(lblNewLabel_8_1_2_1_3);

		JLabel lblNewLabel_8_1_2_1_4 = new JLabel("*");
		lblNewLabel_8_1_2_1_4.setForeground(Color.RED);
		lblNewLabel_8_1_2_1_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_1_2_1_4.setBounds(171, 222, 13, 14);
		panel_11.add(lblNewLabel_8_1_2_1_4);

		JLabel lblNewLabel_8_1_2_1_5 = new JLabel("*");
		lblNewLabel_8_1_2_1_5.setForeground(Color.RED);
		lblNewLabel_8_1_2_1_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_1_2_1_5.setBounds(196, 266, 13, 14);
		panel_11.add(lblNewLabel_8_1_2_1_5);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Delete Files After Downloading");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean check=chckbxNewCheckBox.isSelected();
				if(check==true)
				{
					try {

						conn=fc.tests();
						String sql="update FTPSetting set FTPDelete=1";
						Statement query  = conn.createStatement();
						query.executeQuery(sql);
						conn.close();

					} catch (ClassNotFoundException | SQLException e1) {


					}
				}
				else if(check==false)
				{
					try {
						conn=fc.tests();
						String sql="update FTPSetting set FTPDelete=0";
						Statement query  = conn.createStatement();
						query.executeQuery(sql);
						conn.close();

					} catch (ClassNotFoundException | SQLException e1) {


					}
				}
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(181, 72, 197, 23);
		if(ftpdelflag==0)
		{
			chckbxNewCheckBox.setSelected(false);
		}
		else if(ftpdelflag==1)
		{
			chckbxNewCheckBox.setSelected(true);
		}
		panel_11.add(chckbxNewCheckBox);

		JButton btnNewButton_9_1 = new JButton("");

		btnNewButton_9_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					conn=ws.tests();
					String Sql="update Settings set CopySelection=0 ,CpWithoutAV=0,CpWithAV=0";
					Statement st=conn.createStatement();
					st.executeUpdate(Sql);


					JOptionPane.showMessageDialog(null,"Reset Successful to Default","Success",JOptionPane.INFORMATION_MESSAGE,green);
					conn.close();

				} catch (SQLException | ClassNotFoundException e1) {

					e1.printStackTrace();

					JOptionPane.showMessageDialog(null,"Reset Unsuccessful to Default","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}
			}
		});
		btnNewButton_9_1.setBackground(Color.WHITE);
		btnNewButton_9_1.setIcon(new ImageIcon(Reset));
		btnNewButton_9_1.setBounds(565, 27, 40, 40);
		btnNewButton_9_1.setBorder(emptyBorder9);
		panel_11.add(btnNewButton_9_1);

		JLabel lblNewLabel_9_1 = new JLabel("     Reset DB");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9_1.setBounds(544, 68, 80, 14);
		panel_11.add(lblNewLabel_9_1);


		panel_12= new JPanel();
		panel_12.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_12, null);
		panel_12.setLayout(null);

		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Reports");
		lblNewLabel_2_2_1_1_1.setBounds(278, 11, 130, 42);
		lblNewLabel_2_2_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		panel_12.add(lblNewLabel_2_2_1_1_1);


		String s1[]= {"Website Load Time","Software Installation Time","Network Copy Time","File Opening Time","File Downloading Time"};
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setBounds(163, 58, 198, 22);
		panel_12.add(comboBox);


		JButton btnNewButton_7 = new JButton("Search");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});


		btnNewButton_7.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_7.setBackground(new Color(173,255,47));

			}
		});

		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_7.setBackground(new Color(240,240,240));
			}

		});

		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(t1!=null && t1.isAlive() || t2!=null && t2.isAlive() || t3!=null && t3.isAlive() || t4!=null && t4.isAlive() || t5!=null && t5.isAlive() || t6!=null && t6.isAlive())
				{
					JOptionPane.showMessageDialog(null,"Performance Process is Running Please Wait!! ","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}

				else
				{
					int get =comboBox.getSelectedIndex();
					String getname=(String) comboBox.getItemAt(get);
					System.out.println(getname);
					if(getname.equals("Website Load Time"))
					{
						try {
							internalFrame.dispose();

						}
						catch(Exception e6) {
						}

						try {
							showTableDataWLT();
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(getname.equals("Software Installation Time"))
					{
						try {
							internalFrame.dispose();
						}
						catch(Exception e6) {
						}
						try {

							showTableDataIA();
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(getname.equals("Network Copy Time"))
					{
						try {
							internalFrame.dispose();

						}
						catch(Exception e6) {

						}
						try {
							showTableDataNC();
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(getname.equals("File Opening Time"))
					{
						try {
							internalFrame.dispose();

						}
						catch(Exception e6) {

						}
						try {
							showTableDataFO();
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(getname.equals("File Downloading Time"))
					{
						try {
							internalFrame.dispose();

						}
						catch(Exception e6) {

						}
						try {
							showTableDataFd();
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		Border emptyBorder3 = BorderFactory.createEmptyBorder();
		btnNewButton_7.setBorder(emptyBorder);
		btnNewButton_7.setBackground(SystemColor.text);
		btnNewButton_7.setBounds(373, 58, 65, 23);
		panel_12.add(btnNewButton_7);
		
		JButton btnNewButton_12 = new JButton("Clear DB");
		btnNewButton_12.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_12.setBackground(new Color(173,255,47));

			}
		});

		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_12.setBackground(new Color(240,240,240));
			}

		});
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int get =comboBox.getSelectedIndex();
				String getname=(String) comboBox.getItemAt(get);
				System.out.println(getname);
				if(getname.equals("Website Load Time"))
				{
					
					try {
						conn=ws.tests();
						String deletewebsite="delete from WebsiteLoadTime";
						Statement st=conn.createStatement();
						st.executeUpdate(deletewebsite);
						st.close();
						conn.close();
						JOptionPane.showMessageDialog(null,"Deleted Successfully","Pass",JOptionPane.INFORMATION_MESSAGE);
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Unable to Delete!!Check DB ","Fail",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(getname.equals("Software Installation Time"))
				{
					try {
						conn=ws.tests();
						String deletewebsite="delete from SoftwareInstallationTime";
						Statement st=conn.createStatement();
						st.executeUpdate(deletewebsite);
						st.close();
						conn.close();
						JOptionPane.showMessageDialog(null,"Deleted Successfully","Pass",JOptionPane.INFORMATION_MESSAGE);
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Unable to Delete!!Check DB ","Fail",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(getname.equals("Network Copy Time"))
				{
					try {
						conn=ws.tests();
						String deletewebsite="delete from NetworkCopy";
						Statement st=conn.createStatement();
						st.executeUpdate(deletewebsite);
						st.close();
						conn.close();
						JOptionPane.showMessageDialog(null,"Deleted Successfully","Pass",JOptionPane.INFORMATION_MESSAGE);
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Unable to Delete!!Check DB ","Fail",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(getname.equals("File Opening Time"))
				{
					try {
						conn=ws.tests();
						String deletewebsite="delete from FileOpeningTime";
						Statement st=conn.createStatement();
						st.executeUpdate(deletewebsite);
						st.close();
						conn.close();
						JOptionPane.showMessageDialog(null,"Deleted Successfully","Pass",JOptionPane.INFORMATION_MESSAGE);
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Unable to Delete!!Check DB ","Fail",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(getname.equals("File Downloading Time"))
				{
					try {
						conn=ws.tests();
						String deletewebsite="delete from LinkDownloadTime";
						Statement st=conn.createStatement();
						st.executeUpdate(deletewebsite);
						st.close();
						conn.close();
						JOptionPane.showMessageDialog(null,"Deleted Successfully","Pass",JOptionPane.INFORMATION_MESSAGE);
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Unable to Delete!!Check DB ","Fail",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton_12.setBounds(507, 25, 89, 23);
		panel_12.add(btnNewButton_12);

		panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_13, null);
		panel_13.setLayout(null);

		JRadioButton rdbtnNewRadioButton_2_2_1 = new JRadioButton("Without Antivirus");

		rdbtnNewRadioButton_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					conn=fc.tests();
					String sql="update Settings set OpenSelection=0";
					Statement query  = conn.createStatement();
					query.executeQuery(sql); 
					conn.close();

				} catch (ClassNotFoundException | SQLException e1) {


				}
			}
		});

		rdbtnNewRadioButton_2_2_1.setBounds(158, 100, 155, 23);
		rdbtnNewRadioButton_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_2_2_1.setBackground(Color.WHITE);
		panel_13.add(rdbtnNewRadioButton_2_2_1);

		JRadioButton rdbtnNewRadioButton_2_1_1_1 = new JRadioButton("With Antivirus");
		rdbtnNewRadioButton_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


				try {
					conn=fc.tests();
					String sql="update Settings set OpenSelection=1";
					Statement query  = conn.createStatement();
					query.executeQuery(sql);
					conn.close();

				} catch (ClassNotFoundException | SQLException e1) {


				}
			}
		});


		rdbtnNewRadioButton_2_1_1_1.setBounds(315, 100, 137, 23);
		rdbtnNewRadioButton_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_2_1_1_1.setBackground(Color.WHITE);
		panel_13.add(rdbtnNewRadioButton_2_1_1_1);

		int selectfileopen=opensele;
		if(selectfileopen==0)
		{
			rdbtnNewRadioButton_2_2_1.setSelected(true);
		}
		else if(selectfileopen==1)
		{
			rdbtnNewRadioButton_2_1_1_1.setSelected(true);
		}

		JLabel lblNewLabel_2_2_1_1_2 = new JLabel("File Opening Time");
		lblNewLabel_2_2_1_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2_2_1_1_2.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		lblNewLabel_2_2_1_1_2.setBounds(198, 26, 243, 42);
		panel_13.add(lblNewLabel_2_2_1_1_2);

		JLabel lblNewLabel_7_1_1_2_1_2_1_3 = new JLabel("File Path :-");
		lblNewLabel_7_1_1_2_1_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_2_1_2_1_3.setBounds(53, 157, 80, 14);
		panel_13.add(lblNewLabel_7_1_1_2_1_2_1_3);

		textField_7 = new JTextField();
		textField_7.setText((String) null);
		textField_7.setColumns(10);
		textField_7.setBounds(134, 150, 443, 23);
		textField_7.setText(Openpath);
		panel_13.add(textField_7);

		JButton btnNewButton_8_1 = new JButton("ADD");

		btnNewButton_8_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text =textField_7.getText();
				System.out.println(text);

				if(text.equals(""))
				{

					JOptionPane.showMessageDialog(null,"Please Enter File Path...Blank is not Allowed","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}
				else if(!text.equals(""))
				{
					try {
						conn=ws.tests();
						String sql="update Settings set OpenPath='"+text+"'";
						Statement query = conn.createStatement(); query.executeUpdate(sql);


						JOptionPane.showMessageDialog(null,"Added Sucessfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
						conn.close();
					}
					catch(Exception e3)
					{
						e3.printStackTrace();

						JOptionPane.showMessageDialog(null,"Unable to Add Please Check DB","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
					}
				}

			}

		});

		btnNewButton_8_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_8_1.setBackground(new Color(173,255,47));
			}
		});
		btnNewButton_8_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_8_1.setBackground(new Color(240,240,240));
			}
		});
		btnNewButton_8_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_8_1.setBorder(emptyBorder);
		btnNewButton_8_1.setBackground(Color.WHITE);
		btnNewButton_8_1.setIcon(new ImageIcon(newimg6));
		btnNewButton_8_1.setBounds(295, 184, 90, 29);
		panel_13.add(btnNewButton_8_1);

		JButton btnNewButton_9_1_1 = new JButton("");
		btnNewButton_9_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					conn=ws.tests();
					String Sql="update Settings set OpenSelection=0 ,OpenWithoutAvDone=0,OpenWithAvDone=0";
					Statement st=conn.createStatement();
					st.executeUpdate(Sql);

					JOptionPane.showMessageDialog(null,"Reset Successful to Default","Success",JOptionPane.INFORMATION_MESSAGE,green);
					conn.close();

				} catch (SQLException | ClassNotFoundException e1) {

					e1.printStackTrace();

					JOptionPane.showMessageDialog(null,"Reset Unsuccessful to Default","Failure",JOptionPane.INFORMATION_MESSAGE,failed);
				}


			}
		});
		btnNewButton_9_1_1.setIcon(new ImageIcon(Reset));
		btnNewButton_9_1_1.setBackground(Color.WHITE);
		btnNewButton_9_1_1.setBounds(565, 27, 40, 40);
		btnNewButton_9_1_1.setBorder(emptyBorder1);
		panel_13.add(btnNewButton_9_1_1);

		JLabel lblNewLabel_9_1_1 = new JLabel("     Reset DB");
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9_1_1.setBounds(544, 68, 80, 14);
		panel_13.add(lblNewLabel_9_1_1);

		JLabel lblNewLabel_7_1_2 = new JLabel("Number of Iteration:-");
		lblNewLabel_7_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_2.setBounds(53, 262, 131, 14);
		panel_13.add(lblNewLabel_7_1_2);


		int iterate2=openinteration;
		SpinnerModel sm1 = new SpinnerNumberModel(iterate2, 1, 100, 1); //default value,lower bound,upper bound,increment by
		JSpinner spinner2 = new JSpinner(sm1);
		spinner2.setBackground(SystemColor.activeCaption);
		spinner2.setValue(Integer.valueOf(iterate2));
		JFormattedTextField tf1 = ((JSpinner.DefaultEditor)spinner2.getEditor()).getTextField();
		tf1.setEditable(false);
		spinner2.setBounds(198, 259, 61, 24);
		panel_13.add(spinner2);

		JLabel lblNewLabel_8_2 = new JLabel("");

		lblNewLabel_8_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					spinner2.commitEdit();
				} catch ( java.text.ParseException ef )
				{

				}
				int value = (Integer) spinner2.getValue();
				System.out.println(value);

				try {
					conn=ws.tests();
					String sql="update Settings set OpenIteration=='"+value+"'";
					Statement query  = conn.createStatement();
					query.executeUpdate(sql);

					JOptionPane.showMessageDialog(null,"Applied Sucessfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
					conn.close();
					query.close();

				} catch (SQLException e1) {


					JOptionPane.showMessageDialog(null,"Failed to Apply!!! Please Check DB","Failure",JOptionPane.INFORMATION_MESSAGE,failed);

				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				}


			}

		});
		lblNewLabel_8_2.setIcon(new ImageIcon(newimg101));
		lblNewLabel_8_2.setBounds(286, 262, 99, 47);
		panel_13.add(lblNewLabel_8_2);

		j= new ButtonGroup();
		j.add(rdbtnNewRadioButton_2_2_1);
		j.add(rdbtnNewRadioButton_2_1_1_1);

		JLabel lblNewLabel_7_1_1_2_1_2_1_2_1 = new JLabel("Progress:-");
		lblNewLabel_7_1_1_2_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_2_1_2_1_2_1.setBounds(53, 343, 109, 14);
		panel_13.add(lblNewLabel_7_1_1_2_1_2_1_2_1);


		btnNewButton_5_1= new JButton("");
		btnNewButton_5_1.setIcon(new ImageIcon(newimg77));
		btnNewButton_5_1.setBorder(emptyBorder);
		btnNewButton_5_1.setBackground(Color.WHITE);
		btnNewButton_5_1.setBounds(231, 424, 114, 47);
		panel_13.add(btnNewButton_5_1);


		btnNewButton_5_1_2= new JButton("");
		btnNewButton_5_1_2.setIcon(new ImageIcon(newimg88));
		btnNewButton_5_1_2.setBorder(emptyBorder);
		btnNewButton_5_1_2.setBackground(Color.WHITE);
		btnNewButton_5_1_2.setBounds(231, 424, 114, 47);
		panel_13.add(btnNewButton_5_1_2);

		JButton btnNewButton_6_1 = new JButton("");

		btnNewButton_6_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_6_1.setBackground(new Color(173,255,47));
			}
		});
		btnNewButton_6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_6_1.setBackground(new Color(240,240,240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					fo.FileopentimeReport();

					JEditorPane myPane = new JEditorPane();
					myPane.setContentType("text/html");
					String location=System.getProperty("user.dir");
					myPane.setText("Report Generated Successfully <br><a href>"+location+"\\Report-xslx\\File Open Time.xlsx");
					JOptionPane.showMessageDialog(null,myPane,"Success",JOptionPane.INFORMATION_MESSAGE,green);

				}
				catch(Exception e6){

					JOptionPane.showMessageDialog(null,"Failed to Generate Report!!!","Failure",JOptionPane.INFORMATION_MESSAGE,failed);

				}
			}


		});

		btnNewButton_6_1.setBackground(Color.WHITE);
		btnNewButton_6_1.setIcon(new ImageIcon(newimg11));
		btnNewButton_6_1.setBorder(emptyBorder);
		btnNewButton_6_1.setBounds(532, 468, 61, 51);
		panel_13.add(btnNewButton_6_1);

		JLabel lblNewLabel_7_1_1_1_3_1 = new JLabel("Generate Reports");
		lblNewLabel_7_1_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1_1_1_3_1.setBounds(510, 521, 114, 14);
		panel_13.add(lblNewLabel_7_1_1_1_3_1);




		btnNewButton_5_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				ws.progresscount=0;
				loopincountfo=0;
				btnNewButton_5_1.setVisible(false);
				btnNewButton_5_1_2.setVisible(true);
				fo.shutdown=false;

				filecopystart fc1=new filecopystart();
				t8=new Thread(fc1);
				t8.start();

				fileopeningclass fc2=new fileopeningclass();
				t9=new Thread(fc2);
				t9.start();

				fileopentxt fot =new fileopentxt();
				t8_1=new Thread(fot);
				t8_1.start();

				Enumeration<AbstractButton> enumerationi = j.getElements();
				while (enumerationi.hasMoreElements()) {
					enumerationi.nextElement().setEnabled(false);

				}


			}
		});


		btnNewButton_5_1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				btnNewButton_5_1_2.setVisible(false);
				btnNewButton_5_1.setVisible(true);
				//clicked=false;

				if(t8.isAlive())
				{

					fo.shutdown=true;
					Enumeration<AbstractButton> enumerationi = j.getElements();
					while (enumerationi.hasMoreElements()) {
						enumerationi.nextElement().setEnabled(true);

					}
				}

			}

		});

		int select3=opensele;
		if(select3==0)
		{
			rdbtnNewRadioButton_2_2_1.setSelected(true);
		}
		else if(select3==1)
		{
			rdbtnNewRadioButton_2_1_1_1.setSelected(true);
		}


	}
	public class Demothread implements Runnable{

		@Override
		public void run() {

			try {

				try {
					ws.findinDB();
				} catch (KeyManagementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			} catch (IllegalStateException  e1) {

				JOptionPane.showMessageDialog(null,"ChromeDriver Error:- ChromeDriverNotPresent","Failure",JOptionPane.ERROR_MESSAGE,failed);


			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block

			} catch (IOException e) {
				// TODO Auto-generated catch block

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}catch (NoSuchWindowException e) {


				JOptionPane.showMessageDialog(null,"Browser Window was Forcefully Closed","Failure",JOptionPane.ERROR_MESSAGE,failed);
			}
			catch (SessionNotCreatedException e) {

				e.printStackTrace();

				JOptionPane.showMessageDialog(null,"ChromeDriver Error :- Please Update Chrome Driver to current Browser Version of Chrome","Failure",JOptionPane.ERROR_MESSAGE,failed);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public class Demothread1 implements Runnable{

		@Override
		public void run() {

			try {

				startprogressbarscan();

			} catch (ClassNotFoundException e) {

			} catch (SQLException e) {

				JOptionPane.showMessageDialog(null,"ChromeDriver Error:-"+e.getMessage(),"Failure",JOptionPane.ERROR_MESSAGE,failed);
			} catch (InterruptedException e) {

				JOptionPane.showMessageDialog(null,"ChromeDriver Error:-"+e.getMessage(),"Failure",JOptionPane.ERROR_MESSAGE,failed);
			}
		}
		public void loop() throws ClassNotFoundException, SQLException, InterruptedException
		{

			int initial=0;
			int finals=numberofwebsite;
			System.out.println("nuberweb"+finals);

			int loopincount=0;
			while(true)
			{
				loopincount=(ws.progresscount*100)/finals;
				Thread.sleep(10);
				progressBar.setValue(loopincount);
				website=ws.ip;
				if(!t1.isAlive())
				{

					JOptionPane.showMessageDialog(null,"Task Completed Successfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
					btnNewButton_1.setVisible(true);
					btnNewButton_2.setVisible(false);
					progressBar.setValue(0);
					progressBar.setMaximum(0);
					progressBar.setString("0");
					loopincount=0;
					ws.progresscount=0;
					Enumeration<AbstractButton> enumeration = g.getElements();
					while (enumeration.hasMoreElements()) {
						enumeration.nextElement().setEnabled(true);
					}
					break;

				}

			}System.gc();
		}
		public void startprogressbarscan() throws ClassNotFoundException, SQLException, InterruptedException
		{
			progressBar = new JProgressBar();
			progressBar.setBackground(Color.WHITE);
			progressBar.setForeground(Color.GREEN);
			progressBar.setUI(ui);
			progressBar.setBounds(106, 332, 418, 24);
			progressBar.setValue(0);
			progressBar.setStringPainted(true);
			panel_8.add(progressBar);
			loop();

		}
	}
	public class Demothreadforsoftinstall implements Runnable{
		@Override
		public void run() {
			try {
				is.getfilname();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			catch (NullPointerException e1) {

				JOptionPane.showMessageDialog(null,"Unable to find software which is present in the DB","Failure",JOptionPane.ERROR_MESSAGE,failed);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public class Demothread1forsoftinstall implements Runnable{
		@Override
		public void run() {
			try {
				startprogressbarscanforsoftware();
			} catch (ClassNotFoundException | SQLException | InterruptedException e) {
				e.printStackTrace();
			}
			catch (NullPointerException e1) {

				JOptionPane.showMessageDialog(null,"Unable to find software which is present in the DB","Failure",JOptionPane.ERROR_MESSAGE,failed);
			}
		}
	}
	////
	public class DemothreadforNetworkCopy implements Runnable{
		@Override
		public void run(){
			try {
				Enumeration<AbstractButton> enumerationi = i.getElements();
				while (enumerationi.hasMoreElements()) {
					enumerationi.nextElement().setEnabled(false);


				}
				fc.startdownload();


			} catch (ClassNotFoundException | SQLException | IOException | ParseException e1) {
				e1.printStackTrace();
				
			}
			catch(IllegalArgumentException e2)
			{
				JOptionPane.showMessageDialog(null,"Destination Path is Invalid","Failure",JOptionPane.ERROR_MESSAGE);
				btnNewButton_5.setVisible(true);
				btnNewButton_6.setVisible(false);
				progressBar_2.setValue(0);
				progressBar_2.setMaximum(0);
				progressBar_2.setString("0");
				
				fc.fileCountonlocal=0;
				numberofsoft=0;
				
				Enumeration<AbstractButton> enumerationi = i.getElements();
				while (enumerationi.hasMoreElements()) {
					enumerationi.nextElement().setEnabled(true);
				}
			}
		}
	}
	public class Demothread1forNetworkCopy implements Runnable{
		@Override
		public void run() {
			try {
				startprogressbarnetworkcopy();
			} catch (ClassNotFoundException | SQLException | InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
	public void loopforsoftinstall() throws ClassNotFoundException, SQLException, InterruptedException
	{
		int initial=0;
		Thread.sleep(1000);
		File f1=new File(is.path);
		int finals= f1.listFiles().length;
		System.out.println(finals);

		//int finals=numberofsoft;
		System.out.println("Numberofsoft"+finals);
		int loopincount=0;
		while(true && t3.isAlive()==true)
		{
			softwarename=is.exe_name_extractedwithexe;
			loopincount=(is.progresscount*100)/finals;
			Thread.sleep(10);
			progressBar_1.setValue(loopincount);
			//System.out.println("Progress"+is.progresscount);
			if(!t3.isAlive())
			{

				JOptionPane.showMessageDialog(null,"Task Completed Successfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
				btnNewButton_1_1.setVisible(true);
				btnNewButton_1_2.setVisible(false);
				progressBar_1.setValue(0);
				progressBar_1.setMaximum(0);
				progressBar_1.setString("0");
				loopincount=0;
				is.progresscount=0;
				Enumeration<AbstractButton> enumeration = h.getElements();
				while (enumeration.hasMoreElements()) {
					enumeration.nextElement().setEnabled(true);

				}

			}
		}System.gc();
	}
	public void startprogressbarscanforsoftware() throws ClassNotFoundException, SQLException, InterruptedException
	{
		progressBar_1 = new JProgressBar();
		progressBar_1.setBackground(Color.WHITE);
		progressBar_1.setForeground(Color.GREEN);
		progressBar_1.setBounds(114, 238, 418, 24);
		progressBar_1.setUI(ui);
		progressBar_1.setValue(0);
		progressBar_1.setStringPainted(true);
		panel_10.add(progressBar_1);
		loopforsoftinstall();
	}
	public void startprogressbarnetworkcopy() throws ClassNotFoundException, SQLException, InterruptedException
	{
		progressBar_2 = new JProgressBar();
		progressBar_2.setBackground(Color.WHITE);
		progressBar_2.setForeground(Color.GREEN);
		progressBar_2.setUI(ui);
		progressBar_2.setBounds(143, 344, 437, 24);
		progressBar_2.setValue(0);
		progressBar_2.setStringPainted(true);
		panel_11.add(progressBar_2);
		Thread.sleep(1300);
		loopforNetworkCopy();
	}

	public void loopforNetworkCopy() throws ClassNotFoundException, SQLException, InterruptedException
	{
		int initial=0;
		fc.findtotalfileonftp();
		numberofsoft =fc.totalcountonftp;

		int finals=numberofsoft;
		//System.out.println("Finals"+finals);
		int loopincount=0;
		while(true && t5.isAlive()==true)
		{
			netwrkcopyfilename=fc.filename;
			fc.totalfiledownloadonlocal();
			loopincount=(fc.fileCountonlocal*100)/finals;
			Thread.sleep(10);
			progressBar_2.setValue(loopincount);

			if(!t5.isAlive())
			{
				fc.fetchselectionsettingfromDB();
				if(fc.ftpdeleteflag==1)
				{
					fc.deletedirectory(fc.filestobedeleted);

				}
				else {
					System.out.println("Delete Option not Selected");
				}

				JOptionPane.showMessageDialog(null,"Files Download Successfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
				btnNewButton_5.setVisible(true);
				btnNewButton_6.setVisible(false);
				progressBar_2.setValue(0);
				progressBar_2.setMaximum(0);
				progressBar_2.setString("0");
				loopincount=0;
				fc.fileCountonlocal=0;
				numberofsoft=0;
				finals=0;
				Enumeration<AbstractButton> enumerationi = i.getElements();
				while (enumerationi.hasMoreElements()) {
					enumerationi.nextElement().setEnabled(true);
				}
			}
		}System.gc();
	}
	public class Demothread12 implements Runnable{

		@Override
		public void run() {

			lblNewLabel_10= new JLabel();     ////File name changing
			lblNewLabel_10.setBounds(131, 372, 418, 14);
			lblNewLabel_10.setText(ws.ip);
			panel_8.add(lblNewLabel_10);
		}
	}
	//REPORT SECTION

	public void showTableDataFd() throws SQLException {

		internalFrame = new JInternalFrame("Reports");
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNamesforFiledownloading);

		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


		String datetime = "";
		String name = "";
		String withoutantivirus = "";
		String withantivirus = "";
		String iteration = "";
		try {

			conn=is.tests();
			pst = conn.prepareStatement("select * from LinkDownloadTime");
			ResultSet rs = pst.executeQuery();
			int i = 0;
			while (rs.next()) {
				datetime = rs.getString("DateTime");
				name = rs.getString("Url");
				withoutantivirus = rs.getString("WithoutAV");
				withantivirus = rs.getString("WithAV");
				iteration = rs.getString("Iteration");
				model.addRow(new Object[]{datetime, name, withoutantivirus, withantivirus,iteration});
				i++;
			}
			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

			}
			if (i == 1) {
				System.out.println(i + " Record Found");
			} else {
				System.out.println(i + " Records Found");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		internalFrame.getContentPane().add(new JScrollPane(table));
		internalFrame.setBounds(9, 91, 632, 485);
		internalFrame.setFrameIcon(maxsecurereporticon);
		internalFrame.setBorder(null);
		panel_12.add(internalFrame);
		internalFrame.setVisible(true);

	}

	public void showTableDataFO() throws SQLException {

		internalFrame = new JInternalFrame("Reports");
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNamesforFileOpening);

		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


		String datetime = "";
		String name = "";
		String withoutantivirus = "";
		String withantivirus = "";
		String iteration = "";
		try {

			conn=is.tests();
			pst = conn.prepareStatement("select * from FileOpeningTime");
			ResultSet rs = pst.executeQuery();
			int i = 0;
			while (rs.next()) {
				datetime = rs.getString("DateTime");
				name = rs.getString("Name");
				withoutantivirus = rs.getString("WithoutAV");
				withantivirus = rs.getString("WithAV");
				iteration = rs.getString("Iteration");
				model.addRow(new Object[]{datetime, name, withoutantivirus, withantivirus,iteration});
				i++;
			}
			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

			}
			if (i == 1) {
				System.out.println(i + " Record Found");
			} else {
				System.out.println(i + " Records Found");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		internalFrame.getContentPane().add(new JScrollPane(table));
		internalFrame.setBounds(9, 91, 632, 485);
		internalFrame.setFrameIcon(maxsecurereporticon);
		internalFrame.setBorder(null);
		panel_12.add(internalFrame);
		internalFrame.setVisible(true);


	}
	public void showTableDataIA() throws SQLException {

		internalFrame = new JInternalFrame("Reports");
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNamesforsoftwareinstall);

		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


		String datetime = "";
		String softwarename = "";
		String withoutantivirus = "";
		String withantivirus = "";
		String timeunit = "";
		try {

			conn=is.tests();
			pst = conn.prepareStatement("select * from SoftwareInstallationTime");
			ResultSet rs = pst.executeQuery();
			int i = 0;
			while (rs.next()) {
				datetime = rs.getString("DateTime");
				softwarename = rs.getString("SoftwareName");
				withoutantivirus = rs.getString("WithoutAntivirus");
				withantivirus = rs.getString("WithAntivirus");
				timeunit = rs.getString("TimeUnit");
				model.addRow(new Object[]{datetime, softwarename, withoutantivirus, withantivirus,timeunit});
				i++;
			}
			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

			}
			if (i == 1) {
				System.out.println(i + " Record Found");
			} else {
				System.out.println(i + " Records Found");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		internalFrame.getContentPane().add(new JScrollPane(table));
		internalFrame.setBounds(9, 91, 632, 485);
		internalFrame.setFrameIcon(maxsecurereporticon);
		internalFrame.setBorder(null);
		panel_12.add(internalFrame);
		internalFrame.setVisible(true);


	}
	public void showTableDataWLT() throws SQLException {
		internalFrame = new JInternalFrame("Reports");
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNamesforWebsiteLoadTime);

		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		String datetime = "";
		String softwarename = "";
		String withoutantivirus ="";
		String withantivirus = "";
		String timeunit = "";
		String Iteration="";
		try {

			conn=ws.tests();
			pst = conn.prepareStatement("select * from WebsiteLoadTime");
			ResultSet rs = pst.executeQuery();
			int i = 0;
			while (rs.next()) {
				datetime = rs.getString("DateTime");
				softwarename = rs.getString("Website");
				withoutantivirus = rs.getString("TimeWithoutAntivirus");
				withantivirus = rs.getString("TimeWithAntivirus");
				timeunit = rs.getString("TimeUnit");
				Iteration = rs.getString("Iteration");
				model.addRow(new Object[]{datetime, softwarename, withoutantivirus, withantivirus,timeunit,Iteration});
				i++;
			}
			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

			}
			if (i == 1) {
				System.out.println(i + " Record Found");
			} else {
				System.out.println(i + " Records Found");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		internalFrame.getContentPane().add(new JScrollPane(table));
		internalFrame.setBounds(9, 91, 632, 485);

		internalFrame.setFrameIcon(maxsecurereporticon);
		internalFrame.setBorder(null);
		panel_12.add(internalFrame);
		internalFrame.setVisible(true);

	}

	public void showTableDataNC() throws SQLException {

		internalFrame = new JInternalFrame("Reports");

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNamesfornetworkcopy);

		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


		String datetime = "";
		String info = "";
		String withoutantivirus = "";
		String withantivirus = "";
		String timeunit = "";
		String Iteration="";
		try {

			conn=is.tests();
			pst = conn.prepareStatement("select * from NetworkCopy");
			ResultSet rs = pst.executeQuery();
			int i = 0;
			while (rs.next()) {
				datetime = rs.getString("DateTime");
				info = rs.getString("Info");
				withoutantivirus = rs.getString("WithoutAV");
				withantivirus = rs.getString("WithAV");
				timeunit = rs.getString("Unit");

				model.addRow(new Object[]{datetime, info, withoutantivirus, withantivirus,timeunit});
				i++;
			}
			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

			}
			if (i == 1) {
				System.out.println(i + " Record Found");
			} else {
				System.out.println(i + " Records Found");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		internalFrame.getContentPane().add(new JScrollPane(table));
		internalFrame.setBounds(9, 91, 632, 485);
		internalFrame.setFrameIcon(maxsecurereporticon);
		internalFrame.setBorder(null);
		panel_12.add(internalFrame);
		internalFrame.setVisible(true);

	}

	public void getsettingindb() throws ClassNotFoundException, SQLException

	{
		Connection conn=is.tests();
		String sql = "select * from Settings";
		String sql1 = "select * from FTPSetting";
		String sqlcount="Select count(DefaultSite) from Websites";
		String countfilefdownload="Select count(Url) from DownloadURLS";
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		Statement stmtss = conn.createStatement();
		rs3= stmtss.executeQuery(sqlcount);
		rs3.next();
		numberofwebsite =rs3.getInt(1);
		rs3.close();


		rs4=stmtss.executeQuery(countfilefdownload);
		rs4.next();
		numberofdownloadlink=rs4.getInt(1);
		rs4.close();
		ResultSet rs1 = null;
		ResultSet rs2=null;
		Statement stmts  = conn.createStatement();
		Statement stmts1  = conn.createStatement();
		rs1= stmts.executeQuery(sql);
		rs2=stmts1.executeQuery(sql1);
		while (rs1.next()) {

			selecWebsite=rs1.getInt("Selection");
			iterationfromdb=rs1.getInt("Iteration");
			selectionfromdb=rs1.getInt("InstallSelection");
			softwarespath=rs1.getString("SoftInstallPath");
			Copyselec=rs1.getInt("CopySelection");
			opensele=rs1.getInt("OpenSelection");
			openinteration=rs1.getInt("OpenIteration");
			Openpath=rs1.getString("OpenPath");
			linkSelection=rs1.getInt("LinkSelection");
			linkiteration=rs1.getInt("LinkIteration");

		}

		rs2= stmts.executeQuery(sql1);
		while (rs2.next()) {
			ftp=rs2.getString("FTPAddress");
			ports=rs2.getInt("Port");
			user=rs2.getString("Username");
			pass=rs2.getString("Password");
			from=rs2.getString("FromLocation");
			to=rs2.getString("ToLocation");
			ftpdelflag=rs2.getInt("FTPDelete");
			//	conn.close();
		}
		conn.close();
		rs1.close();
		rs2.close();
		rs3.close();
		rs4.close();
		stmtss.close();
		stmts.close();
		stmts1.close();
	}

	public class filecopystart implements Runnable{
		@Override
		public void run(){
			try {

				fo.startopen();

			} catch (ClassNotFoundException | SQLException | IOException  | InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	public class fileopeningclass implements Runnable{

		@Override
		public void run() {

			try {

				startprogressbarscanfo();

			} catch (ClassNotFoundException | SQLException | InterruptedException e) {

			}
		}
		public void loopfileopen() throws ClassNotFoundException, SQLException, InterruptedException
		{


			fo.enumnosoffile();
			int finals=fo.counts;
			System.out.println("nuberweb"+finals);

			loopincountfo=0;
			while(true)
			{

				loopincountfo=(fo.progresscount*100)/finals;
				fileopenname=fo.filename;
				Thread.sleep(10);
				progressBar_3.setValue(loopincountfo);
				if(!t8.isAlive())
				{
					Enumeration<AbstractButton> enumerationj = j.getElements();
					while (enumerationj.hasMoreElements()) {
						enumerationj.nextElement().setEnabled(true);
					}

					JOptionPane.showMessageDialog(null,"Task Completed Successfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
					btnNewButton_5_1.setVisible(true);
					btnNewButton_5_1_2.setVisible(false);
					progressBar_3.setValue(0);
					progressBar_3.setMaximum(0);
					progressBar_3.setString("0");
					loopincountfo=0;
					fo.progresscount=0;
					t9.stop();
					finals=0;
					break;
				}


			}System.gc();

		}

		public void startprogressbarscanfo() throws ClassNotFoundException, SQLException, InterruptedException
		{
			progressBar_3 = new JProgressBar();
			progressBar_3.setBackground(Color.WHITE);
			progressBar_3.setForeground(Color.GREEN);
			progressBar_3.setBounds(124, 332, 418, 24);
			progressBar_3.setUI(ui);
			progressBar_3.setValue(0);
			progressBar_3.setStringPainted(true);
			panel_13.add(progressBar_3);
			loopfileopen();

		}
	}

	public class filedownloadstart implements Runnable{
		@Override
		public void run(){
			try {

				fd.fetchurl();

			} catch (ClassNotFoundException | SQLException | IOException  | InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public class filedownlodingclass implements Runnable{

		@Override
		public void run() {

			try {

				startprogressbarscanfd();


			} catch (ClassNotFoundException | SQLException | InterruptedException e) {

			}
		}
	}
	public class filedownlodingtext implements Runnable{

		@Override
		public void run() {

			try {


				textnamefd();

			} catch (ClassNotFoundException | SQLException | InterruptedException e) {

			}
		}
	}
	public void loopfilefd() throws ClassNotFoundException, SQLException, InterruptedException
	{

		//fo.enumnosoffile();
		int finals=numberofdownloadlink;
		int loopincount=0;
		while(true)
		{
			loopincount=(fd.progresscount*100)/finals;
			Thread.sleep(10);
			progressBar_4.setValue(loopincount);
			url=fd.URLS;
			if(!t10.isAlive())
			{
				JOptionPane.showMessageDialog(null,"Task Completed Successfully","Success",JOptionPane.INFORMATION_MESSAGE,green);
				btnNewButton_1_4.setVisible(true);
				btnNewButton_2_1.setVisible(false);
				progressBar_4.setValue(0);
				progressBar_4.setMaximum(0);
				progressBar_4.setString("0");
				loopincount=0;
				fd.progresscount=0;

				Enumeration<AbstractButton> enumeration = k.getElements();
				while (enumeration.hasMoreElements()) {
					enumeration.nextElement().setEnabled(true);
				}
				break;
			}

		}System.gc();
	}
	public void startprogressbarscanfd() throws ClassNotFoundException, SQLException, InterruptedException
	{
		progressBar_4= new JProgressBar();
		progressBar_4.setBackground(Color.WHITE);
		progressBar_4.setForeground(Color.GREEN);
		progressBar_4.setUI(ui);
		progressBar_4.setBounds(125, 289, 437, 24);
		progressBar_4.setValue(0);
		progressBar_4.setStringPainted(true);
		panel_9.add(progressBar_4);
		loopfilefd();

	}
	public void textnamefd() throws ClassNotFoundException, SQLException, InterruptedException
	{
		JLabel lblNewLabel_11 = new JLabel();
		JLabel lblNewLabel_13 = new JLabel();
		lblNewLabel_11.setBounds(125, 333, 500, 14);
		lblNewLabel_13.setBounds(125, 318, 90, 14);
		panel_9.add(lblNewLabel_11);
		panel_9.add(lblNewLabel_13);
		do
		{
			lblNewLabel_13.setText("Downloading:-");
			lblNewLabel_11.setText("<html>"+url+"</html>");

		}while(t10.isAlive()==true);

		lblNewLabel_11.setText("");
		lblNewLabel_13.setText("");
	}
	public void textnamewlt() throws ClassNotFoundException, SQLException, InterruptedException
	{
		JLabel lblNewLabel_14 = new JLabel();
		JLabel lblNewLabel_15 = new JLabel();
		lblNewLabel_14.setBounds(107, 378, 500, 14);
		lblNewLabel_15.setBounds(107, 363, 90, 14);
		panel_8.add(lblNewLabel_14);
		panel_8.add(lblNewLabel_15);
		do
		{
			lblNewLabel_15.setText("Opening:-");
			lblNewLabel_14.setText("<html>"+website+"</html>");

		}while(t1.isAlive()==true);

		lblNewLabel_14.setText("");
		lblNewLabel_15.setText("");
	}



	public class webisteloadingtext implements Runnable{

		@Override
		public void run() {

			try {

				textnamewlt();

			} catch (ClassNotFoundException | SQLException | InterruptedException e) {

			}
		}
	}
	public void textnamesit() throws ClassNotFoundException, SQLException, InterruptedException
	{

		JLabel installhardcodetext = new JLabel("");
		installhardcodetext.setBounds(115, 270, 500, 14);
		panel_10.add(installhardcodetext);


		JLabel installchangingtext = new JLabel("");
		installchangingtext.setBounds(115, 285, 500, 14);
		panel_10.add(installchangingtext);
		do
		{
			installhardcodetext.setText("Installing:-");
			installchangingtext.setText("<html>"+softwarename+"</html>");

		}while(t3.isAlive()==true);

		installhardcodetext.setText("");
		installchangingtext.setText("");
	}
	public class installsoftware implements Runnable{

		@Override
		public void run() {

			try {
				textnamesit();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	public void textnamenct() throws ClassNotFoundException, SQLException, InterruptedException
	{

		JLabel copyhardtext = new JLabel("");
		copyhardtext.setBounds(145, 370, 500, 14);
		panel_11.add(copyhardtext);


		JLabel copychangingtext = new JLabel("");
		copychangingtext.setBounds(145, 383, 500, 14);
		panel_11.add(copychangingtext);
		do
		{
			copyhardtext.setText("File Copying from FTP:-");
			copychangingtext.setText(netwrkcopyfilename);

		}while(t5.isAlive()==true);

		copyhardtext.setText("");
		copychangingtext.setText("");
	}
	public class netcoptetxt implements Runnable{

		@Override
		public void run() {

			try {

				textnamenct();
			} catch (ClassNotFoundException | SQLException | InterruptedException e) {

			}
		}
	}

	public void textnamefo() throws ClassNotFoundException, SQLException, InterruptedException
	{

		JLabel openhardtext = new JLabel("");
		openhardtext.setBounds(125, 360, 500, 14);
		panel_13.add(openhardtext);


		JLabel openchangingtext = new JLabel("");
		openchangingtext.setBounds(125, 374, 500, 14);
		panel_13.add(openchangingtext);
		do
		{
			openhardtext.setText("Opening:-");
			openchangingtext.setText(fileopenname);

		}while(t8.isAlive()==true);

		openhardtext.setText("");
		openchangingtext.setText("");
	}
	public class fileopentxt implements Runnable{

		@Override
		public void run() {

			try {

				textnamefo();
			} catch (ClassNotFoundException | SQLException | InterruptedException e) {

			}
		}
	}
	public class ToastMessage extends JDialog {
	    int miliseconds;
	    public ToastMessage(String toastString, int time) {
	        this.miliseconds = time;
	        setUndecorated(true);
	        getContentPane().setLayout(new BorderLayout(0, 0));

	        JPanel panel = new JPanel();
	        panel.setBackground(Color.GRAY);
	        panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
	        getContentPane().add(panel, BorderLayout.CENTER);

	        JLabel toastLabel = new JLabel("");
	        toastLabel.setText(toastString);
	        toastLabel.setFont(new Font("Dialog", Font.BOLD, 12));
	        toastLabel.setForeground(Color.WHITE);

	        setBounds(200, 250, toastLabel.getPreferredSize().width+20, 31);


	        setAlwaysOnTop(true);
	        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	        int y = dim.height/2-getSize().height/2;
	        int half = y/2;
	        setLocation(dim.width/2-getSize().width/2, y+half);
	        panel.add(toastLabel);
	        setVisible(false);

	        new Thread(){
	            public void run() {
	                try {
	                	
	                    Thread.sleep(miliseconds);
	                    dispose();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                UninstallSoftwares us=new UninstallSoftwares();
					try {
						us.uninstall();
					} catch (ClassNotFoundException | IOException | InterruptedException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        }.start();
	    }
}}













