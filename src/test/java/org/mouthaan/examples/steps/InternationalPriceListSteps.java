package org.mouthaan.examples.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mouthaan.examples.models.Price;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InternationalPriceListSteps {
    private Map<String, Price> priceList;
    private int sekSum;
    private int euroSum;

    @Given("the price list for an international coffee shop")
    public void thePriceListForAnInternationalCoffeeShop(List<Price> prices) {
        priceList = new HashMap<>();

        prices.forEach(price -> {
            String key = price.getProduct();
            priceList.put(key, price);
        });
    }

    @When("I buy {int} {word}")
    public void iBuy(Integer numberOfItems, String item) {
        Price price = priceList.get(item);
        calculate(numberOfItems, price);
    }

    private void calculate(Integer numberOfItems, Price price) {
        if (price.getCurrency().equals("SEK")) {
            sekSum += numberOfItems * price.getPrice();
            return;
        }
        if (price.getCurrency().equals("EUR")) {
            euroSum += numberOfItems * price.getPrice();
            return;
        }
        throw new IllegalArgumentException("The currency is unknown");
    }

    @Then("should I pay {int} EUR and {int} SEK")
    public void shouldIPayEURAndSEK(int expectedEuroSum, int expectedSekSum) {
        assertEquals(expectedEuroSum, euroSum);
        assertEquals(expectedSekSum, sekSum);
    }
}
