/**
 * 
 */
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.log4testng.Logger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author Riya Basak
 * @classDescriptiom "This is the base class, which will invoke driver with different capabilities"
 *
 */
public class BaseTest {
	
	
	 public static AndroidDriver<AndroidElement>  driver;
	 public static Properties prop;
			 
	/**
	 * @author Riya Basak
	 * @MethodName invokeDriver
	 * @Description "This method will invoke Android driver and return driver to calling method "
	 * @date 11/05/2021 
	 */
	public static AndroidDriver<AndroidElement> invokeDriver() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalSettings.properties");
		 prop =new Properties();
		prop.load(fis);
		File appPath=new File(new File("src"),prop.getProperty("AppName"));
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.UDID, prop.getProperty("UDID"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PlatformName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION ,prop.getProperty("PlatformVersion"));
		driver = new AndroidDriver<>(new URL(prop.getProperty("AppiumServerURL")),cap);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

}
