/**
 * 
 */
package com.wordpress.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helper.Base;

/**
 * @author Aneesha
 * 
 *         This class is to store locators and methods of login page
 *
 */
public class LoinPage {
	WebDriver driver;

	By userName = By.id("user_login");
	By password = By.xpath("//*[@id='user_pass']");
	By loginButton = By.cssSelector("input#wp-submit");

	public LoinPage(WebDriver driver) {
		super();
		this.driver = driver;
	}



	public void login(String uid, String pwd) {
		driver.findElement(userName).sendKeys(uid);
		Base.waitForElement(password);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
	}

}
