package com.learnselenium.basics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import junit.framework.Assert;
import utility.Utility;

public class ExtentReportDemo {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	@BeforeTest
	public void setReport() {
	
	 //htmlReporter=new ExtentHtmlReporter("./ExtentReports/extent-htmlreport.html");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
	 extent=new ExtentReports();
	 extent.attachReporter(htmlReporter);
	/*	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/STMExtentReport.html");
    	// Create an object of Extent Reports
	extent = new ExtentReports();  
	extent.attachReporter(htmlReporter);*/
	// htmlReporter.config().setAutoCreateRelativePathMedia(true);
	}
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");		
		driver = new ChromeDriver();
		driver.get("https://google.com");
				driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void verifyTitle() {
	logger=	extent.createTest("verifyTitle");
	logger.createNode("title captured");
	String title=driver.getTitle();
	boolean tileFlag=title.contains("Google");
	Assert.assertEquals(title, "Googkkkkle");
	logger.createNode("title verified");
	
	
	}
	
/*	public static String getScreenShot(WebDriver driver, String scName) throws Exception {
	
		String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination=System.getProperty("user.dir") +"/Screenshots/"+scName+date+".png";
		File finalDestination=new File(destination);
		
		FileUtils.copyFile(source, finalDestination);
		
		System.out.println("sc taken");
		return destination;
		
	}*/
	
	
	
	@Test
	public void verifyImage() {
		logger=extent.createTest("verifyImage");
		logger.createNode("image captured");
	boolean flag=	driver.findElement(By.id("hplogo")).isDisplayed();
		Assert.assertTrue(flag);
		logger.createNode("Image verified");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Throwable {
		
		if (result.getStatus()==ITestResult.FAILURE) {
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"Testcase failed", ExtentColor.RED));
			logger.log(Status.FAIL, result.getThrowable().getMessage().toString());
			
			String screenshotPath=Utility.getScreenShot1(driver, result.getName());
			//logger.fail("Test Case Failed Snapshot is below " +  logger.addScreenCaptureFromPath(screenshotPath));
			//logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			
			
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			logger.log(Status.PASS, result.getName() +"Testcase Pssed");
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Testcase Passed", ExtentColor.GREEN));
			
		}
		extent.flush();
		driver.quit();
		
	}
	
	

}
