import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Activity6 {
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
    public void Activity6() {

            driver.findElement(By.linkText("Jobs")).click();
            String secondPageTitle = driver.getTitle();
            System.out.println("Job Page Title:" + secondPageTitle);
            driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("Banking");
            driver.findElement(By.xpath("//input[@id='search_location']")).sendKeys("Banglore");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.findElement(By.xpath("//input[@type= 'submit' and @value = 'Search Jobs']")).click();
            String profile = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li/a/div[1]/h3")).getText();
            System.out.println(profile);
            if (profile.equals("SAP Testing")) {
                // Close the Browser
                System.out.println("Page Heading matches");
                driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li/a")).click();
                //Assert.assertEquals(By.class"entry-title")).get;
            } else
                System.out.println("Page heading doesn't matches");
            driver.findElement(By.xpath("//input[@type = 'button' and @value = 'Apply for job']")).click();
            //driver.findElement(By.xpath("//button[text()='button']")).click();
            WebElement email = driver.findElement(By.className("job_application_email"));
            driver.findElement(By.cssSelector(".job_application_email")).click();
            System.out.println(email);
        }
    }