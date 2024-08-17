package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class ReportPage extends BaseClass{
	//Address of Add button
	@FindBy(id="form_std_report")
	private WebElement Add_btn;
	
	//Address of Export button
	@FindBy(xpath="//b[normalize-space()='Export']")
	private WebElement export_btn;
	
	//Report headline for validation
	@FindBy(xpath="//h1[normalize-space()='Report']")
	private WebElement headline_Report;
	
	public WebElement getHeadline_Report() {
		return headline_Report;
	}

	public ReportPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addClick()
	{
		Add_btn.click();
	}
	
	public void exportClick()
	{
		export_btn.click();
	}

}
