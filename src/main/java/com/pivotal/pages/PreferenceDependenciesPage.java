package com.pivotal.pages;

import com.pivotal.core.utils.MobileCommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PreferenceDependenciesPage extends ApiDemos {

    private String wifiCheckboxLocator = "android:id/checkbox";
    private String wifiSettingsLocator = "//android.widget.TextView[@text='WiFi settings']";
    private String editWifiSettingField = "android.widget.EditText";
    private String okBtn = "//android.widget.Button[@text='OK']";


    public void checkWifi() {
        MobileCommonActions.setCheckBox(driver.findElementById(wifiCheckboxLocator), true);
    }

    public void clickWifiSettings() {
        MobileCommonActions.clickElement(driver.findElementByXPath(wifiSettingsLocator));
    }

    public void editWifiSettingsName(String name) {
        MobileCommonActions.setField(driver.findElementByClassName(editWifiSettingField), name);
    }

    public void clickOkBtn() {
        MobileCommonActions.clickElement(driver.findElementByXPath(okBtn));
    }
}
