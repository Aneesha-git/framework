package com.learnselenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DragDropDemo {
	WebDriver driver = null;
	String url1 = "http://jqueryui.com/droppable/";
	@Test(enabled=false)
	public void dragDemo() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url1);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		
		WebElement drag= driver.findElement(By.cssSelector("#draggable"));
		WebElement drop =driver.findElement(By.cssSelector("#droppable"));
		Actions action=new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
		driver.quit();
		
	}
	
	@Test(enabled=false)
	public void demo2() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	 
	driver.manage().window().maximize();
	 
	driver.get("http://www.naukri.com");
	
	// Create object on Actions class
	Actions action=new Actions(driver);
	 
	// Type something on Skill textbox
	WebElement element=driver.findElement(By.cssSelector("div.mTxt"));
	WebElement target=driver.findElement(By.xpath("//ul[@class='midSec menu']/li/div/ul//li[3]/a"));
	


	 
	// use Mouse hover action for that element
	action.moveToElement(element).build().perform();
	 
	// Give wait for 2 seconds 
	Thread.sleep(2000);
	 action.moveToElement(target).build().perform();
	// finally click on that element
	action.click(target).build().perform();
	}
@Test
public void scrolling() {
System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	 
	driver.manage().window().maximize();
	 
	driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
	
	
	JavascriptExecutor je=(JavascriptExecutor)driver;
	WebElement element=driver.findElement(By.xpath(".//*[@id='mCSB_container']/p[3]"));
	je.executeScript("arguments[0].scrollIntoView(true);",element);
	driver.quit();
}

}

