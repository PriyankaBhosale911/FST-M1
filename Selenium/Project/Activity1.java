import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Activity1 {


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
    //page title test
    public void getPageTitle() {
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Alchemy LMS – An LMS Application");
    }

    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.quit();

    }
    }
