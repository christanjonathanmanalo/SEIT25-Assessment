package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.pages.SortableDataTablesPage;
import java.util.List;
import static io.cucumber.data.SortableDataTablesTestData.EXPECTED_ROWS;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SortableDataTablesPageSteps extends Context{
    public SortableDataTablesPageSteps(Manager manager) {
        super(manager);
    }

    //TC003
    @Then("Example 1 should display the expected 4 results")
    public void example_1_should_display_the_expected_4_results() {
        SortableDataTablesPage sortableDataTables = new SortableDataTablesPage(getDriver());
        List<List<String>> actualRows = sortableDataTables.getActualRows();

        for (int i = 0; i < EXPECTED_ROWS.size(); i++) {
            System.out.println("Expected row: " + EXPECTED_ROWS.get(i));
            System.out.println(" Actual row: " + actualRows.get(i));
            assertEquals(EXPECTED_ROWS.get(i),actualRows.get(i));

        }
    }
}
