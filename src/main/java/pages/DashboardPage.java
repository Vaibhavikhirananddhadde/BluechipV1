package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class DashboardPage extends BaseClass {
	// Address of search field
	@FindBy(xpath = "//input[@title='Enter search keyword']")
	private WebElement searchfield;

	// Address of logout button
	@FindBy(xpath = "//a[text()='logout']")
	private WebElement logout_btn;

	// Address of search button
	@FindBy(xpath = "(//i[@class='bi bi-search'])[1]")
	private WebElement btn_search;

	// Address of Dashboard
	@FindBy(xpath = "//ul[@class='sidebar-nav']//li/a/i/following-sibling::span[text()='Dashboard']")
	private WebElement link_Dashboard;
	
	//Address of Profile 
	@FindBy(xpath="//ul[@class='sidebar-nav']//li/a/i/following-sibling::span[text()='Profile']")
	private WebElement link_Profile;
	
	//Address of Deals
	@FindBy(xpath="//ul[@class='sidebar-nav']//li/a/i/following-sibling::span[text()='Deals']")
	private WebElement link_Deals;
	
	//Address of Student list
	@FindBy(xpath="//ul[@class='sidebar-nav']//li/a/i/following-sibling::span[text()='Student List']")
	private WebElement link_StudentList;
	
	//Address of courses
	@FindBy(xpath="//ul[@class='sidebar-nav']//li/a/i/following-sibling::span[text()='Courses ']")
	private WebElement link_courses;
	
	//Address of contact
	@FindBy(xpath="//ul[@class='sidebar-nav']//li/a/i/following-sibling::span[text()='Contact']")
	private WebElement link_contact;
	
	//Address of Report
	@FindBy(xpath="//ul[@class='sidebar-nav']//li/a/i/following-sibling::span[text()='Report']")
	private WebElement link_Report;
	
	//Dashboard headline for validation purpose
	@FindBy(xpath="//h1[normalize-space()='Dashboard']")
	private WebElement headline_Dashboard;

	public DashboardPage(WebDriver diver) {
		PageFactory.initElements(driver, this);
	}

	public void search(String text) {
		searchfield.sendKeys(text);
	}

	public void logoutClick() {
		logout_btn.click();
	}

	public void clickOnSearchBtn() {
		btn_search.click();
	}
	
	public void clickOnDashboard() {
		link_Dashboard.click();
	}
	
	public void clickOnProfile() {
		link_Profile.click();
	}
	
	public void clickOnDeals() {
		link_Deals.click();
	}
	
	public void clickOnStudentList() {
		link_StudentList.click();
	}
	
	public void clickOnCourses() {
		link_courses.click();
	}
	
	public void clickOnContact() {
		link_contact.click();
	}
	
	public void clickOnReport() {
		link_Report.click();
	}
	
	public WebElement getHeadline_Dashboard() {
		return headline_Dashboard;
	}

	

}
