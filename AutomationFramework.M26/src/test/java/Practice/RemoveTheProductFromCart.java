package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.SeleniumUtility;

public class RemoveTheProductFromCart {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
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
		
		//select the product and add to cart
		WebElement product = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String productAdded = product.getText();
		product.click();
			
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.xpath("//button[.='Remove']")).click();
		
		System.out.println("Deleted from cart");
		
		//logout of application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.close();

	}

}
