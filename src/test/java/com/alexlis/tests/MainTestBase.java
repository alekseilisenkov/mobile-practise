package com.alexlis.tests;

import com.alexlis.drivers.BrowserStackMobileDriver;
import com.alexlis.drivers.EmulatorMobileDriver;
import com.alexlis.drivers.RealDeviceDriver;
import com.alexlis.drivers.SelenoidMobileDriver;
import com.alexlis.helpers.Attach;
import com.alexlis.pages.BrowserStackPages;
import com.alexlis.pages.LocalPages;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;

import static com.alexlis.helpers.Attach.getSessionId;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class MainTestBase {

    public LocalPages localPages = new LocalPages();
    public BrowserStackPages browserStackPages = new BrowserStackPages();

    @BeforeAll
    public static void setup() throws MalformedURLException {
        addListener("AllureSelenide", new AllureSelenide());

        String deviceHost = System.getProperty("deviceHost");
        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserStackMobileDriver.class.getName();
                break;
            case "selenoid":
                Configuration.browser = SelenoidMobileDriver.class.getName();
                break;
            case "emulation":
                Configuration.browser = EmulatorMobileDriver.class.getName();
                break;
            case "real":
                Configuration.browser = RealDeviceDriver.class.getName();
                break;
            default:
                throw new IllegalArgumentException("Unknown deviceHost=" + deviceHost +
                        ". Please run with parameter -DdeviceHost=[browserstack/selenoid/emulation/real]");
        }
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        String deviceHost = System.getProperty("deviceHost");
        switch (deviceHost) {
            case "browserStack":
            case "selenoid":
                String sessionId = getSessionId();
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
                closeWebDriver();
                Attach.attachVideo(sessionId);
                break;
            case "emulation":
            case "real":
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
                closeWebDriver();
                break;
            default:
                throw new IllegalArgumentException("Unknown deviceHost=" + deviceHost +
                        ". Please run with parameter -DdeviceHost=[browserstack/selenoid/emulation/real]");
        }
    }
}
