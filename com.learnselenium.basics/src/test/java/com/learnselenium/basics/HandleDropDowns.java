package com.learnselenium.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SuppressForbidden;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.sourceforge.htmlunit.corejs.javascript.tools.shell.QuitAction;
import utility.Utility;

public class HandleDropDowns {

	WebDriver driver = null;
	String url = "http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html";
	String url1="https://login.yahoo.com/account/create?specId=yidReg";
	
	public void openChrome(String localurl) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("In the Maven Project");
		driver.get(localurl);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(enabled=false)
	public void handleDD() {
		
		openChrome(url);

		driver.findElement(By.cssSelector("button[id='menu1']")).click();
		List<WebElement> dd_menu = driver.findElements(By.xpath("//*[@class='dropdown-menu']/li/a"));
	
		for (WebElement list_element : dd_menu) {
			String ele=list_element.getAttribute("innerHTML");
			if (ele.contentEquals("CSS")) {
				System.out.println("value====================="+list_element.getText());
				list_element.click();
				break;
			}
		
		}
		
		driver.quit();	
	}
	
	@Test
	public void DD_Select() throws Exception {
		
		openChrome(url1);
		Utility.getScreenShot1(driver, "yahoo");
		
		WebElement dd=driver.findElement(By.cssSelector("select#usernamereg-month"));
		Select month_dd = new Select(dd);
		month_dd.selectByValue("2");
		WebElement selected_month1=month_dd.getFirstSelectedOption();
		System.out.println(selected_month1.getText());
		
		month_dd.deselectByValue("2");
		month_dd.selectByVisibleText("March");
		WebElement selected_month2=month_dd.getFirstSelectedOption();
		System.out.println(selected_month2.getText());
		
		
	
		
		
	}
	
	
	
}