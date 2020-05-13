package com.pivotal.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is going to handle all the properties that are set on the gradle.properties file.
 */
public final class PropertiesInfo {
    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class.getSimpleName());
    private static final String CONFIG_PROPERTIES = "gradle.properties";
    private static final String URL = "url";
    private static final String BROWSER = "browser";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String EMULATOR_NAME = "emulatorName";
    private static final String APPIUM_SERVER = "appiumServer";
    private static final String EMULATOR_ID = "emulatorID";
    private static final String PLATFORM_VERSION = "platformVersion";

    private static PropertiesInfo instance;
    private Properties properties;

    private PropertiesInfo() {
        loadProperties();
    }

    /**
     * This method is going to retrieve just one instance of the PropertiesInfo class.
     *
     * @return PropertiesInfo instance.
     */
    public static PropertiesInfo getInstance() {
        if (instance == null) {
            instance = new PropertiesInfo();
        }
        return instance;
    }

    /**
     * This method is going to load properties file.
     */
    private void loadProperties() {
        try {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(CONFIG_PROPERTIES);
                properties = new Properties();
                properties.load(fileInputStream);
            } finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.warn("The properties file couldn't be found", e);
        } catch (IOException e) {
            LOGGER.warn("A problem of type", e);
        }
    }

    /**
     * This method is going to retrieve the required property.
     *
     * @param propertyKey to be used.
     * @return value of the propertyKey.
     */
    private String getProperty(String propertyKey) {
        String propertyValue = System.getProperty(propertyKey);
        if (propertyValue == null) {
            propertyValue = properties.getProperty(propertyKey);
        }
        return propertyValue;
    }

    /**
     * This method retrieves the URL of the WebApplication to be used.
     *
     * @return the url of the WebApplication.
     */
    public String getUrl() {
        return getProperty(URL);
    }

    /**
     * This method retrieves the name of the WebBrowser to be used.
     *
     * @return the name of the WebBrowser.
     */
    public String getBrowser() {
        return getProperty(BROWSER);
    }

    public String getEmail() {
        return getProperty(EMAIL);
    }

    public String getPassword() {
        return getProperty(PASSWORD);
    }

    public String emulatorName() {
        return getProperty(EMULATOR_NAME);
    }

    public String getAppiumServer() {
        return getProperty(APPIUM_SERVER);
    }

    public String getEmulatorID() {
        return getProperty(EMULATOR_ID);
    }

    public String getPlatformVersion() {
        return getProperty(PLATFORM_VERSION);
    }
}
