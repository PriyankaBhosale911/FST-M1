package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;


public class Activity1 {
    AndroidDriver driver;
    // AppiumDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomater2")
                .setAppPackage("com.android.Calculator")
                .setAppActivity(".Calculator")
                .noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, caps);
    }
    @Test
    public void multiplyTest(){
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_6")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
        String result=driver.findElement(AppiumBy.id("result")).getText();
        assertEquals(result,"=54");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();

    }
}