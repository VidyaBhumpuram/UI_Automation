package inventoryTests;

import java.io.IOException;
import java.net.http.WebSocket.Listener;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.CartPage;
import ObjectRepository.InventaryItemPage;
import ObjectRepository.InventoryPage;

@Listeners(GenericUtility.ListernersImplementation.class)
public class AddLowestProductToCartTest extends BaseClass {
	
	@Test(groups = "Regression")
	public void addLowestPriceProductTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		// Read Test Data From Excel File
		String SORTOPTION = fUtil.readTestDataFromExcelFile("Sheet1", 4, 2);
		String PRODUCTNAME = fUtil.readTestDataFromExcelFile("Sheet1", 4, 3);

		// Step 4: Click on a Product
		InventoryPage ip = new InventoryPage(driver);
		String pAddedToCart = ip.clickOnLowestPricedProduct(driver, PRODUCTNAME, SORTOPTION);
		
		// Step 5: Add the Product To Cart
		InventaryItemPage iip = new InventaryItemPage(driver);
		iip.getAddToCartBtn();

		//Assert.assertFalse(true);//just to fail test case
		
		// Step 6: Navigate to Cart
		ip.clickOnCartContainer();
		
		//Assert.assertFalse(true);//just to fail the test case.

		// Step 7: Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String pInCart = cp.getProductNameInCart();

		Assert.assertEquals(pInCart, pAddedToCart);

		System.out.println(pInCart);
	}

	@Test(groups = "Regression",retryAnalyzer = GenericUtility.RetryAnalyserImplementation.class)
	public void sample() {
		
		//Assert.fail();
		System.out.println("Hi");
	}
}
