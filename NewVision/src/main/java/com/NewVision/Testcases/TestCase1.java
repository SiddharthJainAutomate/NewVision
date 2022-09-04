package com.NewVision.Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.NewVision.Pages.workPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
/**
 * @author siddharthj
 * To class will work as POM as well as Generate the reports as well.
 */

public class TestCase1 {
	public static ExtentTest test;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	
	@BeforeSuite
	public void setup() {	
		  htmlReporter = new ExtentHtmlReporter("ExtentReport_NewVision.html");
	      extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	}
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUpTest(String browser) {
		System.out.println("Running Browser is " + browser);
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", GlobalVariable.driverPath);
		    driver =new ChromeDriver();
		}
		
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", GlobalVariable.driverPath1);
		    driver =new FirefoxDriver();   
		}
		 
		
	}
	 
	@Test
	public void test1() throws IOException {
		ExtentTest test = extent.createTest("New Vision POC", "Career page verification");
        driver.manage().window().maximize();
		driver.get(GlobalVariable.URL);
		workPage work =new workPage(driver);
		work.navigateCareerPage();
		test.log(Status.PASS, "Navigated and landed on Career page successfully");
		work.VerifyDestinationURL();
		test.log(Status.PASS, "URL of Career page verified successfully");
		work.SearchOpening();
		test.log(Status.PASS, "Landed on dream Job");	
	}
	
	
	
	@AfterTest
	public void tearDownTest() {
		//driver.close();
		//driver.quit();
		System.out.println("Test completed successfully");
	}
	
	@AfterSuite
	public void tearDown() {
	    extent.flush();
	}
	
	
	
	

}
