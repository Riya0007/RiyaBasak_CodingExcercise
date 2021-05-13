
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
public class ProductDescriptionPage extends BaseTest {
	
	public ProductDescriptionPage(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'See All Buying Options')]")
	public MobileElement btn_buyingOption;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Back')]")
	public MobileElement btn_back;
	
	public String itemIdentifier(String product) {
		return "//android.widget.TextView[contains(@text,'"+product+"')]";
		}
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Add to Cart')]//preceding-sibling::android.view.View")
	public MobileElement lbl_price;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Add to Cart')]")
	public MobileElement btn_addToCart;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'action_bar_cart_image')]")
	public MobileElement cartIcon;
	
	
	  /**
		 * @author Riya Basak
		 * @MathodName clickBuyingOptions()
		 * @function "This method will verify present of buying option and click on buying options"
		 */
		  public void clickBuyingOptions() {
			
			try {
				PageUtils.waitForVisible(btn_buyingOption, 15);
				PageUtils.click(btn_buyingOption);
				}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			}	
		  
		  /**
			 * @author Riya Basak
			 * @MathodName clickOnAddToCart()
			 * @function "This method will add item to cart"
			 */
			  public void clickOnAddToCart() {
				
				try {
					PageUtils.waitForVisible(btn_back, 10);
					PageUtils.click(btn_addToCart);
					}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				}	
			  
			  /**
				 * @author Riya Basak
				 * @MathodName verifyProductDescription(String itemName)
				 * @function "This method will verify product price and name on description page"
				 */
				  public void verifyProductDescription(String itemName) {
					
					try {
						PageUtils.waitForVisible(PageUtils.getElement(By.xpath(itemName)), 15);
						String priceObtained = lbl_price.getText();
						String priceFixed=prop.getProperty("Price");
						PageUtils.compareStrings(priceObtained,priceFixed);
						}
					catch(Exception e) 
					{
						e.printStackTrace();
					}
					}	
				  
				  /**
					 * @author Riya Basak
					 * @MathodName clickBuyingOptions()
					 * @function "This method will click on back button"
					 */
					  public void clickBackButton() {
						
						try {
							PageUtils.click(btn_back);
							}
						catch(Exception e) 
						{
							e.printStackTrace();
						}
						}	
					  
					  /**
						 * @author Riya Basak
						 * @MathodName clickCartIcon()
						 * @function "This method will click on cart icon"
						 */
						  public void clickCartIcon() {
							
							try {
								PageUtils.click(cartIcon);
								}
							catch(Exception e) 
							{
								e.printStackTrace();
							}
							}	
					  
}


