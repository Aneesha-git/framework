package com.wordpress.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.wordpress.pages.LoinPage;

public class LoginTest {
	
@Test
public void VerifyLogin() {
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://demosite.center/wordpress/wp-login.php");
	
	LoinPage loginpage=new LoinPage(driver);
	loginpage.login("admin", "demo123");
	driver.quit();
}

}
