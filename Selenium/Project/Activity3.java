import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity3 {
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
    public void Activity3() {
        String image = driver.findElement(By.xpath("//article[@id='post-16']/header/div/img")).getAttribute("src");
        //String image = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/header/div/img")).getAttribute("src");
        System.out.println(image);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}