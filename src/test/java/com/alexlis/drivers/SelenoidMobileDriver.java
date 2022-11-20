package com.alexlis.drivers;

import com.alexlis.config.MainConfig;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelenoidMobileDriver implements WebDriverProvider {

    public static URL getSelenoidServerUrl() {
        MainConfig config = ConfigFactory.create(MainConfig.class, System.getProperties());
        String url = config.getUrl();
        try {
            return new URL("https://user1:1234@selenoid.autotests.cloud:4444/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "android");
        desiredCapabilities.setCapability("version", "8.1");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);

        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app", apkUrl());

        return new AndroidDriver(getSelenoidServerUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            return new URL("https://github.com/wikimedia/apps-android-wikipedia/releases/" +
                    "download/latest/app-alpha-universal-release.apk");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
