package com.test.automationexercises.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/automationexercises",
        glue = "com/test/automationexercises/stepdefinitions",
        dryRun = false ,
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
//        tags="@smoke"
)

public class AutomationExerciseRunner {
}
