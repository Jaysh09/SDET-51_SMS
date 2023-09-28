package java.com.SMS.genericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.SMS.ObjectRepository.LoginPage;
import com.beust.jcommander.Parameter;

public class Baseclass {

	public DataBaseUtility dlib = new DataBaseUtility();
	public ExcelUtility elib = new ExcelUtility();
	public FileUtility flib =  new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public static WebDriver sdriver;
	
	public WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable 
	{
		dlib.connectToDB();
		System.out.println("-- connect to DB --");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable 
	{
		String Browser = flib.getPropertyKeyValue("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("-- invalid browser--");
		}
		System.out.println("--Launch the browser--");
		
		 sdriver = driver;
		wlib.maximizeTheBrowser(driver);
			
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable 
	{
		String URL = flib.getPropertyKeyValue("url");
		String Email = flib.getPropertyKeyValue("Email");
		String Password = flib.getPropertyKeyValue("password");
		
		driver.get(URL);
		wlib.implicitWait(driver,2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.login(Email, Password);
		System.out.println("--Login to App--");
	
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
	//	HomePage hp = new HomePage(driver);
	//	hp.signOut(driver);
		System.out.println("--singout from app--");
	}
	
			
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
	driver.quit();
	System.out.println("-- close the browser--");
	}
	
	@AfterSuite(alwaysRun = true)
		public void configAS() throws Throwable
		{
		dlib.closeDB();
		System.out.println("-- close DB connection");
	}
	
}
