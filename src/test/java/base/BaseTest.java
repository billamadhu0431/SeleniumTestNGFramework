package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        System.out.println("===== Before Method =====");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDown() {

        System.out.println("===== After Method =====");

        if (driver != null) {
            driver.quit();
        }
    }
}