package com.learnselenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
	WebDriver driver;
	@Test(dataProvider="getData")
	public void login(String userName,String pwd) {
	
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
	//driver = new ChromeDriver();
	
	System.out.print("userName : " + userName);
	System.out.print("    	");
	System.out.println("password: "+pwd);
	System.out.println();
	}

	@DataProvider(name="getData")
	public Object[][] getData(){
		Object[][] data=new Object[2][2];
		
		data[0][0]="username0";
		data[0][1]="password0";
		data[1][0]="username1";
		data[1][1]="password1";
		return data;
	}
}
