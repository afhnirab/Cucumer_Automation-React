package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Homepage;
import setup.Setup;

public class SearchStepDefinition extends Setup {
    Homepage homepage;
    @Given("user visits the github website")
    public void user_visits_the_github_website() {
        driver.get("https://github.com/");
    }
    @When("user search with {string}")
    public void user_search_with(String repositoryKeyword) throws InterruptedException {
        homepage = new Homepage(driver);
        homepage.doSearch(repositoryKeyword);
    }
    @Then("user verify with {string}")
    public void user_verify_with(String repositoryName) {
       String validate_actual = driver.findElements(By.className("v-align-middle")).get(8).getText();
        Assert.assertTrue(validate_actual.contains(repositoryName));
    }
    @And("user click on about page")
    public void user_click_on_about_page() throws InterruptedException {
        homepage = new Homepage(driver);
        Thread.sleep(1000);
        homepage.clickAbout();
        Thread.sleep(2000);
    }
    @Then("user verify the about page")
    public void user_verify_the_about_page() {
        String validate_actual = driver.getCurrentUrl();
        String validate_expected = "about";
        Assert.assertTrue(validate_actual.contains(validate_expected));
    }

    @After
    public void doQuit(){
        driver.quit();
    }
}
