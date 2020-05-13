package com.pivotal.core.utils;

import com.pivotal.core.appium.MobileManager;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MobileCommonActions {

    public static boolean isElementDisplayed(AndroidElement element) {
        return element.isDisplayed();
    }

    public static boolean isElementPresent(String xpathLocator) {
        try {
            MobileManager.getInstance().getDriver().findElement(By.xpath(xpathLocator));
            return true;
        }catch (Exception ex) {
            return false;
        }
    }

    public static void clickElement(AndroidElement element) {
        MobileManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
