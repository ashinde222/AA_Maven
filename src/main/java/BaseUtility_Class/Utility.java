package BaseUtility_Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {


	//Author name: Ajay shinde
	//This method is use get inputs from excel sheet
	//need to pass 2 parameters ie. 1. rowIndex, 2. colIndex
	
	public static String getTestData(int rowIndex , int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\acer\\eclipse-workspace\\AA_Maven\\TestData\\Testdata.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}
	
	public static String readPropertyFiledata(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\acer\\eclipse-workspace\\AA_Maven\\src\\main\\java\\BaseUtility_Class\\properties.properties"); 
		prop.load(file);
		String value = prop.getProperty(key);
		
		return value;
	}	
		
		public static void Capturescrrenshot(WebDriver driver , int TCID) throws IOException
		{
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\acer\\eclipse-workspace\\AA_Maven\\Screenshot\\testcaseID"+TCID+".jpg");
			FileHandler.copy(source, dest);
			
			
			
		}
	
	
	
}
