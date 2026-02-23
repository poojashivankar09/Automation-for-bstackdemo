package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.testng.Assert;

public class LoginTest extends BaseTest {

    @Test
    public void TC_001_validLogin() {

        test = extent.createTest("TC_001 - Valid Login");

        LoginPage login = new LoginPage(driver);

        test.info("Clicking Sign In");
        login.clickSignIn();

        test.info("Entering valid credentials");
        login.login("demouser", "testingisfun99");
        
        System.out.println("Valid User Logged in Successfully") ;

        test.pass("Valid login executed successfully");
       
        
        }

    @Test
    public void TC_002_invalidUserLogin() {

        test = extent.createTest("TC_002 - Invalid Login");

        LoginPage login = new LoginPage(driver);

        test.info("Clicking Sign In");
        login.clickSignIn();

        test.info("Entering invalid credentials");
        login.login("wrong_user", "wrong_password");
        
        System.out.println("Invalid User Logged in Successfully") ;

        test.pass("Invalid login test executed");
        
        
    }

    @Test
    public void TC_003_clickLoginButtonOnly() {

        test = extent.createTest("TC_003 - Empty Login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        test.info("Clicking Sign In");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("signin"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-btn")));

        test.info("Clicking login button without entering credentials");
        driver.findElement(By.id("login-btn")).click();

        // Wait for error message
        By errorMsg = By.cssSelector(".api-error");   // verify locator once using inspect
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));

        String actualMessage = driver.findElement(errorMsg).getText();

        System.out.println("Error Message: " + actualMessage);
        test.info("Error Message Displayed: " + actualMessage);

        Assert.assertEquals(actualMessage, "Invalid Username");

        test.pass("Empty login test executed successfully");
    }}
