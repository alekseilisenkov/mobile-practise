package com.alexlis.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BrowserStackMobileSelenideTest extends TestBase {

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Main page text verification")
    void checkMainPageText() {
        pages.mainPageCheck();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        pages.searchFormClick()
                .setValue("BrowserStack")
                .checkValue();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("'More' menu item text verification")
    void moreButtonTest() {
        pages.moreButtonClick()
                .moreButtonCheckForHeadText();
    }
}
