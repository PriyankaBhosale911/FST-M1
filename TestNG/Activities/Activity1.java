package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //open the page
        driver.get("https://v1.training-support.net/");
    }
@Test(priority = 1)
        public void homePageTest(){
//Assert the page title
    Assert.assertEquals(driver.getTitle(),"Training Support");
    //find and click the about us page
    driver.findElement(By.id("about-link")).click();
    }
    @Test(priority=2)
    public void aboutPageTest(){
        //Assert page title
        Assert.assertEquals(driver.getTitle(),"About Training Support");
}
@AfterClass
public void tearDown(){
        driver.quit();
}
}
