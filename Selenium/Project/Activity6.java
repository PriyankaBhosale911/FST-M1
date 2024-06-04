import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //Include alwaysRun property on the @BeforeTest
    //to make sure the page opens
    //Include alwaysRun property on the @BeforeTest
    //to make sure the page opens
    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().minimize();
    }
    @Test
    //Open the website and log-in using the provided credentials.
    public void login(){
        driver.findElement(By.linkText("My Account")).click();
        // wait.until(ExpectedConditions.titleIs("My Account – Alchemy LMS"));
        System.out.println(driver.getTitle());
        Assert.assertEquals("My Account – Alchemy LMS", driver.getTitle());
        //  driver.findElement(By.className("login")).click();
        // driver.findElement(By.className("login-button")).click();
        driver.findElement(By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        //  driver.findElement(By.xpath("//a[contains(text(),'Howdy')]")).isDisplayed();
        String welcomeMsg=driver.findElement(By.xpath("//p[@class='uagb-ifb-desc']")).getText();
        System.out.println("Login message:"+welcomeMsg);
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Howdy')]")).isDisplayed());
    }


    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.quit();

    }
}
