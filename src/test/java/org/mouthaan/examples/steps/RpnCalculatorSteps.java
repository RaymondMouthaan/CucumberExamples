package org.mouthaan.examples.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mouthaan.examples.RpnCalculator;
import org.mouthaan.examples.models.Entry;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RpnCalculatorSteps {
    private RpnCalculator calculator;


    @Given("a calculator I just turned on")
    public void aCalculatorIJustTurnedOn() {
        calculator = new RpnCalculator();
    }


    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        calculator.push(arg0);
        calculator.push(arg1);
        calculator.push("+");
    }

    @Then("the result is {int}")
    public void theResultIs(double expected) {
        assertEquals(expected, calculator.value());
    }

    @Given("the previous entries:")
    public void thePreviousEntries(List<Entry> entries) {
        entries.forEach(entry -> {
            calculator.push(entry.getFirst());
            calculator.push(entry.getSecond());
            calculator.push(entry.getOperation());
        });
    }

    @When("I press (.+)")
    public void iPress(String what) {
        calculator.push(what);
    }


}
