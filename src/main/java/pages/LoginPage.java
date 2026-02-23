package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void login(String username, String password) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Username
		WebElement user = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@id,'react-select')])[1]")));
		user.sendKeys(username + Keys.ENTER);

		// Password
		WebElement pass = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@id,'react-select')])[2]")));
		pass.sendKeys(password + Keys.ENTER);

		// Login button
		driver.findElement(By.id("login-btn")).click();
	}

	public void clickLoginButtonOnly() {

		driver.findElement(By.id("signin")).click();
		driver.findElement(By.id("login-btn")).click();
	}

	public void clickSignIn() {
		driver.findElement(By.id("signin")).click();
		System.out.println("Clicked Sign In");
	}

}
