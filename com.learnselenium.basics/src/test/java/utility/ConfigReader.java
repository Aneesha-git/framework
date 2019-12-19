/**
 * 
 */
package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author renia this class is to read
 *
 **/
public class ConfigReader {
		Properties p;
	public  ConfigReader() {
		try {
			File src = new File("./config/config.properties");
			FileInputStream fis = new FileInputStream(src);
			 p = new Properties();
			p.load(fis);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public String getChromePath() {
		return p.getProperty("CHROMEPATH");
		}
	
	public String getURL() {
		return p.getProperty("URL");
		}
}
