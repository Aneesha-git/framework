package com.learnselenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleRdioButton {
	WebDriver driver = null;
	String url = "http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html";

	@Test
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("In the Maven Project");
		driver.get(url);
		driver.manage().window().maximize();

		java.util.List<WebElement> radio = driver.findElements(By.xpath("//input[@id='java'][@type='radio']"));

		for (WebElement rb : radio) {
			String value = rb.getAttribute("value");
			System.out.println(value);
		}

		driver.quit();

	}
}
