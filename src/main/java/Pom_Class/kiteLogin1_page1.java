package Pom_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kiteLogin1_page1 {

	@FindBy(xpath="//input[@id='userid']")private WebElement UN;
	@FindBy(xpath="//input[@id='password']")private WebElement PWD;
	@FindBy(xpath="//button[@type='submit']")private WebElement LGNBTN;
	
	
	public kiteLogin1_page1(WebDriver page1)
	{
		PageFactory.initElements(page1, this);
	}
	
	public void inpkiteloginPage1_Enter_UserID(String username)
	{
		UN.sendKeys(username);
	}
	
	public void inpkiteloginPage1_Enter_password(String password)
	{
		PWD.sendKeys(password);
	}
	public void kiteloginpage1_ClickOnlGnBTN()
	{
		LGNBTN.click();
	}
	
	
	
	
}
