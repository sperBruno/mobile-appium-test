package com.pivotal;

import com.pivotal.pages.ApiDemos;
import com.pivotal.pages.PreferenceDependenciesPage;
import com.pivotal.pages.PreferencesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MobileStepdefs {

    ApiDemos apiDemos;
    PreferencesPage preferencesPage;
    PreferenceDependenciesPage preferenceDependenciesPage;

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
        preferenceDependenciesPage = preferencesPage.preferenceDependenciesPage();
    }

    @And("I set WIFI checkbox")
    public void iSetWIFICheckbox() {
       preferenceDependenciesPage.checkWifi();
    }

    @And("I click on Wifi Settings")
    public void iClickOnWifiSettings() {
        preferenceDependenciesPage.clickWifiSettings();
    }

    @And("I set wifi name \"(.*)\"$")
    public void iSetWifiName(String name) {
        preferenceDependenciesPage.editWifiSettingsName(name);
    }

    @And("I click on ok button")
    public void iClickOnOkButton() {
        preferenceDependenciesPage.clickOkBtn();
    }
}
