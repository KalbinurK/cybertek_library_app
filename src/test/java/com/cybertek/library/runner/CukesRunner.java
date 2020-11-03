package com.cybertek.library.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src\\test\\resources\\features",
        glue = "com\\cybertek\\library\\step_definitions",
        plugin = "html:target\\cucumber-report.html",
        dryRun = false,
        tags ="@borrowBook"

)
public class CukesRunner {


}
