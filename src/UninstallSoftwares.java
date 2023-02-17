import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UninstallSoftwares {
	InstallApplication iaa=new InstallApplication();
	
	
	public void uninstall() throws IOException, InterruptedException, ClassNotFoundException, SQLException
	{
		iaa.fetchselectionsettingfromDB();
		String sofwarepath =iaa.path;
		String ss=System.getProperty("user.home");
		List<String> commands = new ArrayList<String>();
        commands.add("\"%ProgramFiles%\\Balsamiq\\Balsamiq Wireframes\\unins000.exe\" /VERYSILENT /NORESTART");
        commands.add("\"%ProgramFiles%\\Mozilla Firefox\\uninstall\\helper.exe\" -ms");
        commands.add("\"%ProgramFiles%\\Gephi-0.9.6\\unins000.exe\" /VERYSILENT /ALLUSERS");
        commands.add("\"%ProgramFiles%\\GIMP 2\\uninst\\unins000.exe\" /VERYSILENT /NORESTART");
        commands.add("\"%ProgramFiles%\\DigiDNA\\iMazing\\unins000.exe\" /SP- /VERYSILENT /NORESTART");
        commands.add("\"%ProgramFiles%\\memoQ\\memoQ-9\\unins000.exe\" /VERYSILENT");
        commands.add("\"%ProgramFiles%\\Notepad++\\uninstall.exe\" /S");
        commands.add("\"%ProgramFiles%\\JetBrains\\RubyMine 2022.1\\bin\\Uninstall.exe\" /S");
        commands.add("\"%ProgramFiles(x86)%\\Microsoft\\Skype for Desktop\\unins000.exe\" /VERYSILENT /NORESTART");
        commands.add("\"%ProgramFiles%\\TeamViewer\\uninstall.exe\" /S"); 
        commands.add("\"%ProgramFiles%\\VideoLAN\\VLC\\uninstall.exe\" /S");
        commands.add(ss+"\"\\AppData\\Local\\Roon\\Application\\100801021\\Uninstall.exe\" /S");
        commands.add("\"%ProgramFiles%\\RazorSQL\\unins000.exe\" /SILENT ");
        commands.add("\"%ProgramFiles%\\iTop Screen Recorder\\unins000.exe\" /VERYSILENT /NORESTART");
        commands.add("\"%ProgramFiles(x86)%\\Print Conductor\\unins000.exe\" /SILENT");
        commands.add("\"%ProgramFiles%\\Mozilla Thunderbird\\uninstall\\helper.exe\" -ms");
        commands.add(sofwarepath+"Sonos.exe /S /x /v/qn");
        commands.add("\"%ProgramFiles(x86)%\\JetBrains\\RubyMine 2022.1\\bin\\Uninstall.exe\" /S");
        
        
		for(String s : commands)
		{
			ProcessBuilder builder = new ProcessBuilder( "cmd.exe", "/c",s);
			Process p = builder.start();
			Thread.sleep(1800);
			System.out.println(s);

		}
	
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		UninstallSoftwares us=new UninstallSoftwares();
		us.uninstall();
		
	}

}
