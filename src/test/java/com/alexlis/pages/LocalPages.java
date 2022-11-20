package com.alexlis.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class LocalPages {

    private SelenideElement searchFormClick = $(MobileBy.AccessibilityId("Search Wikipedia"));
    private SelenideElement searchValueInput = $(MobileBy.id("org.wikipedia.alpha:id/search_src_text"));
    private ElementsCollection searchList = $$(MobileBy.id("org.wikipedia.alpha:id/search_container"));
    private SelenideElement mainPage = $(MobileBy.id("org.wikipedia.alpha:id/search_container"));
    private SelenideElement primaryPageText = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"));
    private SelenideElement primaryForwardButton = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    private SelenideElement primaryDoneButton = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    public LocalPages searchFormClick() {
        step("Click on search form", () -> {
            searchFormClick.click();
        });
        return this;
    }

    public LocalPages setValue(String value) {
        step("Set value on search form", () -> {
            searchValueInput.val(value);
        });
        return this;
    }

    public LocalPages checkValue() {
        step("Set value on search form", () -> {
            searchList.shouldHave(sizeGreaterThan(0));
        });
        return this;
    }

    public LocalPages mainPageCheck() {
        step("Click more button", () -> {
            mainPage.should(Condition.visible);
        });
        return this;
    }

    public LocalPages primaryTextCheck(String text) {
        step("Check primary page text", () -> {
            primaryPageText.shouldHave(Condition.text(text));
        });
        return this;
    }

    public LocalPages PressPrimaryForwardButton() {
        step("Press Next button on primary page", () -> {
            primaryForwardButton.click();
        });
        return this;
    }

    public LocalPages PressPrimaryDoneButton() {
        step("Press Next button on primary page", () -> {
            primaryDoneButton.click();
        });
        return this;
    }
}
