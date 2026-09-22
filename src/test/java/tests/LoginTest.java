package tests;

import base.BaseTest;
import utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyGoogleTitle() {

        System.out.println("Executing Google Title Test- Master Branch ");

        String title = driver.getTitle();

        System.out.println("Title: " + title);

        ScreenshotUtil.takeScreenshot(driver, "GoogleTitleTest");

        Assert.assertEquals(title, "Google");
    }

    @Test
    public void verifyGoogleURL() {

        System.out.println("Executing Google URL Test");

        String url = driver.getCurrentUrl();

        System.out.println("URL: " + url);

        ScreenshotUtil.takeScreenshot(driver, "GoogleURLTest");

        Assert.assertTrue(url.contains("google"));
    }
}