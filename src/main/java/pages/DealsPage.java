package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import util.UtilClass;

public class DealsPage extends BaseClass{
	//Address of search field at the top
	@FindBy(xpath="title=\"Enter search keyword\"")
	private WebElement search_txt_top;
	
	//Address of Add button
	@FindBy(xpath="//button[@id='Request__deals']")
	private WebElement add_btn;
	
	//Address of entries dropdown
	@FindBy(xpath="//select[@class='datatable-selector']")
	private WebElement entries_dd;
	
	//Address of search
	@FindBy(xpath="//input[@title='Search within table']")
	private WebElement search_txt;
	
	//Address of footer
	@FindBy(xpath="//footer[@id='footer']")
	private WebElement footer;
	
	//deals headline for validation
	@FindBy(xpath="//h1[normalize-space()='Deals']")
	private WebElement headline_Deals;
	
	

	public DealsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchingFunctionality(String text)
	{
		search_txt_top.sendKeys(text);
	}
	
	public void addClick()
	{
		add_btn.click();
	}
	
	public void dropdown(String visible_txt)
	{
		UtilClass.selectFromDropDown(entries_dd, visible_txt);
	}
	
	public void search(String text)
	{
		search_txt.sendKeys(text);
	}
	
	public WebElement getHeadline_Deals() {
		return headline_Deals;
	}

	

}
