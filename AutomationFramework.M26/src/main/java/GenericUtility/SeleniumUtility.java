package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of the gerenic methods which are related to Selenium tool
 * @author Vidya
 */

public class SeleniumUtility {
	
	/**
	 * This method is used for maximizing the window
	 * @param driver
	 * @return 
	 */
	public SeleniumUtility maximizeWindow(WebDriver driver) {		
		driver.manage().window().maximize();
		return this;
	}
	
	
	/**
	 * This method is used for minimizing the window
	 * @param driver
	 * @return 
	 */
	public SeleniumUtility minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
		return this;
	}
	
	
	/**
	 * This method is used for adding the implicit wait within the test script
	 * @param driver
	 * @param seconds
	 */
	public void addImplicitlyWait(WebDriver driver,int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	
	/**
	 * This explicit wait will wait for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This explicit wait will wait for the element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will select the drop down value via index
	 * @param day
	 * @param date
	 */
	public void handleDropdown(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will select the drop down value via value
	 * @param value
	 * @param element
	 */
	public void handleDropdown(String value, WebElement element) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will select the drop down value via visible text 
	 * @param element
	 * @param visibleText
	 */
	public void handleDropdown(WebElement element,String visibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will click on the web element 
	 * @param driver
	 * @param element
	 */
	public void clickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).build().perform();
	}
	
	/**
	 * This method will double click on the web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	
	/**
	 * This method will mouse over on the particular element
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will right click on the particular element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element);
	}
	
	/**
	 * This method will click on hold on the element
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element);
	}
	
	/**
	 * This method will drag and drop the element from source to the target location
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target);
	}
	
	/**
	 * This method will scroll the page to the particular webelement
	 * @param driver
	 * @param element
	 */
	public void scrollPage(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element);
	}
	
	/**
	 * This method is used to switch to the particular frame.
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method is used to switch to frame using the frame index
	 * @param driver
	 * @param frameId
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will help to switch frame using ID or Name
	 * @param driver
	 * @param IDorName
	 */
	public void switchToFrame(WebDriver driver,String IDorName) {
		driver.switchTo().frame(IDorName);
	}
	
	/**
	 * This method will help to switch the control back to immediate parent frame
	 * @param driver
	 */
	public void switchToParent(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will help to switch the control back to main page ignoring all parent
	 * @param driver
	 */
	public void switchToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to switch to window
	 * @param driver
	 * @param windowHandle
	 */
	public void switchToWindow(WebDriver driver, String windowHandle) {
		driver.switchTo().window(windowHandle);
	}
	
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert pop up
	 * @param driver
	 */
	public void disMissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get the text on the alert pop up
	 * @param driver
	 */
	public void getAlertText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will enter the data into alert pop up
	 * @param driver
	 * @param alertData
	 */
	public void enterAlertData(WebDriver driver, String alertData) {
		driver.switchTo().alert().sendKeys(alertData);
	}
	
	/*This method is used to scroll down by 500
	 * @param driver*
	 * 
	 */
	public void scrollDown(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Windows.ScrollBy(0,500)","");
	}
	
	/**
	 * This method is used to scroll up by 500
	 * @param driver
	 */
	public void scrollUp(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Windows.ScrollBy(0,-500)","");
	}
	
	/**
	 * This method is used to scroll right by 500
	 * @param driver
	 */
	public void scrollRight(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Windows.ScrollBy(500,0)","");
	}
	
	/**This method is used to scroll left by 500
	 * @param driver
	 */
	public void scrollLeft(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Windows.ScrollBy(-500,0)","");
	}
	
	/**
	 * This method will capture the screenshot and return path to caller
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/"+screenshotName+".png");//tsname_date_time
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath();// for extent reports
		
	}
	
}
