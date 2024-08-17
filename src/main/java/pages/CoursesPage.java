package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import util.UtilClass;

public class CoursesPage extends BaseClass{
	//Address of Add button
	@FindBy(xpath="//button[@id='detialshowcourses']")
	private WebElement Add_btn;
	
	//Address of entries dropdown
	@FindBy(xpath="//select[@class='datatable-selector']")
	private WebElement entries_dd;;
	
	//Address of search
	@FindBy(xpath="//input[@placeholder='Search...']")
	private WebElement search_txt;
	
	//Courses headline for validation
	@FindBy(xpath="//h1[normalize-space()='Courses list']")
	private WebElement headline_Courses;
	
	public WebElement getHeadline_Courses() {
		return headline_Courses;
	}

	
	public CoursesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addClick()
	{
		Add_btn.click();
	}
	
	public void entriesDd(String visibletext)
	{
		UtilClass.selectFromDropDown(entries_dd, visibletext);
	
	}
	
	public void search(String text)
	{
		search_txt.sendKeys(text);
	}
	
	

}
