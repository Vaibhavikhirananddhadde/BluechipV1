package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import util.UtilClass;

public class LoginPage extends BaseClass{
	//Address of Email textfield
	@FindBy(xpath = "//input[@id='Username']")
	private WebElement emailTf;
	
	//Address of password
	@FindBy(id = "password")
	private WebElement passwordTf;
	
	//Address of forgot password link
	@FindBy(xpath = "//a[text()='Forgot password?']")
	private WebElement forgotPassword;
	
	//Address of login button
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;
	
	//Address of created account link
	@FindBy(xpath = "//a[@class='text-primary fw-bold']")
	private WebElement createAccountLink;
	
	//Address of logo
	@FindBy(xpath="//span[text()='International Pvt.Ltd']")
	private WebElement Logo;
	
	//Address of show password
	@FindBy(id = "togglePassword")
	private WebElement viewPasswordToggle;
	
	//Address of error message
	@FindBy(xpath="//div[normalize-space()='Incorrect email or password!']")
	private WebElement emailPasswordNotMatching;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginFunctionality(String email, String password) throws Throwable
	{
		emailTf.clear();
		emailTf.sendKeys(email);
		Thread.sleep(3000);
		passwordTf.clear();
		passwordTf.sendKeys(password);
		Thread.sleep(3000);
		
	    loginBtn.click();
	}
	
	public void forgotpassword()
	{
		forgotPassword.click();
	}
	
	public void createaccount()
	{
		UtilClass.scrolltoview(createAccountLink);
		UtilClass.waitExplicit(createAccountLink);
		createAccountLink.click();
	}
	
	

	 public boolean isLogoDisplayed() {
	        return Logo.isDisplayed();
	    }
	 
	 public String getEmailPasswordNotMatchingMessage()
	 {
		 String errorMessage = emailPasswordNotMatching.getText();
		 return errorMessage;
	 }
	 
	

}
