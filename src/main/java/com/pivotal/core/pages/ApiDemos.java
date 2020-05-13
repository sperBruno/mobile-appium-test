package com.pivotal.core.pages;

import com.pivotal.core.appium.MobileManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ApiDemos  {
    private static final Logger LOGGER = Logger.getLogger(ApiDemos.class.getSimpleName());
    protected AndroidDriver<AndroidElement> driver;

    public ApiDemos() {
        driver = MobileManager.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
    }

    public void openOption(String option) {
        switch (option.toLowerCase()) {
            case "preference":
                // xpath: //tagname[@attribute='value']
                AndroidElement preference = driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
                preference.click();
                break;
            case "settings":
                AndroidElement settings = driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']"));
                settings.click();
                break;
            default:
                LOGGER.info("Not implemented " + option);

        }

    }
}
