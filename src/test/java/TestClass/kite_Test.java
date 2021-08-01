package TestClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtility_Class.BaseClass;
import BaseUtility_Class.Utility;
import Pom_Class.kiteHomePage;
import Pom_Class.kiteLogin1_page1;
import Pom_Class.kiteLogin1_page2;

public class kite_Test extends BaseClass
{
	int TCID;
	kiteLogin1_page1 login1;
	kiteLogin1_page2 login2;
	kiteHomePage home;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeClass
	public void Open_Browser() throws EncryptedDocumentException, IOException
	{	
		extent = new ExtentReports("D:\\My Data\\Desktop\\velocity\\Report.html", true);
		
		Initialize_Browser();
		login1 = new kiteLogin1_page1(driver);
		login2 = new kiteLogin1_page2(driver);
		home = new kiteHomePage(driver);
		login1.inpkiteloginPage1_Enter_UserID(Utility.readPropertyFiledata("UN"));
		
	}
	@BeforeMethod
	public void Login_Application() throws InterruptedException, EncryptedDocumentException, IOException
	{
		login1.inpkiteloginPage1_Enter_password(Utility.readPropertyFiledata("PWD"));
		login1.kiteloginpage1_ClickOnlGnBTN();
		Thread.sleep(2000);
		login2.inpKiteLoginPage2_Verify_pin(Utility.readPropertyFiledata("PIN"));
		login2.Click_btn();			
	}
	@Test
	public void TC1_Verify_UserID()
	{
		 TCID=100;
		 String actID = home.Verify_UserID();
		 String ExpID = "DV1510"; 
		 Assert.assertEquals(actID, ExpID);
		 logger=extent.startTest("test start");
		 logger.log(LogStatus.PASS, "Verify UserID is passed!");
		 		 
		 Reporter.log("verify user id ", true);
	}
	
	@Test
	public void TC2_Verify_UsernameofHomepage()
	{
		
		String actual = home.Verify_UsernameOFHomepage();
		String expected = "Kulkarni";
		Assert.assertEquals(actual, expected);
		 logger=extent.startTest("test start");
		 logger.log(LogStatus.PASS, "Verify UserID is passed!");
		
		 Reporter.log("tc pass", true);
	}
	@Test
	public void TC3_W()
	{
		String actual = home.Verify_UsernameOFHomepage();
		String expected = "Kulkarni";
		Assert.assertEquals(actual, expected);
		logger=extent.startTest("test start");
		logger.log(LogStatus.PASS, "Verify UserID is Failed !");

		Reporter.log("Sample tc fail ", true);
	}
	@Test
	public void TC4_W()
	{
		Assert.fail();
		
		logger.log(LogStatus.FAIL, "Verify UserID is Failed !");

		Reporter.log("Sample tc fail ", true);
	}
	@AfterMethod
	public void LogOut_Application() throws InterruptedException
	{

		Thread.sleep(2000);
		home.clickon_homepage_myprofile();
		home.clicon_homepage_logout();	

		extent.endTest(logger);
		Reporter.log("Log Out the Application", true);
	}
	@AfterClass
	public void Close_Browser() throws InterruptedException
	{
		
		extent.flush();
		driver.quit();
		Reporter.log("closing the browser", true);
	}
	

}
