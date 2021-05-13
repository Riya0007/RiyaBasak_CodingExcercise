/**
 * 
 */
package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class PageUtils extends BaseTest {
	/**
	 * @author Riya Basak
	 * @MathodName click(MobileElement mobileElement)
	 * @function "This method will click on supplied mobileElement"
	 */
	public static boolean click(MobileElement mobileElement) {
		boolean status = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
			mobileElement.click();
			status = true;
			}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return status;
		}
	
	/**
	 * @author Riya Basak
	 * @MathodName sendKeys(MobileElement mobileElement,String text)
	 * @function "This method will types supplied text on passed mobileElement"
	 */
	
	public static boolean sendKeys(MobileElement mobileElement,String text) {
		boolean status = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
			mobileElement.clear();
			mobileElement.sendKeys(text);
			status = true;
			}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return status;
		}
	
	/**
	 * @author Riya Basak
	 * @MathodName waitForVisible(MobileElement mobileElement,int timeOut)
	 * @function "This method will verify whether item is present on the screen or not"
	 */
	
	public static boolean waitForVisible(MobileElement mobileElement,int timeOut) {
		boolean status = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
			status = mobileElement.isDisplayed();
			}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return status;
		}
	/**
	 * @author Riya Basak
	 * @MathodName scrollIntoView(String text)
	 * @function "This method will scroll until text is found"
	 */
	
	public static void scrollIntoView(String text) {
		
		try {
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
			}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		}
	
	/**
	 * @author Riya Basak
	 * @MathodName getElement(By by)
	 * @function "This method will return by element"
	 */
	
	@SuppressWarnings("finally")
	public static MobileElement getElement(By by) {
		MobileElement mobileElement =null ;
		try {
			mobileElement = driver.findElement(by);
			}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally {
			return mobileElement;
		}
		
		}
	
	/**
	 * @author Riya Basak
	 * @MathodName compareStrings(String source, String destination)
	 * @function "This method will compare two strings"
	 */
	
	public static void compareStrings(String source, String destination) {
		  
		try {
			Assert.assertEquals(source, destination);
			}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	
		
		}
}
