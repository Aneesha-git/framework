package com.learnselenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.Test;

public class HandleLocators {

	WebDriver driver;
	String url = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";

	@Test(enabled=false)

	public void findAllElements() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("In the Maven Project");
		driver.get(url);
		driver.manage().window().maximize();		
		
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys("Aniiiii");
		driver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
				
		driver.findElement(By.xpath("//input[@id='sum1'][@type='text']")).sendKeys("1");
		driver.findElement(By.xpath("//*[contains(@id,'sum2')]")).sendKeys("1010");
		driver.findElement(By.xpath("//button[starts-with(text(),'Get')]")).click();;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String value= driver.findElement(By.xpath("//div/span[@id='displayvalue']")).getText();
		System.out.println("value is"+value);
		driver.quit();

	}
	
	@Test(enabled=true)
	public void CssDemo() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("In the Maven Project");
		driver.get(url);
		driver.manage().window().maximize();	
		driver.findElement(By.cssSelector("input#user-message")).sendKeys("Hello CSS");
		driver.findElement(By.cssSelector("button[class^='btn btn-']")).click();
	}
	
	@Test(enabled=false)
	public void TableDemo() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("In the Maven Project");
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='BE_flight_origin_date']")).click();
		
		driver.findElement(By.xpath("//div[@id='month-scroll0']/div[1]/div[1]//tr[3]/td[6]")).click();
		
		
	}
}
