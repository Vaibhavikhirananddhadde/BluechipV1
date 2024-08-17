package com.bluechip_Agent;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.ContactPage;
import pages.CoursesPage;
import pages.DashboardPage;
import pages.DealsPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.ReportPage;
import pages.StudentListPage;
import util.UtilClass;

public class Dashboard_TC extends BaseClass {

	// Enter text in search field and click on search button check whether search
	// process is initiated.
	@Test(enabled = false)
	public void searchFieldFunctionality_TC001() throws Throwable {
		LandingPage land = new LandingPage(driver);
		land.loginClick();
		LoginPage login = new LoginPage(driver);
		login.loginFunctionality(readProperty("username"), readProperty("password"));
		DashboardPage dash = new DashboardPage(driver);
		UtilClass.waitImplicit();
		dash.search("abcd");
		UtilClass.waitImplicit();
		dash.clickOnSearchBtn();
		String ExpectedURL = "https://bluechipservicesinternational.org/BLUECHIP/agent/index.jsp#";
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL, "URL does not match");

	}

	// Navigate to the page and check for page title.
	@Test(enabled = false)
	public void pageTitleVerification_TC002() throws Exception, Throwable {

		LandingPage land = new LandingPage(driver);
		land.loginClick();
		LoginPage login = new LoginPage(driver);
		login.loginFunctionality(readProperty("username"), readProperty("password"));
		UtilClass.waitImplicit();
		String ExpectedTitle = "Agent Dashboard";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Title does not match");

	}

	// Click on logout button and check message is displayed
	@Test(enabled = false)
	public void logoutFunctionality_TC003() throws Exception, Throwable {
		LandingPage land = new LandingPage(driver);
		land.loginClick();
		LoginPage login = new LoginPage(driver);
		login.loginFunctionality(readProperty("username"), readProperty("password"));
		UtilClass.waitImplicit();
		DashboardPage dp = new DashboardPage(driver);
		dp.logoutClick();
		UtilClass.checkAlertpresent();
	}

	// Click on each side menu and check whether respective page is displayed.
	@Test(enabled = true)
	public void sideMenuBar() throws Exception, Throwable {
		LandingPage land = new LandingPage(driver);
		land.loginClick();
		LoginPage login = new LoginPage(driver);
		login.loginFunctionality(readProperty("username"), readProperty("password"));
		UtilClass.waitImplicit();

		DashboardPage dash = new DashboardPage(driver);
		dash.clickOnDashboard();
		UtilClass.waitImplicit();
		Assert.assertTrue(dash.getHeadline_Dashboard().isDisplayed(), "Respective page is not displayed");

		ProfilePage profile = new ProfilePage(driver);
		dash.clickOnProfile();
		UtilClass.waitImplicit();
		Assert.assertTrue(profile.getHeadline_Profile().isDisplayed(), "Respective page is not displayed");

		DealsPage deals = new DealsPage(driver);
		dash.clickOnDeals();
		UtilClass.waitImplicit();
		Assert.assertTrue(deals.getHeadline_Deals().isDisplayed(), "Respective page is not displayed");

		StudentListPage student = new StudentListPage(driver);
		dash.clickOnStudentList();
		UtilClass.waitImplicit();
		Assert.assertTrue(student.getHeadline_StudentList().isDisplayed(), "Respective page is not displayed");

		CoursesPage course = new CoursesPage(driver);
		dash.clickOnCourses();
		UtilClass.waitImplicit();
		Assert.assertTrue(course.getHeadline_Courses().isDisplayed(), "Respective page is not displayed");

		ContactPage contact = new ContactPage(driver);
		dash.clickOnContact();
		UtilClass.waitImplicit();
		Assert.assertTrue(contact.getHeadline_Contact().isDisplayed(), "Respective page is not displayed");

		ReportPage report = new ReportPage(driver);
		dash.clickOnReport();
		UtilClass.waitImplicit();
		Assert.assertTrue(report.getHeadline_Report().isDisplayed(), "Respective page is not displayed");

	}
	

}
