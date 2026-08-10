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

    public List<List<String>> getActualRows() {
        List<List<String>> actualRows = new ArrayList<>();
        for (WebElement row : getRows()) {
            List<WebElement> columns = row.findElements(By.xpath("./td"));

            //checking each rows have 5 cells, and if not we skip it and move to the next row.
            if (columns.size() != 5) {
                continue;
            }

            List<String> actualRow = new ArrayList<>();
            for (WebElement column : columns) {
                actualRow.add(column.getText());
            }
            actualRows.add(actualRow);

        }
        return actualRows;
        }
    }

