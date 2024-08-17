package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class ContactPage extends BaseClass{
	//Address of name textfield
	@FindBy(xpath="//input[@placeholder='Your Name']")
	private WebElement name_txt;
	
	//Address of email textfield
	@FindBy(xpath="//input[@placeholder='Your Email']")
	private WebElement email_txt;
	
	//Address of subject
	@FindBy(xpath="//input[@placeholder='Subject']")
	private WebElement subject_txt;
	
	//Address of Message textfield
	@FindBy(xpath="//textarea[@placeholder='Message']")
	private WebElement message_txt;
	
	//Address of submit button
	@FindBy(xpath="//input[@name='send message']")
	private WebElement submit_btn;
	
	//Contact headline for validation
	@FindBy(xpath="//h1[normalize-space()='Contact']")
	private WebElement headline_Contact;
	
	public WebElement getHeadline_Contact() {
		return headline_Contact;
	}

	

	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterName(String name)
	{
		name_txt.sendKeys(name);
	}
	
	public void enterEmail(String email)
	{
		email_txt.sendKeys(email);
	}
	
	public void enterSubject(String subject)
	{
		subject_txt.sendKeys(subject);
	}
	
	public void enterMessage(String message)
	{
		message_txt.sendKeys(message);
	}

}
