package com.olnester.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import com.olnester.configs.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EmulatorDriver implements WebDriverProvider {
    protected static AndroidDriver driver;
    private static final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static final String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();

    private static final String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static final String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    private static final String APP = ConfigReader.emulatorConfig.app();
    private static final String URL = ConfigReader.emulatorConfig.remoteUrl();
    private static final String CHROME_DRIVER_DIR = ConfigReader.emulatorConfig.chromeDriverDir();

    public static URL getUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertThat(file.exists()).withFailMessage(() -> filePath + " not found").isTrue();

        return file.getAbsolutePath();
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        desiredCapabilities.setCapability("deviceName", DEVICE_NAME);
        desiredCapabilities.setCapability("platformName", PLATFORM_NAME);
        desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);

        desiredCapabilities.setCapability("chromedriverExecutableDir", CHROME_DRIVER_DIR);
        desiredCapabilities.setCapability("automationName", "UiAutomator2");

        desiredCapabilities.setCapability("app", getAbsolutePath(APP));

        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("timeZone", "Europe/Kiev");
        selenoidOptions.put("sessionTimeout", "1m");

        Configuration.browserCapabilities.setCapability("selenoid:options", selenoidOptions);
        capabilities.merge(desiredCapabilities);

        driver = new AndroidDriver(getUrl(), desiredCapabilities);
        return driver;
    }
}
