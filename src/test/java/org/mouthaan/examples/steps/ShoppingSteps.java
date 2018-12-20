package org.mouthaan.examples.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mouthaan.examples.RpnCalculator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingSteps {
    private RpnCalculator calculator = new RpnCalculator();

    @Given("the following groceries:")
    public void theFollowingGroceries(List<Grocery> groceries) {
            groceries.forEach(grocery -> {calculator.push(grocery.price.value);
            calculator.push("+");
        });
    }

    @When("I pay {int}")
    public void iPay(int amount) {
        calculator.push(amount);
        calculator.push("-");
    }

    @Then("my change should be {int}")
    public void myChangeShouldBe(int change) {
        assertEquals(change, -calculator.value().intValue());
    }


    static class Grocery {
        private String name;
        private Price price;

        public void setPrice(Price price) {
            this.price = price;
        }

        public Price getPrice() {
            return price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    static final class Price {
        private int value;

        Price(int value) {
            this.value = value;
        }

        static Price fromString(String value) {
            return new Price(Integer.parseInt(value));
        }

    }
}
