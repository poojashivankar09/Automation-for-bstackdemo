package pages;

import org.openqa.selenium.*;

public class CartPage {

	WebDriver driver;

	By checkoutBtn = By.className("buy-btn");

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCheckout() {
		driver.findElement(checkoutBtn).click();
	}
}
