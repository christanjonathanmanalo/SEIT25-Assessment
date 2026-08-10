package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SortableDataTablesPage extends Page {
    public SortableDataTablesPage(ChromeDriver driver) {
        super(driver);
    }
    //TC003

    //Locator
    @FindBy(css = "table tbody tr")
    private List<WebElement> rows;

    //Getter
    public List <WebElement> getRows() {
        return rows;
    }

    public List<String> getActualRows() {
        List<String> actualRows = new ArrayList<>();
        for (WebElement row : getRows()) {
            List<WebElement> columns = row.findElements(By.xpath("./td"));

            //checking each rows have 5 cells, and if not we skip it and move to the next row.
            if (columns.size() != 5) {
                continue;
            }

            String actualRow = columns.get(0).getText() + "|" +
                            columns.get(1).getText() + "|" +
                            columns.get(2).getText() + "|" +
                            columns.get(3).getText() + "|" +
                            columns.get(4).getText();
//add the 5 combined strings
            actualRows.add(actualRow);

        }
        return actualRows;
        }
    }

