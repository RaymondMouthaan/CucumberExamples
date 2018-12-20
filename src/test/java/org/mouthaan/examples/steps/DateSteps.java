package org.mouthaan.examples.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mouthaan.examples.DateCalculator;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateSteps {
    private String result;
    private DateCalculator calculator;

    @Given("^today is ([0-9]{4}-[0-9]{2}-[0-9]{2})$")
    public void todayIs(Date date) {
        calculator = new DateCalculator(date);
    }

    @When("^I ask if ([0-9]{4}-[0-9]{2}-[0-9]{2}) is in the past$")
    public void iAskIfIsInThePast(Date date) {
        result = calculator.isDateInThePast(date);
    }


    @Then("^the result should be (yes|no)$")
    public void theResultShouldBeYes(String expectedResult) {
        assertEquals(expectedResult, result);
    }
}
