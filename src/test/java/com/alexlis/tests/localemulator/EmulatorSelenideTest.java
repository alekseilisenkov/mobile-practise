package com.alexlis.tests.localemulator;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.back;

public class EmulatorSelenideTest extends EmulatorTestBase {

    @Tag("emulator")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Getting started screen check")
    void gettingStartedTest() {
        localPages.primaryTextCheck("The Free Encyclopedia …in over 300 languages")
                .PressPrimaryForwardButton()
                .primaryTextCheck("New ways to explore")
                .PressPrimaryForwardButton()
                .primaryTextCheck("Reading lists with sync")
                .PressPrimaryForwardButton()
                .primaryTextCheck("Send anonymous data")
                .PressPrimaryDoneButton()
                .mainPageCheck();
    }

    @Tag("emulator")
    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        back();
        localPages.searchFormClick()
                .setValue("BrowserStack")
                .checkValue();
    }
}
