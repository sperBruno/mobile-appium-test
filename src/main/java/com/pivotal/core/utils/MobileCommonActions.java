package com.pivotal.core.utils;

import com.pivotal.core.appium.MobileManager;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public static void setField(AndroidElement element, String textToSet) {
        element.click();
        element.sendKeys(textToSet);
    }

    public static void setCheckBox(WebElement webElement, boolean enable) {
        if (enable) {
            unCheckBox(webElement);
        } else {
            checkBox(webElement);
        }
    }

    /**
     * This method is going to uncheck the CheckBox WebElement.
     *
     * @param webElement CheckBox to be unchecked.
     */
    private static void unCheckBox(WebElement webElement) {
        if (!webElement.isSelected()) {
            webElement.click();
        }
    }

    /**
     * This method is going to check the CheckBox WebElement.
     *
     * @param webElement CheckBox to be checked.
     */
    private static void checkBox(WebElement webElement) {
        if (webElement.isSelected()) {
            webElement.click();
        }
    }
}
