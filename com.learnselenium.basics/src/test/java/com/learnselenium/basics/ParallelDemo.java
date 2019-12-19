/**
 * 
 */
package com.learnselenium.basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author renia
 *
 */
public class ParallelDemo {
	WebDriver driver;
	
		String url = "http://jqueryui.com/droppable/";
	String url1 = "http://www.facebook.com";
	@Test(groups= {"smokeTest","functionalTest"})
	public void testcaseChrome1() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("smokeTest and Functional");
		driver.close();
		}
	
	@Test(groups= {"functionalTest"})
	public void testcaseChrome2() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.out.println("In the Maven Project");
		driver.get(url1);
		driver.manage().window().maximize();
		System.out.println(" Functional Test");
		driver.quit();
	}
		
	

}
