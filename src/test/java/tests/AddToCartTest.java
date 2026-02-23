package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartTest extends BaseTest {

    @Test
    public void TC_004_addToCart() {

        test = extent.createTest("TC_004 - Add Single Product To Cart");

        LoginPage login = new LoginPage(driver);
        login.clickSignIn();
        login.login("demouser", "testingisfun99");

        test.info("Login successful");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".shelf-item")));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".shelf-item__buy-btn"))).click();

        test.pass("Product added successfully");
        System.out.println("Product is added to Cart Successfully");
    }

    @Test
    public void TC_005_addMultipleItemsToCart() {

        test = extent.createTest("TC_005 - Add Multiple Products To Cart");

        LoginPage login = new LoginPage(driver);
        login.clickSignIn();
        login.login("demouser", "testingisfun99");

        test.info("Login successful");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".shelf-item")));

        List<WebElement> addButtons = driver.findElements(
                By.cssSelector(".shelf-item__buy-btn"));

        for (int i = 0; i < 3; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(addButtons.get(i))).click();
        }

        WebElement cartBadge = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("bag__quantity")));

        String cartCount = cartBadge.getText();

        Assert.assertEquals(cartCount, "3");

        test.pass("Multiple products added successfully and verified");
        System.out.println("Multiple products are added to Cart Successfully") ;
    }

    @Test
    public void TC_006_removeItemFromCart() {

        test = extent.createTest("TC_006 - Remove Item From Cart");

        LoginPage login = new LoginPage(driver);
        login.clickSignIn();
        login.login("demouser", "testingisfun99");

        test.info("Login successful");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".shelf-item")));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".shelf-item__buy-btn"))).click();

        test.info("Product added");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".shelf-item__del"))).click();

        test.info("Product removed");

        WebElement cartBadge = driver.findElement(By.className("bag__quantity"));
        String cartCount = cartBadge.getText();

        Assert.assertEquals(cartCount, "0");

        test.pass("Cart is empty - Remove test passed");
        
        System.out.println("Added product removed from cart Successfully") ;
    }
}

