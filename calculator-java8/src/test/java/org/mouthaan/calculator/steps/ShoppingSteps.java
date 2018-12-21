package org.mouthaan.calculator.steps;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import org.mouthaan.calculator.RpnCalculator;
import org.mouthaan.calculator.models.Grocery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingSteps implements En {
    private RpnCalculator calculator = new RpnCalculator();

    public ShoppingSteps() {
        Given("^the following groceries:$", (DataTable dataTable) -> {
            List<Grocery> groceries = dataTable.asList(Grocery.class);

            groceries.forEach(grocery -> {
                calculator.push(grocery.getPrice().getValue());
                calculator.push("+");
            });
        });

        When("^I pay (\\d+)$", (Integer amount) -> {
            calculator.push(amount);
            calculator.push("-");
        });

        Then("^my change should be (\\d+)$", (Integer expected) -> assertEquals(-1 * Double.valueOf(expected), calculator.value()));
    }
}
