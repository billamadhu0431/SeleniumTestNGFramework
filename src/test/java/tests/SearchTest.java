package tests;

import base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(priority = 1)
    public void searchForLaptop() {

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

        System.out.println("Search URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("s?k="),
                "Laptop search was not successful"
        );
    }

    @Test(priority = 2)
    public void searchForHeadphones() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")
                )
        ).sendKeys("Headphones");

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("twotabsearchtextbox")
                )
        ).sendKeys(Keys.ENTER);

        System.out.println("Headphones search completed");
    }
}