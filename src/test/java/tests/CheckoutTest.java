package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
//import com.aventstack.extentreports.*;
import utils.ExtentReportManager;

//import com.aventstack.extentreports.util.Assert;

import pages.*;

public class CheckoutTest extends BaseTest {


	@Test
	public void TC_007_placeOrderWithValidDetails() {

		test = extent.createTest("TC_007 - Place Order With Valid Details");

		try {

			LoginPage login = new LoginPage(driver);
			login.clickSignIn();
			login.login("demouser", "testingisfun99");
			test.info("Login successful");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Add product
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shelf-item")));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shelf-item__buy-btn"))).click();
			test.info("Product added to cart");

			// Click Checkout button
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".buy-btn"))).click();
			test.info("Checkout button clicked");

			// Fill checkout details
			CheckoutPage checkout = new CheckoutPage(driver);
			checkout.fillDetailsAndSubmit();
			test.info("Checkout details submitted");

			// ✅ Validate success message
			WebElement successMessage = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'successfully')]")));

			Assert.assertTrue(successMessage.isDisplayed());

			test.pass("Order placed successfully and verified");
			System.out.println("Checkout details submitted successfully");

		} catch (Exception e) {

			test.fail("Test Failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	public void TC_008_checkoutWithoutItemsTest() {

		test = extent.createTest("TC_008 - Checkout Without Items");

		try {

			driver.findElement(By.xpath("//span[@class='bag bag--float-cart-closed']")).click();
			test.info("Clicked cart icon");

			WebElement emptyMessage = driver.findElement(By.xpath("//p[@class='shelf-empty']"));

			Assert.assertTrue(emptyMessage.isDisplayed());

			test.pass("Empty cart message displayed. Add some products in the bag. Checkout not allowed.");
			System.out.println("") ;

		} catch (Exception e) {

			test.fail("Test Failed: " + e.getMessage());
			throw e;
		}
		
		
	}

	
}
