package pages;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import browser.Browser;
public class Page1 {
	public static void holiday() throws Exception
	{
		try
		{
		String fileLocation=System.getProperty("user.dir")+"/src/test/resources/objectrepository/config.properties";
		File file=new File(fileLocation);
		FileInputStream fileinput=new FileInputStream(file);
		Browser.prop=new Properties();
		Browser.prop.load(fileinput);
		String link=Browser.prop.getProperty("holidayPartialLinkText");
		WebElement holidayLink=Browser.driver.findElement(By.partialLinkText(link));
		Actions act=new Actions(Browser.driver);
		act.moveToElement(holidayLink).perform();
		holidayLink.click();
		}
		catch(Exception e)
		{
			System.out.println("Clicking holiday cruises");
		}
	}
}