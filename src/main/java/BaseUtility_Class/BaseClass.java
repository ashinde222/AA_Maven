package BaseUtility_Class;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	
	public WebDriver driver;
	
	
	public void Initialize_Browser() throws IOException
	{
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\eclipse-workspace\\AA_Maven\\Browser\\chromedriver.exe");
	driver = new ChromeDriver(options);
	driver.get(Utility.readPropertyFiledata("URL"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
}
