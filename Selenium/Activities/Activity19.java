package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity19 {
    //get the gecko driver
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Page TitleL: " + driver.getTitle());

        driver.findElement(By.id("confirm")).click();

        Alert confirmAlert=driver.switchTo().alert();
        System.out.println("Alert message: "+confirmAlert.getText());
        confirmAlert.accept();
        driver.close();
    }
}