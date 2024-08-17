package com.bluechip_Agent;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegisterPage;
import pages.WhoYouArePage;
import util.UtilClass;

public class Register extends BaseClass{
	
	@Test(dataProvider = "registrationData")
	public void Registration(String AgentName, String phone, String email, String password, String companyName, String gstNumber, String adharPath, String panPath, String passportPath) throws Throwable {


	    LandingPage land = new LandingPage(driver);
	    land.registerClick();

	    WhoYouArePage who=new WhoYouArePage(driver);
	    who.agentClick();
	    
	    RegisterPage reg=new RegisterPage(driver);
	    reg.registration(AgentName, phone, email, password, companyName, gstNumber, adharPath, panPath, passportPath);
	    
	    String actualTitle=driver.getTitle();
	    String expectedTitle="Bluechip | Pursuing Education Abroad";
	    Assert.assertEquals(actualTitle, expectedTitle, "Title does not match not registered");
	}


}
