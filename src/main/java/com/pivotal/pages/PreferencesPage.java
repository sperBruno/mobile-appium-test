package com.pivotal.pages;

import com.pivotal.core.utils.MobileCommonActions;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class PreferencesPage extends ApiDemos {
    private static final Logger LOGGER = Logger.getLogger(PreferencesPage.class.getSimpleName());
    private String launchingPreferencesLocator = "//android.widget.TextView[@text='2. Launching preferences']";
    private String preferenceDependenciesLocator = "//android.widget.TextView[@text='3. Preference dependencies']";

    @FindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']" )
    AndroidElement pp;

    private String fragmentLocator = "//android.widget.TextView[@text='7. Fragment']";

    public void openPreferenceOption(String option) {
        switch (option.toLowerCase()) {
            case "preference dependencies":
                // xpath: //tagname[@attribute='value']
                AndroidElement preferenceDependencies = driver.findElement(By.xpath(preferenceDependenciesLocator));
                MobileCommonActions.clickElement(preferenceDependencies);
                break;
            case "launching preferences":
                // xpath: //tagname[@attribute='value']
                AndroidElement launchingPreference = driver.findElement(By.xpath(launchingPreferencesLocator));
                launchingPreference.click();
                break;
            case "fragment":
                AndroidElement fragment = driver.findElement(By.xpath(fragmentLocator));
                MobileCommonActions.clickElement(fragment);
                break;
            default:
                LOGGER.info("Not implemented " + option);

        }

    }
}
