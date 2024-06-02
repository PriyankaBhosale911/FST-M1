package Examples;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SeleniumTest {
    public static void main(String[] args){
        //installing the gecko drover
        WebDriverManager.firefoxdriver().setup();
        //create the webdriver object
        WebDriver driver=new FirefoxDriver();
        //open a page
        driver.get("https://v1.training-support.net/");
        //Print page title
        System.out.println("Page Title="+driver.getTitle());
        //
        //driver.findElement(By.className("header"));
        driver.findElement(By.cssSelector("h1.ui.header")).getText();
        //find and click the about us link
        driver.findElement(By.id("about-link")).click();
        driver.findElement(By.linkText("About Us")).click();
       // Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("(//i[@class='sidebar big icon'])[2]")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.quit();
    }
}
