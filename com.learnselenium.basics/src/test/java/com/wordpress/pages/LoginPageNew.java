/**
 * 
 */
package com.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author renia
 *
 */
public class LoginPageNew {
	WebDriver driver;
	
	public  LoginPageNew(WebDriver driver) {
		this.driver=driver;
	}

		
	
	@FindBy(id="user_login")
	WebElement username;
	
	@FindBy(how=How.XPATH,using="//input[@id='user_pass']")
	WebElement password;
	
	@FindBy(name="wp-submit")
	WebElement loginButton;
	

	
	
	public void Login(String uid,String pwd) {
		Logger logger=Logger.getLogger("LoginPageNew");

		PropertyConfigurator.configure("Log4j.properties");
		username.sendKeys(uid);
		logger.info("username entered");
		password.sendKeys(pwd);
		loginButton.click();
		logger.info("login sucessful");
		
	}

}
