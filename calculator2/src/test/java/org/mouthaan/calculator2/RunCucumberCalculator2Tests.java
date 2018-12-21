package org.mouthaan.calculator2;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/html-report", "json:target/cucumber-reports/cucumber.json"},
        features = "src/test/resources/org/mouthaan/calculator2/features",
        glue = { "org.mouthaan.calculator2.steps", "org.mouthaan.calculator2.transformers"}
)
public class RunCucumberCalculator2Tests {
}
