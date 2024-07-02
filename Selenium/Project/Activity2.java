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

    public class Activity2 {
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
        public void Activity2() {
            String heading = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
            System.out.println(heading);
            if ( heading.equals("Welcome to training Jobss") ){
                // Close the Browser
                System.out.println("Page Heading matches");
                //Assert.assertEquals(By.class"entry-title")).get;
            } else
                System.out.println("Page heading doesn't matches");
        }
        @AfterClass
        public void tearDown() {
            driver.quit();
        }

    }