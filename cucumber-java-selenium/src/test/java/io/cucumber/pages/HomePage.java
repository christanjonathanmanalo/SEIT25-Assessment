package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends Page {

  public HomePage(ChromeDriver driver) {
    super(driver);
    System.out.println("Homepage title is : " + getTitle().getText());
  }
//Locators
  @FindBy(css = "h1")
  private WebElement title;

  @FindBy(css = "ul li a")
  private List<WebElement> links;

  //Getters
  public WebElement getTitle() {
    return title;
  }

  public List<WebElement> getLinks() {
    return links;
  }

  //Page methods
  public List<String> getActualLinks() {
    List<String> actualLinks = new ArrayList<>();

    for (WebElement link : links) {
      actualLinks.add(link.getText());
    }

    return actualLinks;
  }
  public void refresh() {
   driver.navigate().refresh();
    System.out.println("Refreshed page");
  }
}
