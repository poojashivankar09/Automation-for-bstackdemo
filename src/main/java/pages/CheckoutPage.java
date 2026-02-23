package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	WebDriver driver;

	By firstName = By.id("firstNameInput");
	By lastName = By.id("lastNameInput");
	By address = By.id("addressLine1Input");
	By state = By.id("provinceInput");
	By postalCode = By.id("postCodeInput");
	By submitBtn = By.id("checkout-shipping-continue");

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void fillDetailsAndSubmit() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

		driver.findElement(firstName).sendKeys("Pooja");
		driver.findElement(lastName).sendKeys("Shivankar");
		driver.findElement(address).sendKeys("Phase1");
		driver.findElement(state).sendKeys("Maharashtra");
		driver.findElement(postalCode).sendKeys("411057");
		driver.findElement(submitBtn).click();
	}
}
