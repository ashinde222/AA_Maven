package Pom_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kiteLogin1_page2 {
		
		@FindBy(xpath="//input[@type='password']") private WebElement Vpin;
		@FindBy(xpath="//button[@class='button-orange wide']") private WebElement CntBtn; 
			
			
			public kiteLogin1_page2(WebDriver page2)
			{
				PageFactory.initElements(page2, this);
			}
			
			public void inpKiteLoginPage2_Verify_pin(String pin)
			{
				Vpin.sendKeys(pin);
			}
			public void Click_btn()
			{
				CntBtn.click();
			}

			
	
			
}