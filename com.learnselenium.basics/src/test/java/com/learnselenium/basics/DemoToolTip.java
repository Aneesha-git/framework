package com.learnselenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoToolTip {
	
	@Test
	public void demo() {
	
	WebDriver driver=new ChromeDriver();
	 
	// This will maximize your browser

	 
	// Open gmail account creation page
	 driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
		driver.manage().window().maximize();
	 // Click on username textbox
	driver.findElement(By.xpath(".//*[@id='GmailAddress']")).click();


}}
