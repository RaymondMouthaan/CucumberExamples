package org.mouthaan.examples.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceListSteps {
    private Map<String, Integer> priceList;
    private int totalSum;

    @Given("the price list for a coffee shop")
    public void thePriceListForACoffeeShop(Map<String, Integer> priceList) {
        this.priceList = priceList;
    }

    @When("I order {int} {word}")
    public void iOrderCoffee(Integer numberOfFirstItem, String item) {
        int firstPrice = priceList.get(item);
        totalSum += firstPrice * numberOfFirstItem;
    }

    @Then("should I pay {int}")
    public void shouldIPay(int expectedCosts) {
        assertEquals(expectedCosts, totalSum);
    }


}
