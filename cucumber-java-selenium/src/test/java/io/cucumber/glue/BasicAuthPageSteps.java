package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.BasicAuthPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

 public class BasicAuthPageSteps extends Context {
    //TC002
    public BasicAuthPageSteps(Manager manager) {

        super(manager);
    }

    @When("the 'Basic Auth' example is opened")
    public void the_example_is_opened() {
        // Write code here that turns the phrase above into concrete actions
        BasicAuthPage basicAuthPage = new BasicAuthPage(getDriver());
        basicAuthPage.clickBasicAuthLink();

    }

    @When("valid credentials are supplied")
    public void valid_credentials_are_supplied() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        BasicAuthPage basicAuthPage = new BasicAuthPage(getDriver());
        basicAuthPage.inputUsernameAndPassword();

    }
    @Then("Congratulations should be displayed")
    public void congratulations_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        BasicAuthPage basicAuthPage = new BasicAuthPage(getDriver());
        String actualMessage = basicAuthPage.getActualMessage();
        String expectedMessage = "Congratulations! You must have the proper credentials.";
        System.out.println("Expected Message: "+expectedMessage);
        System.out.println("Actual Message: "+actualMessage);
        assertEquals(expectedMessage,actualMessage);
    }
}
