/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.BaseTest;
import utilities.PageUtils;

/**
 * @author Riya Basak
 * @classDescriptiom "Home Page related methods are present."
 *
 */
public class CheckOutPage extends BaseTest {
	
	public CheckOutPage(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Proceed to checkout')]")
	public MobileElement btn_proceedToCheckOut;
	
	
	public String itemIdentifier(String product) {
		return "//android.widget.TextView[contains(@text,'"+product+"')]";
		}
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Subtotal')]//following-sibling::android.widget.TextView")
	public MobileElement lbl_subtotal;
	
	
	/**
	 * @author Riya Basak
	 * @MathodName verifyCheckOutButton()
	 * @function "This method will verify presence of checkout button"
	 */
	  public void verifyCheckOutButton() {
		
		try {
			PageUtils.waitForVisible(btn_proceedToCheckOut, 15);
			}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		}	
	  
	  /**
		 * @author Riya Basak
		 * @MathodName verifyCheckOutSection(String itemName)
		 * @function "This method will verify product price and name on checkout page"
		 */
		  public void verifyCheckOutSection(String itemName) {
			
			try {
				PageUtils.waitForVisible(PageUtils.getElement(By.xpath(itemName)), 15);
				String priceObtained = lbl_subtotal.getText();
				String priceFixed=prop.getProperty("Price");
				PageUtils.compareStrings(priceObtained,priceFixed);
				}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			}	

}
