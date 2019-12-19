package com.learnselenium.basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoWindowHandles {
	
	WebDriver driver;
	String url="http://www.naukri.com/";
	
	@Test
	public void demoMutipleWindows() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		String mainWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		
		Iterator<String> it=windows.iterator();
		
		while(it.hasNext()) {
			String childWindow=it.next();
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			System.out.println(driver.getTitle());
				driver.close();
			}
		}
	/*	
		for(String childWindow:windows) {
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
	}
*/
}}
