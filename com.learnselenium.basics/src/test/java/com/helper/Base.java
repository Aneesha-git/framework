/**
 * 
 */
package com.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author renia
 *
 */
public class Base {
	
	public static WebDriver driver;
	/*public Base(WebDriver driver) {
		this.driver=driver;
	}
*/	
	public static WebDriver startBrowser(String browserName,String url) {
		
		switch(browserName) {
			case "chrome": 
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				driver.get(url);
				break;
			case "firefox" :
				driver=new FirefoxDriver();
		}
	
		return driver;
		
	}
	
	public static void waitForElement(By expeEle) {
		try {
		WebElement ele = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		ele = wait.until(ExpectedConditions.presenceOfElementLocated(expeEle));
		
		}catch(Exception e) {
			System.out.println("element not found");
		}

	}

}
