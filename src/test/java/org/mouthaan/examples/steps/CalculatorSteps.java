package org.mouthaan.examples.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSteps {
    private List<Integer> numbers;
    private int sum;

    @Given("a list of numbers")
    public void aListOfNumbers(List<Integer> numbers) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        this.numbers = numbers;
    }

    @When("I summarize them")
    public void iSummarizeThem() {
        this.numbers.forEach(n -> sum += n);
    }

    @Then("should I get {int}")
    public void shouldIGet(int expectedSum) {
        assertEquals(expectedSum, sum);
    }


}
