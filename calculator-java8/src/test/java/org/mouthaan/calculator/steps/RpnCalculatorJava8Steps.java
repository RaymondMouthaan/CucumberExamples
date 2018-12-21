package org.mouthaan.calculator.steps;

import org.mouthaan.calculator.RpnCalculator;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import org.mouthaan.calculator.models.Entry;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RpnCalculatorJava8Steps implements En {
    private RpnCalculator calculator;

    public RpnCalculatorJava8Steps() {
        Given("^a calculator I just turned on$", () -> calculator = new RpnCalculator());

        When("^I add (\\d+) and (\\d+)$", (Integer arg0, Integer arg1) -> {
            calculator.push(arg0);
            calculator.push(arg1);
            calculator.push("+");
        });

        Then("^the result is (\\d+)$", (Integer expected) -> {
            assertEquals(Double.valueOf(expected), calculator.value());
        });

        Given("^the previous entries:$", (DataTable dataTable) -> {
            List<Entry> entries = dataTable.asList(Entry.class);

            entries.forEach(entry -> {
                calculator.push(entry.getFirst());
                calculator.push(entry.getSecond());
                calculator.push(entry.getOperation());
            });
        });

        When("^I press (.+)$", (String what) -> {
            calculator.push(what);
        });


    }
}
