package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

    public static void main(String[] args) {
        //get the gecko driver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Page TitleL: " + driver.getTitle());
        Select select = new Select(driver.findElement(By.id("single-select")));
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(3);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("4");
        System.out.println(select.getFirstSelectedOption().getText());

        //print all otpitonms
        for(WebElement option: select.getOptions()){
            System.out.println(option.getText());
        }
        driver.quit();
    }
}