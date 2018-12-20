package org.mouthaan.examples;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/html-report", "json:target/cucumber-reports/cucumber.json"},
        features = "src/test/resources/features",
        glue = { "org.mouthaan.examples.steps", "org.mouthaan.examples.transformers"}
)
public class RunCucumberTests {
}
