package Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.FileUtility;
import GenericUtility.SeleniumUtility;

public class ProductOrder_Successful {
	
	static String confirmationmsg = "Thank you for your order!";
	@Test
	public static void ProductOrderingSuccessfull() throws InterruptedException, IOException {
		
		//load the application
		WebDriver driver = new ChromeDriver();
	    SeleniumUtility su = new SeleniumUtility();
	    su.maximizeWindow(driver).addImplicitlyWait(driver, 20);
		
		//Log into the application
	    FileUtility fu = new FileUtility();
	    String URL = fu.readDataFromPropertyFile("url");
	    String USERNAME = fu.readDataFromPropertyFile("username");
	    String PASSWORD = fu.readDataFromPropertyFile("password");
	    
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
			
		//select the product and add to cart
		String PRODUCTNAME = fu.readTestDataFromExcelFile("sheet1", 1, 2);
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		//Order placement and confirmation validation
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.id("first-name")).sendKeys("Vidya");
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