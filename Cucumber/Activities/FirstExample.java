package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstExample extends BaseClass{
    @BeforeAll
    //why we made steUp menthod static, everywhere in the project we are calling setUp mathod
    public static void setUp(){
        //Setup browser
        WebDriverManager.firefoxdriver().setup();
        //initialize firefox driver
        driver=new FirefoxDriver();
    }
    @AfterAll
    public static void tearDown(){
        //close the browser
        driver.quit();
    }

    @Given("The user is on the TS Homepage")
    public void openTSHomePage(){
//open the TSHomepage
        driver.get("www.google.com");
        //Assert
        Assertions.assertEquals(driver.getTitle(),"Training Support");

    }

    @When("the user clicks on the about us link")
    //find and click about us link
    public void clickAboutLink(){

        driver.findElement(By.id("about-link")).click();
    }

    @Then("the user is redirected to About page")
    //verify aboutpage
    public void verifyAboutPage(){
        Assertions.assertEquals("About Training Support", driver.getTitle());
    }
}
