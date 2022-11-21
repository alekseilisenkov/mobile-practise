package com.alexlis.tests.browserstack;

import com.alexlis.tests.MainTestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BrowserStackConfigMobileSelenideTest extends MainTestBase {

    @Tag("browserstack")
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Main page text verification")
    void checkMainPageText() {
        browserStackPages.mainPageCheck();
    }

    @Tag("browserstack")
    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        browserStackPages.searchFormClick()
                .setValue("BrowserStack")
                .checkValue();
    }

    @Tag("browserstack")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("'More' menu item text verification")
    void moreButtonTest() {
        browserStackPages.moreButtonClick()
                .moreButtonCheckForHeadText();
    }
}
