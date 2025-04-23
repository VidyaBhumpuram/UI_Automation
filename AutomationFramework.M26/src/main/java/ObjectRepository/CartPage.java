package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(xpath ="//button[text()='Remove']")
	private WebElement removeBtn;
	
	@FindBy(id="checkout")
	private WebElement checkoutBtn;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	private WebElement productName;
	
	@FindBy(id="continue-shopping")
	private WebElement continueShoppingBtn;
	

	//constructor to initialize
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Getters to access web elements
	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public WebElement getProductName() {
		return productName;
	}
	
	public WebElement getContinueShoppingBtn() {
		return continueShoppingBtn;
	}
	
	//Business logic - generic methods
	
	/**
	 * This method will navigate user to checkout page
	 */
	public void clickOnCheckoutBtn() {
		checkoutBtn.click();
	}
	
	/**
	 * This method will navigate user back to Inventory page
	 */
	public void clickOnContinueShoppingBtn() {
		continueShoppingBtn.click();
	}
	
	/**
	 * This method will fetch the Product name and return to user
	 * @return
	 */
	public String getProductNameInCart() {
		return productName.getText();
	}
	
	
}
