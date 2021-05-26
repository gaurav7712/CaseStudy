package browser;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Browser
{

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static Properties prop;
	public static Logger log;
	private static final Logger logBase = LogManager.getLogger(browser.Browser.class);
	public static String fileLocation=System.getProperty("user.dir")+"/src/test/resources/objectrepository/config.properties";
	public static File file=new File(fileLocation);
	public static WebDriver setDriver() throws Exception
	{
		logBase.debug("Opening browser");
		System.out.println("Choosing from the following 3\n1.Chrome\n2.Edge\n3.Firefox");
		FileInputStream fileinput=new FileInputStream(file);
		prop=new Properties();
		prop.load(fileinput);
		String name=prop.getProperty("browserName");
		if(name.equalsIgnoreCase("chrome"))
			driver=setChromeDriver();
		else if(name.equalsIgnoreCase("edge"))
			driver=setEdgeDriver();
		else  if(name.equalsIgnoreCase("firefox"))
			driver=setFirefoxDriver();
		else
			System.out.println("Invalid browser name");
		logBase.info("Opened browser");
		System.out.println(driver);
		return driver;
		
	}
	public static WebDriver setChromeDriver()
	{
		logBase.debug("Opening browser");
		try
		{
		FileInputStream fileinput=new FileInputStream(file);
		prop=new Properties();
		prop.load(fileinput);
		String driverPathChrome1=(System.getProperty("user.dir")+prop.getProperty("chromeDriver"));
		System.setProperty("webdriver.chrome.driver", driverPathChrome1);
		driver=new ChromeDriver();
		logBase.info("Opened browser");
		}
		catch(Exception e)
		{
			logBase.error("Failed to open browser");
			System.out.println("Browser open exception");
		}
		return driver;
	}
	public static WebDriver setEdgeDriver()
	{
		logBase.debug("Opening browser");
		try
		{
			FileInputStream fileinput=new FileInputStream(file);
			prop=new Properties();
			prop.load(fileinput);
		String driverPathEdge=(System.getProperty("user.dir")+prop.getProperty("msedgeDriver"));
		System.setProperty("webdriver.edge.driver", driverPathEdge);
		driver=new EdgeDriver();
		logBase.info("Opened browser");
		return driver;
		}
		catch(Exception e)
		{
			logBase.error("Failed to open browser");
			System.out.println("Browser open exception");
		}
		return driver;
	}
	public static WebDriver setFirefoxDriver() 
	{
		logBase.debug("Opening browser");
		try
		{
			
			FileInputStream fileinput=new FileInputStream(file);
			prop=new Properties();
			prop.load(fileinput);
		String driverPathFirefox=(System.getProperty("user.dir")+prop.getProperty("firefoxDriver"));
		System.setProperty("webdriver.gecko.driver", driverPathFirefox);
		driver=new FirefoxDriver();
		logBase.info("Opened browser");
		}
		catch(Exception e)
		{
			logBase.error("Failed to open browser");
			System.out.println("Browser open exception");
		}
		return driver;
	}
	public static void getUrl() throws Exception
	{
		logBase.debug("Opening url");
		try
		{
			FileInputStream fileinput=new FileInputStream(file);
			prop=new Properties();
			prop.load(fileinput);
		driver.get(prop.getProperty("websiteURL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		logBase.info("Opened url");
		}
		catch(Exception e)
		{
			logBase.error("Failed to open url");
			System.out.println("Url open exception");
		}
	}
	public static void closeBrowser()
	{
		logBase.debug("Closing Browser");
		try
		{
            driver.quit();
            logBase.info("Closing browser");
		}
		catch(Exception e)
		{
			logBase.error("Closing browser failed");
			System.out.println("Driver close exception\n"+e);
		}
	}
	}