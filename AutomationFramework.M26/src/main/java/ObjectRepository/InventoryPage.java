package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.SeleniumUtility;

public class InventoryPage extends SeleniumUtility {
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuOption;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartContainer;
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement sortDropDown;
	
	
	//constructor to initialize
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Provide Getters to access the web elements
	public WebElement getMenuOption() {
		return menuOption;
	}


	public WebElement getLogoutLink() {
		return logoutLink;
	}


	public WebElement getCartContainer() {
		return cartContainer;
	}


	public WebElement getSortDropDown() {
		return sortDropDown;
	}
	
	//Business logic - Generic methods
	
	/**
	 * This method will logout of the application
	 */
	public void logoutOfApplication() {
		menuOption.click();
		logoutLink.click();		
	}
	
	/**
	 * This method is used to click on the selected product and returns the product details
	 * @param driver
	 * @param PRODUCTNAME
	 * @return 
	 */
	public String clickOnProduct(WebDriver driver, String PRODUCTNAME) {
		WebElement ele = driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']"));
		String productName = ele.getText();
		ele.click();
		
		return productName;
	}
	
	/**
	 *  This method is used to sort and click on the lowest selected product and returns the product details
	 * @param driver
	 * @param productName
	 * @param sortOption
	 * @return
	 * @throws InterruptedException 
	 */
	public String clickOnLowestPricedProduct(WebDriver driver, String PRODUCTNAME, String sortOption) throws InterruptedException {
		handleDropdown(sortDropDown, sortOption);
		WebElement ele = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));
		WebElement ele1 = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']/../../..//button[text()='Add to cart']"));
		String productName = ele.getText();
		Thread.sleep(2000);
		ele1.click();
		
		return productName;
	}
	
	/**
	 * This method is used to click on the Cart container 
	 */
	public void clickOnCartContainer() {
		cartContainer.click();
	}
	
	///These are trial methods written for practice not part of framework
	public void sortWithDataProvider(WebDriver driver,String sortOption) {
		
		//handleDropdown(sortDropDown, sortOption);
		((WebElement) driver.findElement((By) sortDropDown)).sendKeys(sortOption);
		
	}
}
