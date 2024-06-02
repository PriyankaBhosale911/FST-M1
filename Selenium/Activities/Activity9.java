package Examples;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Activity9
{
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println("Page Title=" + driver.getTitle());
        driver.findElement(By.xpath("//button[@class='ui violet button']")).click();
         //WebElement hello= driver.findElement(By.xpath("//h1[contains(text(),'HELLO!')]"));
         WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("By.xpath(\"//h1[contains(text(),'HELLO!')]\")")));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
            String  heading=driver.findElement(By.tagName("h3")).getText();
        System.out.println("messaige: "+heading);
        driver.quit();
    }
}