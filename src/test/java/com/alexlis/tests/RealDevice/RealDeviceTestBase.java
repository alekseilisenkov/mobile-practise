package com.alexlis.tests.RealDevice;

import com.alexlis.drivers.RealDeviceDriver;
import com.alexlis.helpers.Attach;
import com.alexlis.pages.LocalPages;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class RealDeviceTestBase {

    LocalPages localPages = new LocalPages();

    @BeforeAll
    public static void setUp() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = RealDeviceDriver.class.getName();
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
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
    }
}
