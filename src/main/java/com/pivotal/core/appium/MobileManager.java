package com.pivotal.core.appium;

import com.pivotal.core.utils.PropertiesInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileManager {
    private static final Logger LOGGER = Logger.getLogger(MobileManager.class.getSimpleName());
    private static final String APK_ORIGINAL_APK = "apk/original.apk";
    private static final String UIAUTOMATOR_2 = "uiautomator2";
    private static MobileManager instance = null;
    private AndroidDriver<AndroidElement> driver = null;
    private WebDriverWait wait = null;

    private MobileManager() {
        initAndroidDriver();
    }

    protected void initAndroidDriver() {
        File f = new File(APK_ORIGINAL_APK);
        LOGGER.info(f.getAbsolutePath());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesInfo.getInstance().getEmulatorID());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, UIAUTOMATOR_2);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesInfo.getInstance().getPlatformVersion());
        capabilities.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
//        capabilities.setCapability("fullReset","true"); //uninstall app
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
        capabilities.setCapability(AndroidMobileCapabilityType.SKIP_DEVICE_INITIALIZATION, "true");
        capabilities.setCapability("noReset", "true");
        LOGGER.info(capabilities.getCapabilityNames());
        try {
            driver = new AndroidDriver<>(new URL(PropertiesInfo.getInstance().getAppiumServer()), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 15);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    public WebDriverWait getWait(){
        return wait;
    }

    public static MobileManager getInstance() {
        if (instance == null) {
            instance = new MobileManager();
        }
        return instance;
    }
}
