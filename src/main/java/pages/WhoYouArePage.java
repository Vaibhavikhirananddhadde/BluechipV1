package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class WhoYouArePage extends BaseClass{
	//address of Agent
	@FindBy(xpath="(//div[@class='card-body'])[2]")
	private WebElement agentBtn;
	
	public WhoYouArePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void agentClick()
	{
		agentBtn.click();
	}

}
