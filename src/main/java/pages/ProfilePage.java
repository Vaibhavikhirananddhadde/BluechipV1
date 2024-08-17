package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import util.UtilClass;

public class ProfilePage extends BaseClass{
	//Address of twitterlink
	@FindBy(xpath="//a[@class='twitter']")
	private WebElement icon_twitter;
	
	//Address of facebook link
	@FindBy(xpath="//a[@class='facebook']")
	private WebElement icon_facebook;
	
	//Address of instagram
	@FindBy(xpath="//a[@class='instagram']")
	private WebElement icon_instagram;
	
	//Address of linked in link
	@FindBy(xpath="//a[@class='linkedin']")
	private WebElement icon_linkedin;
	
	//Address of password in overview for validation it should not display in overview
	@FindBy(xpath="//div[text()='Password']")
	private WebElement passwordDetail;
	
	//Address of footer
	@FindBy(xpath="//footer[@id='footer']")
	private WebElement footer;
	
	//Address of overview button
	@FindBy(xpath="//button[contains(text(),'Edit Profile')]")
	private WebElement overviewBtn;
	
	//Address of upload picture
	@FindBy(xpath="//i[@class='bi bi-upload']")
	private WebElement uploadPic;
	
	//Address of delete picture
	@FindBy(xpath="//i[@class='bi bi-trash']")
	private WebElement deletePic;
	
	//Address of edit picture
	@FindBy(xpath="//a[@onclick='changeProfilePhoto()']")
	private WebElement editPic;
	
	//Address of Name textfield
	@FindBy(xpath="//input[@name='agentname']")
	private WebElement nameTf;
	
	//Address of phone number textfield
	@FindBy(xpath="//input[@name='phoneno']")
	private WebElement phoneTf;
	
	//Address of email textfield
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTf;
	
	//Address of password textfield
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTf;
	
	//Address of company name textfield
	@FindBy(xpath="//input[@name='comp_name']")
	private WebElement companyNameTf;
	
	//Address of gst number textfield
	@FindBy(xpath="//input[@name='gst_no']")
	private WebElement gst;
	
	//Address of Adharcard
	@FindBy(xpath="//input[@name='aadhar_card']")
	private WebElement adhar;
	
	//Address of PAN card
	@FindBy(xpath="//input[@name='pan_card']")
	private WebElement PAN;
	
	//Address of passport copy
	@FindBy(xpath="//input[@name='pass_copy']")
	private WebElement passport;
	
	//Address of submit button
	@FindBy(xpath="//button[contains(text(),'Save')]")
	private WebElement submitBtn;
	
	//Profile headline for validation
	@FindBy(xpath="//h1[normalize-space()='Profile']")
	private WebElement headline_Profile;
	
	//Address of edit profile
	@FindBy(xpath="//button[normalize-space()='Edit Profile']")
	private WebElement link_EditProfile;
	
	

	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void twitterClick()
	{
		icon_twitter.click();
	}
	
	public void facebookClick()
	{
		icon_facebook.click();
	}
	
	public void instagramClick()
	{
		icon_instagram.click();
	}
	
	public void linkedinClick()
	{
		icon_linkedin.click();
	}
	
	public void OverviewClick()
	{
		overviewBtn.click();
	}
	
	public void deleteClick()
	{
		deletePic.click();
	}
	
	public void editProfile(String name, String phone, String email, String password, String companyName, String gstNumber, String adharPath, String panPath, String passportPath)
	{
		nameTf.clear();
		nameTf.sendKeys(name);
		UtilClass.waitImplicit();
		phoneTf.clear();
		phoneTf.sendKeys(phone);
		UtilClass.waitImplicit();
		emailTf.clear();
		emailTf.sendKeys(email);
		UtilClass.waitImplicit();
		passwordTf.clear();
		passwordTf.sendKeys(password);
		UtilClass.waitImplicit();
		companyNameTf.clear();
		companyNameTf.sendKeys(companyName);
		UtilClass.waitImplicit();
		gst.clear();
		gst.sendKeys(gstNumber);
		UtilClass.waitImplicit();
		adhar.clear();
		adhar.sendKeys(adharPath);
		UtilClass.waitImplicit();
		PAN.clear();
		PAN.sendKeys(panPath);
		UtilClass.waitImplicit();
		passport.clear();
		passport.sendKeys(passportPath);
		UtilClass.waitImplicit();
		submitBtn.click();
	}
	
	public WebElement getHeadline_Profile() {
		return headline_Profile;
	}

	public WebElement getPasswordDetail() {
		return passwordDetail;
	}

	public void clickOnEditProfile()
	{
		link_EditProfile.click();
	}

}
