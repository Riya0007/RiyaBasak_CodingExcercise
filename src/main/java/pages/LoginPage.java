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
public class LoginPage extends BaseTest {
	
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'sign_in_button')]")
	public MobileElement btn_signin;
	
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'ap_email_login')]")
	public MobileElement emailField;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'continue')]")
	public MobileElement btn_continue;
	
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'ap_password')]")
	public MobileElement passwordField;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'signInSubmit')]")
	public MobileElement btn_submit;
	
	public String searchByText(String text) {
		return "//android.widget.TextView[contains(@text,'"+text+"')]";
		}
	
	
	/**
	 * @author Riya Basak
	 * @MathodName clickOnSignIn
	 * @function "This method will sign in  button"
	 */
	  public void clickOnSignIn() {
		
		try {
			PageUtils.click(btn_signin);
			}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		}
	  
	  /**
		 * @author Riya Basak
		 * @MathodName logIn(String UserName,String Password)
		 * @function "This method will verify user login with valid email and password"
		 */
		  public void logIn(String UserName,String Password) {
			
			try {
				PageUtils.sendKeys(emailField,UserName);
				PageUtils.click(btn_continue);
				PageUtils.sendKeys(passwordField,Password);
				PageUtils.click(btn_submit);
				}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			}	
}
