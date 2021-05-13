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
public class HomePage extends BaseTest {
	
	public HomePage(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'search_src_text')]")
	public MobileElement Search;
	
	public String searchByText(String text) {
		return "//android.widget.TextView[contains(@text,'"+text+"')]";
		}
	
	
	/**
	 * @author Riya Basak
	 * @MathodName clickOnSearch
	 * @function "This method will click on search button"
	 */
	  public void clickOnSearch() {
		
		try {
			PageUtils.waitForVisible(Search, 15);
			PageUtils.click(Search);
			}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		}
	  
	  /**
		 * @author Riya Basak
		 * @MathodName searchForProduct(String itemName,String itemFromList,String itemFromSuggestedList)
		 * @function "This method will search a product and navigate to product buying option page"
		 */
		  public void searchForProduct(String itemName,String itemFromList,String itemFromSuggestedList) {
			
			try {
				PageUtils.sendKeys(Search,itemName);
				PageUtils.click(driver.findElement(By.xpath(searchByText(itemFromList))));
				PageUtils.click(driver.findElement(By.xpath(searchByText(itemFromSuggestedList))));
				}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			}	
}
