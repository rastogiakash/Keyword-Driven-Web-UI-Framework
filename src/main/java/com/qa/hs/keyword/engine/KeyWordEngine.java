package com.qa.hs.keyword.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.hs.keyword.base.Base;
import com.qa.hs.keyword.utilities.ExcelReaderHandler;
import com.qa.hs.keyword.utilities.ExtentReportHandler;

//import io.qameta.allure.Step;


/**
 * @Name: Selenium Hybrid Framework
 * @author Akash Rastogi
 * @Date : 13-Aug-2019
 */


public class KeyWordEngine extends ExtentReportHandler {

	public WebDriver driver;
	public Properties prop;

	public static Workbook book;
	public static Sheet sheet;

	public Base base;
	public WebElement element;

	/*
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentReportHandler extentReportHandler;
	*/
	
	String projectPath = System.getProperty("user.dir");
	public final String SCENARIO_SHEET_PATH = projectPath + "\\src\\main\\java\\com\\qa\\hs\\keyword\\scenarios\\hubspot_scenarios.xlsx";
	
	
	//public final String SCENARIO_SHEET_PATH = projectPath + "/src/main/java/com/qa/hs/keyword/scenarios/hubspot_scenarios.xlsx";
	//public final String SCENARIO_SHEET_PATH = "/Users/NaveenKhunteta/Documents/workspace/KeywordDrivenHubSpot"
	//		+ "/src/main/java/com/qa/hs/keyword/scenarios/hubspot_scenarios.xlsx";

//	@Step("Getting Values of locatortype, locatorValue, action and value")
	public void startExecution(String sheetName) {
		
		
		test.log(Status.INFO, "Call to Excel Reader Handler is made");			
		ExcelReaderHandler xlReader = new ExcelReaderHandler(SCENARIO_SHEET_PATH);
		/*
		FileInputStream file = null;
		try {
			file = new FileInputStream(SCENARIO_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		int k = 0;
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			try {

				String locatorType = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
				String locatorValue = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
				String action = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
				String value = sheet.getRow(i + 1).getCell(k + 4).toString().trim();
		*/
		test.log(Status.INFO, "values for parameters << locatorType, locatorValue, action, value >>  is fetched");
		
		int k=0;
		for (int i = 0; i < xlReader.getRowCount(sheetName); i++)
		{
			try {
				
				String locatorType = xlReader.getCellData(sheetName, i+1, k+1);
				String locatorValue = xlReader.getCellData(sheetName, i+1, k+2);
				String action = xlReader.getCellData(sheetName, i+1, k+3);
				String value = xlReader.getCellData(sheetName, i+1, k+4);
				
							

				
				switch (action) {
				case "open browser":
					base = new Base();
					prop = base.init_properties();
					if (value.isEmpty() || value.equals("NA")) {
						driver = base.init_driver(prop.getProperty("browser"));
					} else {
						driver = base.init_driver(value);
					}
					break;

				case "enter url":
					if (value.isEmpty() || value.equals("NA")) {
						driver.get(prop.getProperty("url"));
						Thread.sleep(5000);
					} else {
						driver.get(value);
						Thread.sleep(5000);
					}
					break;

				case "quit":
					driver.quit();
					break;
				default:
					break;
				}
				
				switch (locatorType) {
				case "id":
					element = driver.findElement(By.id(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						System.out.println("text from element : " + elementText);
					}
					locatorType = null;
					break;

				case "name":
					element = driver.findElement(By.name(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						System.out.println("text from element : " + elementText);
					}
					locatorType = null;
					break;

				case "xpath":
					Thread.sleep(5000);
					element = driver.findElement(By.xpath(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						test.log(Status.INFO, "Elemnt is checked if it is getting displayed or not...");			
						Boolean status = element.isDisplayed();
						Assert.assertTrue(status);
						test.log(Status.INFO, "Call to Excel Reader Handler is made");			
						/*if (element.isDisplayed())
						{
							System.out.println("The element exixts: " + element.getText());
						}*/
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						Assert.assertEquals(elementText, value);
						//System.out.println("text from element : " + elementText);
						
						/*if (elementText.equals(value))
						{
						System.out.println("result from Header is as expected : " + elementText);
						}*/
					}
					locatorType = null;
					break;

				case "cssSelector":
					Thread.sleep(5000);
					element = driver.findElement(By.cssSelector(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
						if (element.isDisplayed())
						{
							System.out.println("The element exixts: " + element.getText());
						}
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						if (elementText.equals(value))
						{
						System.out.println("result from Header is as expected : " + elementText);
						}
					}
					locatorType = null;
					break;

				case "className":
					Thread.sleep(5000);
					element = driver.findElement(By.className(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
						if (element.isDisplayed())
						{
							System.out.println("The element exixts: " + element.getText());
						}
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						//System.out.println("text from element : " + elementText);
						if (elementText.equals(value))
						{
						System.out.println("result from Header is as expected : " + elementText);
						}
					}
					locatorType = null;
					break;

				case "linkText":
					element = driver.findElement(By.linkText(locatorValue));
					element.click();
					locatorType = null;
					break;

				case "partialLinkText":
					element = driver.findElement(By.partialLinkText(locatorValue));
					element.click();
					locatorType = null;
					break;

				default:
					break;
				}

			} catch (Exception e) {

			}

		}

	}
}
