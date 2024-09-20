import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;

public class DataTable {
    public class DataTableExampleSteps {

        @Given("User completes the requirement")
        public void completeRequirement() {
            System.out.println("Given completed");
        }

        @When("User enters the following username and password")
        public void user_enters_and(io.cucumber.datatable.DataTable credentials) {
            List<List<String>> creds = credentials.asLists();
            for (List<String> cred : creds) {
                for (String credential : cred) {
                    System.out.println(credential);
                }
            }
            System.out.println(creds);
        }

        @When("User enters the following tasks")
        public void inputTasks(io.cucumber.datatable.DataTable inputTasks) {
            BaseClass.driver.get("https://v1.training-support.net/selenium/todo-list");
            List<String> tasks = inputTasks.asList();
            System.out.println(tasks);

            for(String task : tasks) {
                BaseClass.driver.findElement(By.id("taskInput")).sendKeys(task);
            }
        }

        @Then("Verify results")
        public void verifyResults() {
            System.out.println("Verification complete");
        }
    }
}