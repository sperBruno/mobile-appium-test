package com.pivotal;

import com.pivotal.pages.ApiDemos;
import com.pivotal.pages.PreferencesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MobileStepdefs {

    ApiDemos apiDemos;
    PreferencesPage preferencesPage;

    @Given("^I open API DEMOS$")
    public void openMobileCalculator() {
       apiDemos = new ApiDemos();
    }

    @When("I open (.*) option$")
    public void iOpenOption(String option) {
//        preferencesPage = apiDemos.openOption(option);
        preferencesPage = apiDemos.getPreference();
    }

    @And("I open (.*) on preference page$")
    public void iOpenPreferenceDependenciesOnPreferencePage(String option) {
        preferencesPage.openPreferenceOption(option);
    }
}
