package com.pivotal;

import com.pivotal.core.pages.ApiDemos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MobileStepdefs {

    ApiDemos apiDemos;

    @Given("^I open API DEMOS$")
    public void openMobileCalculator() {
       apiDemos = new ApiDemos();
    }

    @When("I open (.*) option$")
    public void iOpenOption(String option) {
        apiDemos.openOption(option);
    }
}
