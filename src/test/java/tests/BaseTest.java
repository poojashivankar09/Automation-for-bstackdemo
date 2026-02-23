//package tests;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.*;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//
//import utils.*;
//
//public class BaseTest {
//
//	protected WebDriver driver;
//	protected ConfigReader config;
//	ExtentReports extent;
//	ExtentTest test;
//
//	@BeforeMethod
//	public void setUp() {
//
//		config = new ConfigReader();
//		driver = WebDriverFactory.initializeDriver(config.getBrowser());
//
//		driver.manage().window().maximize();
//		driver.get(config.getBaseUrl());
//
//	}
//
//	@AfterMethod
//	public void tearDown() throws InterruptedException {
//		Thread.sleep(5000);
//		driver.quit();
//
//	}
//}


package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getInstance();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}


