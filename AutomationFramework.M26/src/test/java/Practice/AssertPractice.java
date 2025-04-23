package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {

	@Test
	public void hardAssert() {
		
		SoftAssert as = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(0, 1);
		System.out.println("Step 4");
		
		Assert.assertTrue(false);
		System.out.println("Step 5");
	}
	
	@Test
	public void softAssert() {
		
		SoftAssert as = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		as.assertEquals(0, 1);
		System.out.println("Step 4");
		
		as.assertTrue(false);
		System.out.println("Step 5");
		as.assertAll();
	}
}
