package tests;

import base.BaseTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyAddToCart() {

        // Step 1: Search for Laptop
        System.out.println("Step 1: Search for Laptop");

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


        // Step 2: Wait for search results
        System.out.println("Step 2: Wait for search results");

        wait.until(
                ExpectedConditions.urlContains("s?k=")
        );


        // Step 3: Select product
        System.out.println("Step 3: Selecting product");

        By productLink = By.xpath(
                "(//div[@data-component-type='s-search-result']//a[contains(@href,'/dp/')])[3]"
        );

        WebElement product = wait.until(
                ExpectedConditions.presenceOfElementLocated(productLink)
        );

        String productUrl = product.getAttribute("href");

        System.out.println("Product URL: " + productUrl);


        // Step 4: Open product page
        System.out.println("Step 4: Opening product page");

        driver.get(productUrl);


        // Step 5: Wait for product page
        System.out.println("Step 5: Waiting for product page");

        wait.until(
                ExpectedConditions.urlContains("/dp/")
        );

        System.out.println(
                "Product page title: " + driver.getTitle()
        );


        // Step 6: Find and click Add to Cart
        System.out.println("Step 6: Looking for Add to Cart");

        List<WebElement> buttons = driver.findElements(
                By.id("add-to-cart-button")
        );

        System.out.println(
                "Number of Add to Cart elements: " + buttons.size()
        );

        WebElement cartButton = null;

        for (WebElement button : buttons) {

            System.out.println(
                    "Displayed: " + button.isDisplayed()
            );

            System.out.println(
                    "Enabled: " + button.isEnabled()
            );

            if (button.isDisplayed() && button.isEnabled()) {

                cartButton = button;
                break;
            }
        }

        if (cartButton == null) {

            throw new RuntimeException(
                    "No visible and enabled Add to Cart button found"
            );
        }

        System.out.println("Add to Cart button found");

        cartButton.click();

        System.out.println("Add to Cart button clicked");


        // Step 7: Verify cart
        System.out.println("Step 7: Verifying cart");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("nav-cart-count")
                )
        );

        String cartCount = driver.findElement(
                By.id("nav-cart-count")
        ).getText();

        System.out.println(
                "Cart count: " + cartCount
        );

        Assert.assertTrue(
                Integer.parseInt(cartCount) > 0,
                "Product was not added to cart"
        );

        System.out.println(
                "Product successfully added to cart"
        );
    }
}