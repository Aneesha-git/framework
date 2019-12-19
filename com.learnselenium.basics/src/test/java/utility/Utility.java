package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static String getScreenShot1(WebDriver driver, String scName) throws Exception {
		String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
	
		String destination=System.getProperty("user.dir") +"/Screenshots/"+scName+date+".png";
		File finalDestination=new File(destination);
		
		FileUtils.copyFile(source, finalDestination);
		
		System.out.println("sc taken");
		return destination;
		
	}
	
}