package com.learnselenium.basics;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class LoggerDemo {
	WebDriver driver;
	String url1 = "http://jqueryui.com/droppable/";
	
	
	@Test(enabled=true)
	public void dragDemo() {
		Logger logger= Logger.getLogger("LoggerDemo") ;
		PropertyConfigurator.configure("Log4j.properties");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("browser opened");
		driver.get(url1);
		logger.info("app launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		
		WebElement drag= driver.findElement(By.cssSelector("#draggable"));
		WebElement drop =driver.findElement(By.cssSelector("#droppable"));
		Actions action=new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
		logger.info("drop happened");
		driver.quit();
		
	}
	

}
