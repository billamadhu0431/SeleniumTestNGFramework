package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("===== Test Suite Started =====");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("===== Test Started =====");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("===== Class Started =====");
    }

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        // Explicit wait
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        driver.get("https://www.amazon.in/");

        System.out.println("Browser launched");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser closed");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("===== Class Completed =====");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("===== Test Completed =====");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("===== Test Suite Completed =====");
    }
}