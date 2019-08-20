package com.qa.hs.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.qameta.allure.Step;


/**
 * @Name: Selenium Hybrid Framework
 * @author Akash Rastogi
 * @Date : 13-Aug-2019
 */


public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
//	@Step("Initialize the driver")
	public WebDriver init_driver(String browserName){
		if(browserName.equals("chrome")){
			//System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\drivers\\chromedriver.exe");
						
			if(prop.getProperty("headless").equals("yes")){
				//headless mode:
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}else{
				driver = new ChromeDriver();
			}
		} else if(browserName.equals("firefox")){
			//System.setProperty("webdriver.gecko.driver", "/Users/NaveenKhunteta/Downloads/geckodriver");
			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\drivers\\geckodriver");
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	//@Step("Initialize the cofig properties file")
	public Properties init_properties(){
		prop = new Properties();
		
		String projectPath = System.getProperty("user.dir");
		//System.out.println("projectPath : " + projectPath);
		try {
//			FileInputStream ip = new FileInputStream("/Users/NaveenKhunteta/Documents/workspace/KeywordDrivenHubSpot"
//					+ "/src/main/java/com/qa/hs/keyword/config/config.properties");

			FileInputStream ip = new FileInputStream(projectPath + "\\src\\main\\java\\com\\qa\\hs\\keyword\\config\\config.properties");
			//System.out.println("FINAL PATH : " + projectPath + "\\src\\main\\java\\com\\qa\\hs\\keyword\\config\\config.properties");	
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
	

}
