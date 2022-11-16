package com.alexlis.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BrowserStackMobileSelenideTest extends TestBase {

    @Tag("selenide_android")
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Main page text verification")
    void checkMainPageText() {
        pages.mainPageCheck();
    }

    @Tag("selenide_android")
    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        pages.searchFormClick()
                .setValue("BrowserStack")
                .checkValue();
    }

    @Tag("selenide_android")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("'More' menu item text verification")
    void moreButtonTest() {
        pages.moreButtonClick()
                .moreButtonCheckForHeadText();
    }
}
