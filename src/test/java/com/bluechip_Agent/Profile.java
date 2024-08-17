package com.bluechip_Agent;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import util.UtilClass;

public class Profile extends BaseClass{
	//Navigate to profile page check for page title
	@Test(enabled = false)
	public void pageTitle_TC001() throws Exception, Throwable
	{
		LandingPage land=new LandingPage(driver);
		land.loginClick();
		LoginPage login= new LoginPage(driver);
		login.loginFunctionality(readProperty("username"),readProperty("password"));
		UtilClass.waitImplicit();
		DashboardPage dash=new DashboardPage(driver);
		dash.clickOnProfile();
		String ExpectedTitle="Profile";
		String ActualTitle=driver.getTitle();
		UtilClass.waitImplicit();
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Title does not match");
	}
	
	//Click on each social media link and check whether each link is redirecting to respective page.
	@Test(enabled = false)
	public void socialMediaLinks() throws Exception, Throwable {
		LandingPage land=new LandingPage(driver);
		land.loginClick();
		LoginPage login= new LoginPage(driver);
		login.loginFunctionality(readProperty("username"),readProperty("password"));
		UtilClass.waitImplicit();
		
		DashboardPage dash=new DashboardPage(driver);
		dash.clickOnProfile();
		
		ProfilePage profile=new ProfilePage(driver);
		profile.twitterClick();
		UtilClass.waitImplicit();
		String expectedURL1="https://x.com/?lang=en-in";
		String actualURL1=driver.getCurrentUrl();
		Assert.assertEquals(actualURL1, expectedURL1, "twitter page is not displayed");
		
		profile.facebookClick();
		UtilClass.waitImplicit();
		String expectedURL2="https://www.facebook.com/";
		String actualURL2=driver.getCurrentUrl();
		Assert.assertEquals(actualURL2, expectedURL2, "facebook page is not displayed");
		
		profile.instagramClick();
		UtilClass.waitImplicit();
		String expectedURL3="https://www.instagram.com/accounts/login/";
		String actualURL3=driver.getCurrentUrl();
		Assert.assertEquals(expectedURL3, actualURL3, "Instagram page is not displayed");
		
		profile.linkedinClick();
		UtilClass.waitImplicit();
		String expectedURL4="https://www.linkedin.com/feed/";
		String actualURL4=driver.getCurrentUrl();
		Assert.assertEquals(expectedURL4, actualURL4, "Linkedin page is not displayed");
		
		
	}
	
	//verify  profile editing functionality
	@Test(dataProvider = "registrationData")
	public void EditDetails(String AgentName, String phone, String email, String password, String companyName, String gstNumber, String adharPath, String panPath, String passportPath) throws Throwable {
	    LandingPage land = new LandingPage(driver);
	    land.loginClick();
	    LoginPage login = new LoginPage(driver);
	    login.loginFunctionality(readProperty("username"), readProperty("password"));
	    UtilClass.waitImplicit();

	    DashboardPage dash = new DashboardPage(driver);
	    dash.clickOnProfile();

	    ProfilePage profile = new ProfilePage(driver);
	    profile.clickOnEditProfile();
	    profile.editProfile(AgentName, phone, email, password, companyName, gstNumber, adharPath, panPath, passportPath);
	}
}
