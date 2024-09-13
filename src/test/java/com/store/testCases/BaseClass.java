package com.store.testCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.store.Utilities.readConfigFile;

import io.github.bonigarcia.wdm.WebDriverManager;

//creating methods which are going to be used in all the test cases throughout 
public class BaseClass 
{
	readConfigFile  readConfig = new readConfigFile();
	
	String url = readConfig.getBaseUrl();
	String Urlbrowser= readConfig.getBrowser();
	
	
	
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	
	//Selecting browser
	public void setupBrowser()
	{
		System.out.println("Before Class");
		//for logging 
		
	    logger = LogManager.getLogger("store");
		
		switch(Urlbrowser.toLowerCase())
		{
		case "chrome":
			
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritei\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Browser Opened");
			driver.manage().window().maximize();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Browser Opened");
			driver.manage().window().maximize();
			break;
			
		case "firefox":
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Browser Opened");
			driver.manage().window().maximize();
			break;
			
		default:
			driver = null;
			break;
		}
		
		
		//implicit wait for 10 sec
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		//open the url

		driver.get(url);
		

	   
	}
	
	
	@AfterClass	
	public void tearDown()
	{
		System.out.println("After Class");
		logger.info("browser Closed");
		//driver.close();
		driver.quit();
	}
	
	
	public void captureScreenShot(WebDriver driver, String testName) throws IOException 
	{
		// Step1 : Convert webdriver object to Take Screenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		// Step1 : call get
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest =  new File (System.getProperty("user.dir") + "//Screenshots// " + testName + ".png");
		
		FileUtils.copyFile(src, dest);
	}

}
