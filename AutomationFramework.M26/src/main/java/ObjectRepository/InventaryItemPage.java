package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventaryItemPage {
	
	@FindBy(id = "back-to-products")
	private WebElement backToProducts;
	
	@FindBy(id="add-to-cart")
	private WebElement addToCartBtn;
	
	@FindBy(xpath ="//div[@class='inventory_details_price']")
	private WebElement productPrice;
	
	@FindBy(xpath ="//a[@class='shopping_cart_link']")
	private WebElement cartContainer;
	
	@FindBy(id="remove")
	private WebElement removeBtn;
	


	//Constructor to initialize
	public InventaryItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Provide getters to access the web elements
	public WebElement getBackToProducts() {
		return backToProducts;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getCartContainer() {
		return cartContainer;
	}
	
	public WebElement getRemoveBtn() {
		return removeBtn;
	}
	
	//Business logic - generic methods
	
	/**
	 * This method will add product to the cart
	 */
	public void addProductToCart() {
		addToCartBtn.click();
	}
	
	/**
	 * This method will remove product already added to cart from Inventory list page
	 */
	public void removeProduct() {
		removeBtn.click();
	}
	
	/**
	 * This method will navigate user back to Inventory page
	 */
	public void navigateBackToInventoryPage() {
		backToProducts.click();
	}
}
