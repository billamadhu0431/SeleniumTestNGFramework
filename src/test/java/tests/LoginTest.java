package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyAmazonHomePage() {

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        Assert.assertTrue(
                driver.getCurrentUrl().contains("amazon"),
                "Amazon page was not opened"
        );

        System.out.println("Amazon page opened successfully");
    }
}