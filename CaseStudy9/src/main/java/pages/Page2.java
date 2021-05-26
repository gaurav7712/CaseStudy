package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import browser.Browser;

public class Page2 {
	public static void Search() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/resources/ObjectRepository/config.properties";
		File file=new File(path);
		FileInputStream fin=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fin);
		String searchicon=prop.getProperty("SearchIconlink");
		String searchBox=prop.getProperty("SearchTextlink");
		Browser.driver.findElement(By.xpath(searchicon)).click();
		WebElement search=Browser.driver.findElement(By.xpath(searchBox));
		String text=prop.getProperty("SearchText");
		search.sendKeys(text);
	}
	
	public static void Click() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/resources/ObjectRepository/config.properties";
		File file=new File(path);
		FileInputStream fin=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fin);
		
	}
	
	public static void Compare() throws IOException
	{	
		String path=System.getProperty("user.dir")+"/src/test/resources/ObjectRepository/config.properties";
		File file=new File(path);
		FileInputStream fin=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fin);
		int input=Integer.parseInt(Browser.prop.getProperty("comparevalue"));
		String compare=prop.getProperty("compareresult");
		WebElement number=Browser.driver.findElement(By.xpath(compare));
		String total=number.getText();
		String[] num=total.split(" ",3);
	
		
		String nums[]=num[1].split(",");
		String num1=nums[0];
		num1+=nums[1];
		int numint=Integer.parseInt(num1); 
		System.out.println(num1);
		 
		try{
			Assert.assertTrue((numint > input)?true:false);
			System.out.println("Status: Pass");	
		 }
		  	
		 catch (AssertionError e){
			 System.out.println("Status: Fail");
		}
	}
}
