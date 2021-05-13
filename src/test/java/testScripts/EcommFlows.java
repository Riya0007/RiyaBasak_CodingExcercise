package testScripts;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDescriptionPage;
import utilities.BaseTest;

/**
 * @author RiyaBasak
 * @createdon 12/05/2021
 *
 */
public class EcommFlows {
	
	public LoginPage lp;
	public HomePage hp;
	public ProductDescriptionPage pd;
	public CheckOutPage cp;
	AndroidDriver<AndroidElement>driver;
	
	 Logger log =Logger.getLogger(EcommFlows.class);
	@BeforeMethod
	public void setUp() throws IOException {
		
		 driver = BaseTest.invokeDriver();
		 lp= new LoginPage(driver);
		 hp = new HomePage(driver);
		 pd = new ProductDescriptionPage(driver);
		 cp = new CheckOutPage(driver);
		 
	}
	
	/**Test Case :Login ,search and navigate to checkout page
	 * @author Riya Basak
	 * @MathodName amazonFlow()
	 * @CreatedOn 12/05/2021
	 */
	@Test
	public void amazonFlow() {
		lp.clickOnSignIn();
		log.info("User clicked on sign in button on launch screen");
		lp.logIn(BaseTest.prop.getProperty("UserName"), BaseTest.prop.getProperty("Password"));
		log.info("Sign In is successful");
		hp.clickOnSearch();
		log.info("User clicked on search field");
		hp.searchForProduct(BaseTest.prop.getProperty("SearchWith"), BaseTest.prop.getProperty("ItemFromList"), BaseTest.prop.getProperty("ItemFromSuggestedList"));
		log.info("User searched for a particular item");
		pd.clickBuyingOptions();
		log.info("User clicked on buying options");
		pd.verifyProductDescription(BaseTest.prop.getProperty("ItemFromSuggestedList"));
		log.info("Product name and price are verified on product description screen");
		pd.clickOnAddToCart();
		log.info("User clicked on add to cart button");
		pd.clickBackButton();
		log.info("User clicked on back button");
		pd.clickCartIcon();
		log.info("User clicked on cart icon");
		cp.verifyCheckOutButton();
		log.info("Proceed to checkout button is verified");
		cp.verifyCheckOutSection(BaseTest.prop.getProperty("ItemFromSuggestedList"));
		log.info("Product name and price are verified on checkout screen");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
