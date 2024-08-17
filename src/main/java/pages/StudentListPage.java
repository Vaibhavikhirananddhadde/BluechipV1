package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import util.UtilClass;

public class StudentListPage extends BaseClass{
	//Address of Add button
	@FindBy(id="detialshow")
	private WebElement Add_btn;
	
	//Address of search
	@FindBy(xpath="(//input[@placeholder='Search...'])[1]")
	private WebElement search_txt;
	
	//Address of view button
	@FindBy(xpath="//button[@id='showwdetails_view1']")
	private WebElement view_btn;
	
	//Address of header profile link
	@FindBy(xpath="//a[@class='nav-link nav-profile d-flex align-items-center pe-0']")
	private WebElement profile_header;
	
	//Address of entries dropdown
	@FindBy(xpath="//select[@class='datatable-selector']")
	private WebElement entries_dd;
	
	//StudentList headline for validation
		@FindBy(xpath="//h1[normalize-space()='Student List']")
		private WebElement headline_StudentList;
		
	
	public WebElement getHeadline_StudentList() {
			return headline_StudentList;
		}


	public StudentListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addClick()
	{
		Add_btn.click();
	}
	
	public void search(String text)
	{
		search_txt.sendKeys(text);
	}
	
	public void viewClick()
	{
		view_btn.click();
	}
	
	public void entriesDropdown(String Visibletext)
	{
		UtilClass.selectFromDropDown(entries_dd, Visibletext);
	}
	
	
}
