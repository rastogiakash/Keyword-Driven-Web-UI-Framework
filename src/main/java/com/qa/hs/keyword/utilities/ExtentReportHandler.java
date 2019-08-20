
package com.qa.hs.keyword.utilities;

import org.testng.annotations.AfterMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportHandler {
	
public static ExtentHtmlReporter htmlReporter;
public static ExtentReports extent;
public static ExtentTest test;



@BeforeSuite
public void setExtent(){
	
	//System.out.println("Inside setExtent ... ");
	
	String reportPath = System.getProperty("user.dir") +  "\\Reports\\AutomationhtmlReport.html";
	htmlReporter = new ExtentHtmlReporter(reportPath);
	
	htmlReporter.config().setDocumentTitle("Automation Report");
	htmlReporter.config().setReportName("Functional Report");
	htmlReporter.config().setTheme(Theme.DARK);
	
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	
	extent.setSystemInfo("Hostname", "Localhost");
	extent.setSystemInfo("OS", "Windows10");
	extent.setSystemInfo("Tester Name", "Akash Rastogi");
	extent.setSystemInfo("Browser", "Chrome");
	
	//return extent;
}


@AfterMethod
public void tearDown(ITestResult result)
{
	if(result.getStatus() == ITestResult.FAILURE)
	{
		System.out.println("Inside tearDown ... ");
		//MarkupHelper is used to display the output in different colors
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
//		test.log(Status.FAIL, "Test Case Failed IS " + result.getName());
//		test.log(Status.FAIL, "Test Case Failed IS " + result.getThrowable());
		
		//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
		//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 
		//String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
//		String screenshotPath = getScreenShot(driver, result.getName());
		
		//To add it in the extent report 
//		test.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
	}
	else if(result.getStatus() == ITestResult.SUCCESS){
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
//		test.log(Status.PASS, " Test Case PASSED IS " + result.getName());
	}
	else 
	{
		//(result.getStatus() == ITestResult.SKIP){
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE)); 
//		test.log(Status.SKIP, "Test Case Skipped IS " + result.getName());
	} 
}

@AfterSuite
public void endExtent(){
	System.out.println("Inside flush ... ");
		extent.flush();
}










/*
 * -----------------------------------------------------------------------------------------------------------------------------------------------------
@BeforeTest
public static ExtentReports setExtent(){
	
	System.out.println("Inside setExtent ... ");
	
	String reportPath = System.getProperty("user.dir") +  "\\Reports\\AutomationhtmlReport.html";
	htmlReporter = new ExtentHtmlReporter(reportPath);
	
	htmlReporter.config().setDocumentTitle("Automation Report");
	htmlReporter.config().setReportName("Functional Report");
	htmlReporter.config().setTheme(Theme.DARK);
	
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	
	extent.setSystemInfo("Hostname", "Localhost");
	extent.setSystemInfo("OS", "Windows10");
	extent.setSystemInfo("Tester Name", "Akash Rastogi");
	extent.setSystemInfo("Browser", "Chrome");
	
	return extent;
}

@AfterMethod
public void tearDown(ITestResult result)
{
	if(result.getStatus() == ITestResult.FAILURE){
		System.out.println("Inside tearDown ... ");
		//MarkupHelper is used to display the output in different colors
//		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		test.log(Status.FAIL, "Test Case Failed IS " + result.getName());
		test.log(Status.FAIL, "Test Case Failed IS " + result.getThrowable());
		
		//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
		//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 
		//String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
//		String screenshotPath = getScreenShot(driver, result.getName());
		
		//To add it in the extent report 
//		test.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
	}
	else if(result.getStatus() == ITestResult.SKIP){
//		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		test.log(Status.SKIP, "Test Case Skipped IS " + result.getName());
	} 
	else if(result.getStatus() == ITestResult.SUCCESS){
//		test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		test.log(Status.PASS, " Test Case PASSED IS " + result.getName());
	}
}

@AfterTest
public void endExtent(){
	System.out.println("Inside flush ... ");
		extent.flush();
}

*----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

}
