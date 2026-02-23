package pages;

import org.openqa.selenium.*;

public class ProductPage {

	WebDriver driver;

	By firstProduct = By.xpath("(//div[@class='shelf-item'])[1]");
	By addToCartBtn = By.xpath("(//div[@class='shelf-item'])[1]//button");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addFirstProductToCart() {
		driver.findElement(addToCartBtn).click();
	}
}
