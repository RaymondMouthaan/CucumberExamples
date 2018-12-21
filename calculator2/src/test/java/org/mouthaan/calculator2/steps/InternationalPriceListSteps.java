package org.mouthaan.calculator2.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mouthaan.calculator2.models.Price;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InternationalPriceListSteps {

    private HashMap<Object, Object> priceList;
    private Integer sekSum = 0;
    private Integer eurSum = 0;

    @Given("the price list for an international coffee shop")
    public void thePriceListForAnInternationalCoffeeShop(List<Price> prices) {
        priceList = new HashMap<>();

//        prices.forEach(price -> {
//            String key = price.getProduct();
//            priceList.put(key, price);
//        });

        for (Price price : prices) {
            priceList.put(price.getProduct(), price);
        }
    }

    @When("I buy {int} {word}")
    public void iBuyCoffee(int amount, String item) {
        calculate(amount, (Price) priceList.get(item));
    }

    private void calculate(Integer amount, Price price) {
        if (price.getCurrency().equals("SEK")) {
            sekSum += amount * price.getPrice();
            return;
        }
        if (price.getCurrency().equals("EUR")) {
            eurSum += amount * price.getPrice();
            return;
        }
        throw new IllegalArgumentException("The currency is unknown");
    }


    @Then("should I pay {int} EUR and {int} SEK")
    public void shouldIPayEURAndSEK(Integer expectedEurSum, Integer expectedSekSum) {
        assertEquals(expectedEurSum, eurSum);
        assertEquals(expectedSekSum, sekSum);
    }
}
