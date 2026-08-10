package io.cucumber.glue;

import io.cucumber.java.en.Given;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.pages.HomePage;

import java.util.List;

import static io.cucumber.data.HomePageTestData.EXPECTED_LINKS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageSteps extends Context {

  public HomePageSteps(Manager manager) {
    super(manager);
  }

  @Given("an example Home Page step")
  public void exampleHomePageStep() {
    System.out.println("printing shared stash :" + getTestStash().toString());
  }


  @Then("actual result is matched to expected result")
  public void verify_actual_expected_matched() {
    HomePage home = new HomePage(getDriver());
    List<String> actual = home.getActualLinks();

    System.out.println("========== EXPECTED LINKS ==========");
    for (String expectedLink : EXPECTED_LINKS) {
      System.out.println(expectedLink);
    }

    System.out.println("========== ACTUAL LINKS ==========");
    for (String actualLink : actual) {
      System.out.println(actualLink);
    }
    for (String expectedLink : EXPECTED_LINKS) {
      assertTrue(actual.contains(expectedLink));

    }

  }
    }


