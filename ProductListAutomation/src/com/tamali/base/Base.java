package com.tamali.base;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//This class contains methods related to setting up and closing the WebDriver instance
public class Base
{
	public static WebDriver driver;
	public static Properties prop;
	
	/**

	This method sets up the WebDriver instance based on the browser specified in the 
	configuration properties file.

	It also maximizes the browser window.
	*/
	public void driverSetup()
	{
		prop=new Properties();
		
		try 
		{
			prop.load(new FileInputStream("src/Config/config.properties"));
		}	
		 catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		if(prop.getProperty("browserName").matches("edge"))
		{
			driver=new EdgeDriver();
		}
		
		if(prop.getProperty("browserName").matches("chrome"))
		{
			 ChromeOptions co = new ChromeOptions();
		     co.addArguments("--remote-allow-origins=*");
//		     co.addArguments("--disable-popup-blocking");
			 driver=new ChromeDriver(co);
		}
		
		if(prop.getProperty("browserName").matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
	}
	

	//This method closes the WebDriver instance.
	public void closeBrowser()
	{
		driver.quit();
	}

}


