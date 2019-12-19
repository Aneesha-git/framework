/**
 * 
 */
package com.wordpress.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.helper.Base;
import com.wordpress.pages.LoginPageNew;

import utility.ConfigReader;

/**
 * @author renia
 *
 */
public class LogintestNew {
	WebDriver driver;
	

	@Test
	@Parameters("username")
	public void VerifyLogin(String username) {
		ConfigReader config=new ConfigReader();
		System.out.println(config.getURL());
		
	driver=	Base.startBrowser("chrome",config.getURL());
		
	LoginPageNew loginPage=PageFactory.initElements(driver, LoginPageNew.class);

	loginPage.Login("admin", "demo123");
	driver.quit();	

	}
	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
