/**
 * 
 */
package com.NewVision.Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.NewVision.Testcases.GlobalVariable;
import com.NewVision.Testcases.TestCase1;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import net.bytebuddy.asm.Advice.Enter;
/**
 * @author siddharthj
 *This class will store all the locators and methods of Fleet studio Work Page (POM)
 */
public class workPage extends TestCase1 {
	
	public static ExtentTest test1;
	 ExtentTest Loggers;
	 ExtentReports report;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	By Career = By.xpath("//div[@class='menu-footer-company-menu-container']//*[text()='Careers']");
	By SearchJob = By.xpath("//input[@id='awsm-jq-1']");
	By QALead = By.xpath("//h2[contains(text(), 'QA Lead')]");
	By EnterEmail = By.xpath("/html/body/div[4]/div[2]/div/section/div/div[2]/div/div[5]/div/div/div/div[1]/input");
	
	
	
	
	
	public workPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void navigateCareerPage() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Career));
		   
		driver.findElement(Career).click();
	}
	
	public void VerifyDestinationURL() {
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchJob));
		System.out.println("Use of Explicit wait");
		String URL1 = driver.getCurrentUrl();
		System.out.println(URL1);
		
		if(URL1.equalsIgnoreCase("https://www.newvision-software.com/careers/")) {
			System.out.println("Landed on Email Sequence page Page successfully");
		}
		else{
			System.out.println("Landed on incorrect page");
		}	
	}
	
	
	public void SearchOpening() {
		driver.findElement(SearchJob).sendKeys("QA Lead");
		driver.findElement(SearchJob).sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(QALead));
		
		driver.findElement(QALead).click();
		}
	
		
	}
