package com.learnselenium.basics;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class FluentWaitExample {
	WebDriver driver = null;
	String url1 = "https://www.makemytrip.us/";

	@Test
	public void demoFluentWait() {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// System.out.println("In the Maven Project");
		driver.get(url1);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='fromCity']")).click();

		List<WebElement> list_from = driver
				.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li//p"));
		for (WebElement from : list_from) {
			String from1 = from.getAttribute("innerHTML");
			System.out.println("from: " + from1);
			boolean flag = from1.equals("Mumbai, India");
			if (flag) {
				from.click();
				break;
			}
		}
		//WebElement toCity=driver.findElement(By.xpath("//input[@id='toCity']"));
		
		List<WebElement> list_to = driver.findElements(By.xpath(
				"//div[@class='fsw_inputBox searchToCity inactiveWidget activeWidget']//ul[@class='react-autosuggest__suggestions-list']//li//p"));
		// (By.xpath("//p[contains(text()='New York')]"));
		
		for (WebElement to : list_to) {
			if (to.getAttribute("innerHTML").contentEquals("New York, US")) {
				to.click(); 
				break;
			}
		}
		
		driver.findElement(By.xpath("//p[text()='29']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		//

		// WebElement element=driver.findElement(By.xpath("//p[@class='LatoBold
		// intlFlt-heading append_bottom3']"));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).ignoring(org.openqa.selenium.NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				WebElement element = driver
						.findElement(By.xpath("//p[@class='LatoBold intlFlt-heading append_bottom3']"));
				System.out.println(element.getText());
				return element;

			}

		});

	}
	
}
