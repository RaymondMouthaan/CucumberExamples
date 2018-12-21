package org.mouthaan.calculator;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/html-report", "json:target/cucumber-reports/cucumber.json"},
        features = "src/test/resources/org/mouthaan/calculator/features",
        glue = { "org.mouthaan.calculator.steps", "org.mouthaan.calculator.transformers"}
)
public class RunCucumberCalculatorJava8Tests {
}
