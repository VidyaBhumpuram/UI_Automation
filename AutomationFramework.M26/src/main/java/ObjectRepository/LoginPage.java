package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {// rule 1 : The POM class name should end with Page so this class name is :LoginPage
	
	//Declaration
	//Rule 2 : Identify all web elements using annotation.
	@FindBy(id = "user-name")
	private WebElement usernameEdt;
	
	//Auto healing process - If first locator is not able to identify the web element
	//automatically then @FindAll will shift to another locator to identify the web element.
	@FindAll({@FindBy(name = "password"),@FindBy(id="password")})
	private WebElement passwordEdt;//Identify single web element using OR operation
	
	/*
	 * @FindBys({@FindBy(name = "password"),@FindBy(id="password")})
	private WebElement passwordEdt;//Identify single web element using AND operation. So both will be used to find element
	 */
	
	@FindBy(className = "submit-button")
	private WebElement loginBtn;
	
	
	//Rule 3 : initialize web elements using constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4: Provide Getters to access the web elements
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * This method will perform login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	//Business Library - Generic methods - related to Application
	public void loginToApp(String USERNAME, String PASSWORD) {
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

}
