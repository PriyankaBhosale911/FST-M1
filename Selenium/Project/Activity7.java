import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity7 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Create the Actions object
        Actions builder = new Actions(driver);

        // Open the page
        driver.get("https://alchemy.hguy.co/jobs/");
        // Print the title of the page

    }

    @Test
    public void Activity7() throws InterruptedException {
        driver.findElement(By.linkText("Post a Job")).click();
        //create_account_email
        driver.findElement(By.id("create_account_email")).sendKeys("test1@abdef.com");
        //job_title
        driver.findElement(By.id("job_title")).sendKeys("Test_Job");
        //job_location
        driver.findElement(By.id("job_location")).sendKeys("Mysore");
        //job_type
        Select dropdown = new Select(driver.findElement(By.id("job_type")));
        dropdown.selectByIndex(2);
        //tinymce tinymce
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(2000);


        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//body[@id='tinymce']/p")).click();
        WebElement element1 = driver.findElement(By.id("tinymce"));
        element1.click();
        element1.sendKeys("Test");

        driver.switchTo().defaultContent();
        //application
        driver.findElement(By.id("application")).sendKeys("test3@yahoo.com");
        //company_name
        driver.findElement(By.id("company_name")).sendKeys("IBM");
        //company_website
        driver.findElement(By.id("company_website")).sendKeys("https://alchemy.hguy.co/jobs/");
        //company_tagline
        driver.findElement(By.id("company_website")).sendKeys("Sam");
        // Preview
        driver.findElement(By.xpath("//input[@name='submit_job']")).click();
        //job_preview_submit_button
        driver.findElement(By.id("job_preview_submit_button")).click();
        //click here

        driver.findElement(By.linkText("click here")).click();
        Thread.sleep(2000);
    }
}