package inventoryTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.SeleniumUtility;
import ObjectRepository.CartPage;
import ObjectRepository.InventaryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

@Listeners(GenericUtility.ListernersImplementation.class)
public class AddProductToCartTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void tc_001_AddProductToCartTest() throws EncryptedDocumentException, IOException {
	
		// Read Test Data From Excel File
			String PRODUCTNAME = fUtil.readTestDataFromExcelFile("Sheet1", 1, 2);

		// Step 4: Click on a Product
			InventoryPage ip = new InventoryPage(driver);
			String pAddedToCart = ip.clickOnProduct(driver, PRODUCTNAME);

		// Step 5: Add the Product To Cart
			InventaryItemPage iip = new InventaryItemPage(driver);
			iip.addProductToCart();

		// Step 6: Navigate to Cart
			ip.clickOnCartContainer();

		// Step 7: Validate the product in Cart
			 CartPage cp = new CartPage(driver);
			 String pInCart = cp.getProductNameInCart();
				
			 Assert.assertEquals(pInCart,pAddedToCart );
			 Assert.assertTrue(pInCart.equals(pAddedToCart));
			 
//				if (pInCart.equals(pAddedToCart)) {
//					System.out.println("PASS");
//					System.out.println(pInCart);
//				} else {
//					System.out.println("FAIL");
//				}
		
	}
	
}
 