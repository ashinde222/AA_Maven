package Pom_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kiteHomePage {

@FindBy(xpath="//span[@class='user-id']") private WebElement verID;
@FindBy(xpath="//a[@target='_self']")private WebElement logout;
@FindBy(xpath="//span[text()='Kulkarni']")private WebElement useName;	

	public kiteHomePage(WebDriver kite)
	{
		PageFactory.initElements(kite, this);
	}
	
	public String Verify_UserID()
	{
		String actID = verID.getText();
		
		return actID;
	}
	public String Verify_UsernameOFHomepage()
	{
		String actualName = useName.getText();
		return actualName;
	}
	
	public void clickon_homepage_myprofile()
	{
		verID.click();
	}
	public void clicon_homepage_logout()
	{
		logout.click();
	}
	
	
}		
