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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.SeleniumUtility;
import ObjectRepository.LoginPage;

public class AddProductToCart_UsingDataFromGU {
	
	static String confirmationmsg = "Thank you for your order!";

	@Test
	public static void AddProductToCart() throws IOException, InterruptedException {
		
		//Create objects of all required utilities
		FileUtility fu = new FileUtility();
		SeleniumUtility su = new SeleniumUtility();
		JavaUtility ju = new JavaUtility();
		
		//Read common data from Property file
		 String URL = fu.readDataFromPropertyFile("url");
		 String USERNAME = fu.readDataFromPropertyFile("username");
		 String PASSWORD = fu.readDataFromPropertyFile("password");
		
		//Read test data from Xls
		String PRODUCTNAME = fu.readTestDataFromExcelFile("sheet1", 1, 2);
		
		//Launch the application
		WebDriver driver = new ChromeDriver();
		su.maximizeWindow(driver);
		su.addImplicitlyWait(driver, 20);
				
		//load the application
		driver.get(URL);
		
		//Log into the application
		
		/*driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();*/
		
		//using POM class
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);//Business logic
		
		/*lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);	
		lp.getLoginBtn().click();*/
		
		
		//select the product and add to cart
		
		driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']")).click();
				
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
			
		// Take screenshot of the product in cart
		String screenshotName = "TC_001"+ju.getSystemDateInFormet();
		String path = su.captureScreenShot(driver, screenshotName);
		System.out.println(path);
		
		//Order placement and confirmation validation
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.id("first-name")).sendKeys("vidya");
		driver.findElement(By.id("last-name")).sendKeys("vidya");
		driver.findElement(By.id("postal-code")).sendKeys("560099");
				
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//button[text()='Finish']")).click();
		String msg = driver.findElement(By.xpath("//h2[.='Thank you for your order!']")).getText();
			
			if(msg.equals(confirmationmsg))
				System.out.println("Order places scccueesfully");
			else 
				System.out.println("Error is order placement");	
					
		//logout of application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.close();

}


}
