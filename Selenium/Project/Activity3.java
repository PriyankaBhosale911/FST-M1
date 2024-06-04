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

public class Activity3 {
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
    //Read the title of the first info box on the website and verify the text
    public void getInforBoxTitle(){
        String firstTitleBox=driver.findElement(By.xpath("(//h3[@class='uagb-ifb-title'])[1]")).getText();
        System.out.println(firstTitleBox);
        Assert.assertEquals("Actionable Training",firstTitleBox);
    }


    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.quit();

    }
}
