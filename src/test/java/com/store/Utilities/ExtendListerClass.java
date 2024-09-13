package com.store.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendListerClass implements ITestListener
{
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "StoreTestReport-" + timestamp + ".html";
		
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		
		//add system information/environment info to reports
		
		readConfigFile readConfig =  new readConfigFile();
		
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("OS:", "Windows11");
		reports.setSystemInfo("browser:", readConfig.getBrowser());
		reports.setSystemInfo("User name:", "Ritesh");
		
		
		//Configuration to change look and feel of the report
		htmlReporter.config().setDocumentTitle("Extent Listner Reports Demo");
		htmlReporter.config().setReportName("This is my first report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	
	public void onStart(ITestContext Result)
	{
		configureReport();
		System.out.println("On Start Method invoked");
	}
	
	public void onFinish(ITestContext Result)
	{
		
		System.out.println("On Finish Method invoked");
		reports.flush();// it is mandatory to call flush method to ensure information is written to the stated reporter
	}
	
	
	
	//When Test case gets failed this method is called 
	
	public void onTestFailure(ITestResult Result)
	{
		
		System.out.println("name of the test method failed: "+ Result.getName());
		//create entry in Html report 
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: "+ Result.getName(), ExtentColor.RED));
		String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName()+".png" ;
		
		File screenShotFile = new File(screenShotPath);
		if(screenShotFile.exists())
		{
			test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		}
		//test.addScreenCaptureFromPath(null);
	}
	
	
	//when the test method gets skipped, this method is called.
	
	public void onTestSkipped(ITestResult Result)
	{
		
		
		System.out.println("name of the test method skipped: "+ Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skip test case is: "+ Result.getName(), ExtentColor.YELLOW));
	}
	
	
	//when the test method gets started, this method is called.
	public void onTestStart(ITestContext Result)
	{
		
		System.out.println("name of the test method started: "+ Result.getName());
	
	}
	
	
	
	//when the test method gets passed, this method is called.
	
	public void onTestSuccess(ITestResult Result)
	{
		
		
		System.out.println("name of the test method Successfully executed: "+ Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Successfully executed test case is: "+ Result.getName(), ExtentColor.GREEN));
	}
	
	
	
	public void onTestFailedButWithSuccessPercentage(ITestResult Result)
	{

	}
	

}
