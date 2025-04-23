package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepOnePage {

	@FindBy(id="first-name")
	private WebElement firstName;
	
	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(id="postal-code")
	private WebElement postalCode;
	
	@FindBy(id="cancel")
	private WebElement cancelBtn;
	
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	//constructor to initialize
	public CheckOutStepOnePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Getters to access the web elements
	
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	
	//Business logic - generic methods
	
	public void addCheckOutDetails(String fName,String lName,String zipCode) {
		firstName.sendKeys("fName");
		lastName.sendKeys("lName");
		postalCode.sendKeys("zipCode");
	}
	
}
