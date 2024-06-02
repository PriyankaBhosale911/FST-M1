package Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String[] args){
        //get the gecko driver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);
    driver.get("https://v1.training-support.net/selenium/drag-drop");
    System.out.println("Page TitleL: "+driver.getTitle());
    driver.findElement(By.id("draggable")).click();
    }
}
