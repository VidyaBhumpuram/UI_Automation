package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

/**
 * This class consists of the basic configuration annotations of TestNG
 */
public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public JavaUtility jutil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	//For listeners
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		
		System.out.println("---- Database connection successfull ----");
	}
	
	//@Parameters("Browser") 
	//@BeforeTest (alwaysRun = true)//this is used for parallel execution
	
	@BeforeClass(alwaysRun = true)
	//public void bcConfig(String pvalue) throws IOException {//this is for parallel execution
		public void bcConfig() throws IOException {
		
		String URL = fUtil.readDataFromPropertyFile("url");
		
		driver = new ChromeDriver();// this is used for normal execution
		//For cross browser execution - this is known as  run time polymorphism
//		
//		if(pvalue.equals("firefox")) {
//			driver = new FirefoxDriver();
//		}
//		else if(pvalue.equals("chrome")) {
//			driver = new ChromeDriver();
//		}
//		else {
//			driver = new ChromeDriver();
//		}
			
		sUtil.maximizeWindow(driver).addImplicitlyWait(driver, 10);
		
		driver.get(URL);
		System.out.println("---- Browser Lanunched Successfully ----");
		
		//For Listeners
		sdriver=driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("---- Login to App Successfully ----");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() {
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApplication();
		
		System.out.println("---- Logged out of Application Successfully ----");
	}
	
	@AfterTest (alwaysRun = true) // this is used for parallel execution
	//@AfterClass(alwaysRun = true)
	public void acConfig() {
		
		driver.quit();
		System.out.println("---- Browser Closed Successfully ----");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		
		System.out.println("---- Database Closure Successfull ----");
	}
	
}
