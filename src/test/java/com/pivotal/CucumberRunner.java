package com.pivotal;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:report/cucumber.json", "junit:report/cucumber.xml",
                "html:report/cucumber-html-report", "rerun:report/rerun.txt", "io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"},
        features = {"src/test/resources/features"},
        glue = {"com/pivotal"})
public class CucumberRunner {

}
