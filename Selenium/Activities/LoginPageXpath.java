package Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPageXpath {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Page Title="+driver.getTitle());
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@class='ui button']")).click();
        driver.findElement(By.xpath("(//div[contains(text(),'Welcome Back')])[1]")).isDisplayed();
        //String WlText=WelcomeTxt.toString();
        String WlT=driver.findElement(By.xpath("(//div[contains(text(),'Welcome Back')])[1]")).getText();
        System.out.println("Wlcome Message:"+WlT);

    }
}
