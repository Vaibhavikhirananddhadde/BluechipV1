package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import util.UtilClass;

public class RegisterPage extends BaseClass{
	//Name textfield
	@FindBy(xpath = "//input[@name='agentname']")
	private WebElement nameTf;
	
	//phone number textfield
	@FindBy(xpath="(//input[@name='phoneno'])[2]")
	private WebElement phoneTf;
	
	//Email textfield
	@FindBy(xpath="(//input[@name='email'])[2]")
	private WebElement emailTf;
	
	//Password textfield
	@FindBy(xpath="(//input[@name='password'])[2]")
	private WebElement passwordTf;
	
	//company name textfield
	@FindBy(xpath="(//input[@name='comp_name'])[1]")
	private WebElement companyNameTf;
	
	//GST number textfield
	@FindBy(xpath="(//input[@name='gst_no'])[1]")
	private WebElement GSTtf;
	
	//Upload adharcard
	@FindBy(xpath="//input[@name='aadhar_card']")
	private WebElement adharcard;
	
	//Upload PAN card
	@FindBy(xpath="//input[@name='pan_card']")
	private WebElement Pancard;
	
	//Upload Passportcopy
	@FindBy(xpath="//input[@name='pass_copy']")
	private WebElement Passportcopy;
	
	//Submit button
	@FindBy(xpath="(//input[@value='Submit'])[1]")
	private WebElement Submit;
	
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void registration(String name, String phoneno, String email, String password, String company, String GST, String adharcardPath, String PANcard, String Passport) throws Throwable
	{
		nameTf.clear();
		nameTf.sendKeys(name);
		Thread.sleep(3000);
		
		phoneTf.clear();
		phoneTf.sendKeys(phoneno);
		Thread.sleep(3000);
		
		emailTf.clear();
		emailTf.sendKeys(email);
		Thread.sleep(3000);
		
		passwordTf.clear();
		passwordTf.sendKeys(password);
		Thread.sleep(3000);
		
		companyNameTf.clear();
		companyNameTf.sendKeys(company);
		Thread.sleep(3000);
		
		GSTtf.clear();
		GSTtf.sendKeys(GST);
		Thread.sleep(3000);
		

		
		 // Upload files if paths are provided
	    if (adharcardPath != null && !adharcardPath.isEmpty()) {
	    	adharcard.sendKeys(adharcardPath.replace("\\", "\\\\"));
	    	Thread.sleep(3000);
	    }
	    if (PANcard != null && !PANcard.isEmpty()) {
	    	Pancard.sendKeys(PANcard.replace("\\", "\\\\"));
	    	Thread.sleep(3000);
	    }
	    if (Passport != null && !Passport.isEmpty()) {
	    	Passportcopy.sendKeys(Passport.replace("\\", "\\\\"));
	    	Thread.sleep(3000);
	    }

	    // Click on submit button
	   UtilClass.scrolltoview(Submit);
	   Thread.sleep(3000);
	   Submit.click();
	}
	
	
//	public void submitClick()
//	{
//		Submit.click();
//	}
	
//	public void adharcardClick()
//	{
//		adharcard.click();
//	}
//	 
	
	

}
