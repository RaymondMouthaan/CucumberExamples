package org.mouthaan.calculator2.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Calculator2Steps {
    private List<Integer> numbers;
    private int sum;

    @Given("a list of numbers")
    public void aListOfNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @When("I summarize them")
    public void iSummarizeThem() {
        for (int number : numbers) {
            sum += number;
        }
    }

    @Then("should I get {int}")
    public void shouldIGet(int expectedSum) {
        assertEquals(expectedSum, sum);
    }


}
