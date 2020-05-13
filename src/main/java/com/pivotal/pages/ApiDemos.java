package com.pivotal.pages;

import com.pivotal.core.appium.MobileManager;
import com.pivotal.core.utils.MobileCommonActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ApiDemos {

    private static final Logger LOGGER = Logger.getLogger(ApiDemos.class.getSimpleName());
    protected AndroidDriver<AndroidElement> driver;

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    AndroidElement ok;

    public ApiDemos() {
        driver = MobileManager.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        if (MobileCommonActions.isElementPresent("//android.widget.Button[@text='OK']")) {
            AndroidElement element = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
            MobileCommonActions.clickElement(element);
            }
    }

    public void openOption(String option) {
        switch (option.toLowerCase()) {
            case "preference":
                // xpath: //tagname[@attribute='value']
                AndroidElement preference = driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
                MobileCommonActions.clickElement(preference);
                break;
            case "settings":
                AndroidElement settings = driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']"));
                MobileCommonActions.clickElement(settings);
                break;
            default:
                LOGGER.info("Not implemented " + option);
        }

    }

    public PreferencesPage getPreference() {
        AndroidElement preference = driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
        MobileCommonActions.clickElement(preference);
        return new PreferencesPage();
    }
}
