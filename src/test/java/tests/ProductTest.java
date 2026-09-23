package tests;

import base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(priority = 1)
    public void verifyProductSearch() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")
                )
        ).sendKeys("Laptop");

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("twotabsearchtextbox")
                )
        ).sendKeys(Keys.ENTER);

        wait.until(
                ExpectedConditions.urlContains("s?k=")
        );

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Product Search URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("s?k=Laptop"),
                "Laptop search was not successful. Current URL: "
                        + currentUrl
        );
    }

    @Test(priority = 2)
    public void verifyProductDetails() {

        System.out.println("Verify product details");
    }
}