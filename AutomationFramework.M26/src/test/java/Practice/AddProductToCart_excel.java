package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.SeleniumUtility;

public class AddProductToCart_excel {

	public static void main(String[] args) throws IOException {
		
		//Create object for the utility classes
		FileUtility fu = new FileUtility();
		SeleniumUtility su = new SeleniumUtility();
		JavaUtility ju = new JavaUtility();
		
		//Read Common Data from Property file
		 String URL = fu.readDataFromPropertyFile("url");
		 String USERNAME = fu.readDataFromPropertyFile("username");
		 String PASSWORD = fu.readDataFromPropertyFile("password");
						
		//Read Test Data From Excel File
		 String PRODUCTNAME = fu.readTestDataFromExcelFile("sheet1", 1, 2);	
				
		// Step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		su.maximizeWindow(driver).addImplicitlyWait(driver, 10);

		// Step 2: Load the Application
		driver.get(URL);

		// Step 3: login To Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();

		// Step 4: Click on a Product 
		WebElement productEle = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String pAddedToCart = productEle.getText();
		productEle.click();

		// Step 5: Add the Product To Cart
		driver.findElement(By.id("add-to-cart")).click();

		// Step 6: Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();

		// Step 7: Validate the product in Cart
		String pInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (pInCart.equals(pAddedToCart)) {
				System.out.println("PASS");
				System.out.println(pInCart);
		} else {
				System.out.println("FAIL");
				}

		// Step 8: Logout of App
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		}

}
