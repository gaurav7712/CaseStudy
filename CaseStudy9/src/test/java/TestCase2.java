import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import browser.Browser;
import pages.Page1;
//import screenshot.CaptureScreen;

public class TestCase2 {
	//Setting Driver and Opening Application
	@BeforeMethod
	public void beforeTest() throws Exception
	{
		try
		{
			Browser.setDriver();
			Browser.getUrl();
		}
		catch(Exception e)
		{
			System.out.println("Test case 2 before test");
		}
	}
	@Test(priority=1)
	public void browserTest() throws Exception 
	{
		try
		{
			Page1.holiday();
		}
		catch(Exception e)
		{
			System.out.println("Testcase 2 test");
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