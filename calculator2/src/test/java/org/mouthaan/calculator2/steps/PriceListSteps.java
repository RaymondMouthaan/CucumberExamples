package org.mouthaan.calculator2.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceListSteps {
    private Map<String, Integer> priceList;
    private Integer sum = 0;

    @Given("the price list for a coffee shop")
    public void thePriceListForACoffeeShop(Map<String, Integer> priceList) {
        this.priceList = priceList;
    }

    @When("I order {int} {word}")
    public void iOrderCoffee(int amount, String item) {
        Integer itemPrice = priceList.get(item);
        this.sum +=  amount * itemPrice;
    }

    @Then("should I pay {int}")
    public void shouldIPay(Integer expectedSum) {
        assertEquals(expectedSum, sum);
    }
}
