package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import util.UtilClass;

public class BaseClass extends UtilClass{
	
	public UtilClass util=new UtilClass();
	@BeforeMethod
	public void start() throws Exception {
		
		launchBrowser(readProperty("browser"));
		waitImplicit();
		getApplication(readProperty("url1"));
	}
	
	
	@DataProvider(name = "registrationData")
	public Object[][] getRegistrationData() throws Exception {
	    return dataReader("Register"); // Replace "Sheet1" with your actual sheet name
	}
	

	@AfterMethod
	public void close() throws Exception {
    driver.quit();
	}

}
