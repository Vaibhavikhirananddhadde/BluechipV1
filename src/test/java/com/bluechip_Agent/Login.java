/*1.Test various clickable elements such as buttons, links, icons, etc., throughout the login page.
2.Verify logo is displayed.
3.Login functionality with valid email and password, invalid email and valid password, invalid email and invalid password, valid email and invalid password.








*/

package com.bluechip_Agent;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LandingPage;
import pages.LoginPage;
import util.UtilClass;

public class Login extends BaseClass {

	@Test(priority = 1)
	public void verifyLogo() throws InterruptedException {
		LoginPage login=new LoginPage(driver);
		Assert.assertTrue(login.isLogoDisplayed(), "Logo is not displayed on the login page.");
	}

	@Test(dataProvider = "registrationData", priority = 2)
	public void login(String email, String password) throws Throwable {
	LandingPage land=new LandingPage(driver);
		LoginPage login=new LoginPage(driver);
		UtilClass.waitImplicit();
		land.loginBtn.click();
		login.loginFunctionality(email, password);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Agent Dashboard";
		if (ActualTitle.equals(ExpectedTitle)) {
			Assert.assertEquals(ActualTitle, ExpectedTitle);
			System.out.println("Actual title is equal to expected result i.e Agent Dashboard");
		} else {
			String ActualError=login.getEmailPasswordNotMatchingMessage();
			String expectedError = "Incorrect email or password!";
			Assert.assertEquals(ActualError, expectedError, "Error message does not match");
			System.out.println(expectedError);
		}

		

	}

	@Test(priority = 3)
	public void forgetPasswordLinkFunctionality() {
		UtilClass.waitImplicit();
		LandingPage land=new LandingPage(driver);
		land.loginBtn.click();
		LoginPage login=new LoginPage(driver);
		login.forgotpassword();
		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://bluechipservicesinternational.org/BLUECHIP/forget.jsp";

		Assert.assertEquals(ActualUrl, ExpectedUrl, "Link is functional");
	}

	@Test(priority = 4)
	public void createAccountLinkFunctionality() {
		UtilClass.waitImplicit();
		LandingPage land=new LandingPage(driver);
		LoginPage login=new LoginPage(driver);
		land.loginBtn.click();
		login.createaccount();

		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://bluechipservicesinternational.org/BLUECHIP/register.html";

		Assert.assertEquals(ActualUrl, ExpectedUrl, "Link is functional");

	}

}
