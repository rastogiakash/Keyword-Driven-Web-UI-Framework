package com.qa.hs.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.hs.keyword.engine.KeyWordEngine;
import com.qa.hs.keyword.utilities.ExtentReportHandler;


/**
 * @Name: Selenium Hybrid Framework
 * @author Akash Rastogi
 * @Date : 13-Aug-2019
 */


public class LoginTest extends ExtentReportHandler {
	
/*
	public static ExtentReports extent;
	public static ExtentTest test1;
	public static ExtentTest test2;
	public static ExtentReportHandler extentReportHandler;
*/	
	
	public KeyWordEngine keyWordEngine;
	

	@Test
	public void loginTest(){
	
		//System.out.println("Inside Login.... ");
		//extent = ExtentReportHandler.setExtent();
		test = extent.createTest("Login Test");
		
		test.log(Status.INFO, "Login TestCase Started...");		
		keyWordEngine = new KeyWordEngine();
		
		test.log(Status.INFO, "Call made to startExecution in Login");
		keyWordEngine.startExecution("login");

		test.log(Status.INFO, "Login TestCase Ends...");		
		//extent.flush();
		//extentReportHandler.endExtent();
	}
		
	@Test
	public void signUpTest(){

		//System.out.println("Inside signUp ... ");
		//extent = ExtentReportHandler.setExtent();
		test = extent.createTest("SignUp Test");
		
		test.log(Status.INFO, "SignUp TestCase Started...");		
		keyWordEngine = new KeyWordEngine();
		
		test.log(Status.INFO, "Call made to startExecution in SignUp");
		keyWordEngine.startExecution("signup");

		test.log(Status.INFO, "SignUp TestCase Ends...");		
		//extent.flush();

		//extentReportHandler.endExtent();
		
	}

	
	
	
	
	
	
	
	
	
	/*
	 * -----------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void loginTest(){
	
		System.out.println("Inside Login.... ");
		//extent = ExtentReportHandler.setExtent();
		test1 = extent.createTest("Login Test");
		
		test1.log(Status.INFO, "Login TestCase Started...");		
		keyWordEngine = new KeyWordEngine();
		
		test1.log(Status.INFO, "Call made to startExecution in Login");
		keyWordEngine.startExecution("login");

		test1.log(Status.INFO, "Login TestCase Ends...");		
		//extent.flush();
		//extentReportHandler.endExtent();
	}
		
	@Test
	public void signUpTest(){

		System.out.println("Inside signUp ... ");
		//extent = ExtentReportHandler.setExtent();
		test2 = extent.createTest("SignUp Test");
		
		test2.log(Status.INFO, "SignUp TestCase Started...");		
		keyWordEngine = new KeyWordEngine();
		
		test2.log(Status.INFO, "Call made to startExecution in SignUp");
		keyWordEngine.startExecution("signup");

		test2.log(Status.INFO, "SignUp TestCase Ends...");		
		//extent.flush();

		//extentReportHandler.endExtent();
		
	}
	
 * -----------------------------------------------------------------------------------------------------------------------------------------------------
*/	
	

}
