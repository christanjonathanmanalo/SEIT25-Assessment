package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class BasicAuthPage extends Page {
    public BasicAuthPage(ChromeDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(css = "a[href='/basic_auth']")
    private WebElement basicAuthLink;

    @FindBy(css = "p")
    private WebElement messageText;


    //Input username and password
    public void clickBasicAuthLink() {
        basicAuthLink.click();
    }

    public void inputUsernameAndPassword() throws Exception {
        //creating robot object to simulate keyboard actions
        Robot robot = new Robot();

        Thread.sleep(1000);

        // Username
        //admin is clipboard content
        StringSelection username = new StringSelection("admin");
        //put the admin on system clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Tab to Password
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        // Password
        StringSelection password = new StringSelection("admin");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(password, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public String getActualMessage() {
        return messageText.getText();
    }
}

