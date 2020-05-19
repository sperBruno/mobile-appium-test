@Mobile
Feature: Test Mobile

  @Mobile_001
  Scenario: Open API DEMOS app
    Given I open API DEMOS
    When I open Preference option
      And I open Preference Dependencies on preference page
      And I set WIFI checkbox
      And I click on Wifi Settings
      And I set wifi name "Automation"
      And I click on ok button