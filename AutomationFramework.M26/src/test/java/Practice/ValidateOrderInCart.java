package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateOrderInCart {

	public static void main(String[] args) throws InterruptedException {
		

		//load the application
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Log into the application
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//select the product and add to cart
		WebElement product = driver.findElement(By.xpath("//div[.='Sauce Labs Bolt T-Shirt']"));
		String productAdded = product.getText();
		product.click();
			
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		String ItemInCart = driver.findElement(By.id("item_1_title_link")).getText();
		
		if(productAdded.equals(ItemInCart))
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		
		//logout of application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.close();

	}

	
}
