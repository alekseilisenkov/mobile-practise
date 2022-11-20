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

public class LocalMobileDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        MainConfig config = ConfigFactory.create(MainConfig.class, System.getProperties());
        String url = config.getUrl();
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Pixel_4_API_30");
        desiredCapabilities.setCapability("version", "11.0");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");

        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app",
                getAbsolutePath("src/test/resources/app/app-alpha-universal-release.apk"));

        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}