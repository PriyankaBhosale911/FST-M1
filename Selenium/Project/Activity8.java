import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
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
    //Navigate to the “Contact Us” page and complete the form.
    public void contactUsForm()
    {
        driver.findElement(By.linkText("Contact")).click();
        driver.findElement(By.name("wpforms[fields][0]")).sendKeys("Priyank Bhosale");
        driver.findElement(By.name("wpforms[fields][1]")).sendKeys("priyanka.bhosale@ibm.com");
        driver.findElement(By.name("wpforms[fields][2]")).sendKeys("Selenium TestNG project");
        driver.findElement(By.name("wpforms[fields][3]")).sendKeys("LMS project testing is in progress..");
        driver.findElement(By.name("wpforms[submit]")).click();
        System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting us! We will be in touch with you shortly.')]")).getText());
    }
    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.quit();

    }
}
