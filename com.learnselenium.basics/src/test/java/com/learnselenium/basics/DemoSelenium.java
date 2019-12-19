package com.learnselenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoSelenium {

	WebDriver driver;
	String url = "http://www.facebook.com";
	String url1 = ("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");

	@BeforeTest
	public void initConfig() {

	}

	@Test
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.out.println("In the Maven Project");
		driver.get(url1);
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
		
		boolean status= element.isDisplayed();
		if(status)
			System.out.println("passed");
		else
			System.out.println("failed");
	
		String title = driver.getTitle();
		boolean value = title.contains("ss");
		System.out.println("status value" + value);

		driver.quit();
	}

	@Test
	public void openIE() {
		/*
		 * System.setProperty("webdriver.ie.driver", "D:\\Selenium\\msedgedriver.exe");
		 * driver= new InternetExplorerDriver(); driver.get(url);
		 * driver.manage().window().maximize();
		 */
		driver.quit();
	}

}
