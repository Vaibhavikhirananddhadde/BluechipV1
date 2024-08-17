package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LandingPage extends BaseClass{
	//Address of Register button
	@FindBy(id = "login-button1")
	public WebElement registerBtn;
	
	//Address of Login button
	@FindBy(id = "login-button")
	public WebElement loginBtn;
	
	
	
	public LandingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void registerClick()
	{
		registerBtn.click();
	}
	
	public void loginClick()
	{
		loginBtn.click();
	}

}
