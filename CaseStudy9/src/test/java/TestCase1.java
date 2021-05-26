import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import browser.Browser;
//import screenshot.CaptureScreen;

public class TestCase1 {
	//Setting Driver and Opening Application
	@BeforeMethod
	public void beforeTest() throws Exception
	{
		try
		{
			Browser.setDriver();
		}
		catch(Exception e)
		{
			System.out.println("Test case 1 before test");
		}
	}
	@Test(priority=1)
	public void browserTest() throws Exception 
	{
		try
		{
			Browser.getUrl();
		}
		catch(Exception e)
		{
			System.out.println("Testcase 1 test");
		}
	}
	//Closing the Driver
	@AfterMethod
	public void afterTest() throws Exception 
	{
		try
		{
		//CaptureScreen.screenShot(1);
		Browser.closeBrowser();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}