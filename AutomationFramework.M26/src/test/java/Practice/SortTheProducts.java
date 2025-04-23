package Practice;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.SeleniumUtility;
import ObjectRepository.InventoryPage;

public class SortTheProducts extends BaseClass {

	@Test
	public static void sortProducts() throws EncryptedDocumentException, IOException {
		//Create the objects for the general utility files
			SeleniumUtility su = new SeleniumUtility();
			FileUtility fu = new FileUtility();
			JavaUtility ju = new JavaUtility();
				
		//Input data reading from file
			String PRODUCTNAME = fu.readTestDataFromExcelFile("sheet1",1,2);
			String URL = fu.readDataFromPropertyFile("url");
			String USERNAME = fu.readDataFromPropertyFile("username");
			String PASSWORD = fu.readDataFromPropertyFile("password");
				
		//load the application
			WebDriver driver = new ChromeDriver();
			su.maximizeWindow(driver).addImplicitlyWait(driver, 20);
				
		//Log into the application
			driver.get(URL);
			driver.findElement(By.id("user-name")).sendKeys(USERNAME);
			driver.findElement(By.id("password")).sendKeys(PASSWORD);
			driver.findElement(By.id("login-button")).click();
		
		//Click on sort and select - Price (low to high)
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).sendKeys("Price (low to high)");
		

	}
	
	
	
	
	
	
	
	
	
	
	//using data provider
	
	@DataProvider(name = "sortProduct")
    public Object[][] getUserData() {
        return new Object[][]{
        	{"Price (low to high)"},
            {"Name (A to Z)"},
            {"Price (high to low)"},
            {"Name (Z to A)"}
            
        };
    }
	
	@Test (dataProvider = "sortProduct")
	public void sortProduct(String sort) {

	//Click on sort and select - Price (low to high)
	//driver.findElement(By.xpath("//select[@class='product_sort_container']")).sendKeys(sort);
		InventoryPage ip = new InventoryPage(driver);
		ip.sortWithDataProvider(driver, sort);
		System.out.println("Sorted with value : "+ sort);
	
	}

}








