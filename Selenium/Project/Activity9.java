import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Activity9 {
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
        @Test(priority = 9)

        public void Activity9 () throws InterruptedException {
            driver.get("https://alchemy.hguy.co/jobs/wp-admin");
            driver.findElement(By.id("user_login")).sendKeys("root");
            driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
            //wp-submit
            driver.findElement(By.id("wp-submit")).click();
            driver.findElement(By.xpath("//li[@id='menu-dashboard']/a/div[3]")).click();
            driver.findElement(By.xpath("//li[@id='menu-posts-job_listing']/a/div[3]")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Add New')])[7]")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //post-title-0
            //   Thread.sleep(5000);
            String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
            String subWindowHandler = null;

            Set<String> handles = driver.getWindowHandles(); // get all window handles
            Iterator<String> iterator = handles.iterator();
            subWindowHandler = iterator.next();
            driver.switchTo().window(subWindowHandler);

            String str22 = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/div/div[2]/div[1]/p")).getText();
            System.out.println(str22);
            driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/div/div[2]/div[2]/button")).click();
            driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/div/div[2]/div[2]/button[2]")).click();
            driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/div/div[2]/div[2]/button[2]")).click();
            driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/div/div[2]/div[2]/button[2]")).click();

            driver.switchTo().window(parentWindowHandler);
            Thread.sleep(5000);
            //post-title-0
            driver.findElement(By.id("post-title-0")).sendKeys("Sam");
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.scrollBy(0,300)");
            driver.findElement(By.id("_job_location")).sendKeys("London");
            driver.findElement(By.id("_company_name")).sendKeys("IBM");
            driver.findElement(By.id("_company_website")).sendKeys("http://google.com");
            //(//button[@type='button'])[9]
            driver.findElement(By.xpath("//button[contains(.,'Publish…')]")).click();
            driver.findElement(By.cssSelector(".editor-post-publish-button")).click();
        }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    }