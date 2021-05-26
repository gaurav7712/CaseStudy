import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import browser.Browser;
import pages.Page1;
import pages.Page2;

//import screenshot.CaptureScreen;

public class TestCase3 {
	//Setting Driver and Opening Application
	@BeforeMethod
	public void beforeTest() throws Exception
	{
		try
		{
			Browser.setDriver();
			Browser.getUrl();
			Page1.holiday();
		}
		catch(Exception e)
		{
			System.out.println("Test case 3 before test");
		}
	}
	@Test
	public void searchTest() throws Exception 
	{
		try
		{
			Page2.Search();
		}
		catch(Exception e)
		{
			System.out.println("Testcase 3 test");
		}
	}
	@Test
	public void compareTest() throws Exception 
	{
		try
		{
			Page2.Compare();
		}
		catch(Exception e)
		{
			System.out.println("Testcase 3 test");
		}
	}
	@Test
	public void clickTest() throws Exception 
	{
		try
		{
			Page2.Click();
		}
		catch(Exception e)
		{
			System.out.println("Testcase 3 test");
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