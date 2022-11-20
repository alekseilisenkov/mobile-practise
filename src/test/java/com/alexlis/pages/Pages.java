package com.alexlis.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class Pages {

    private SelenideElement searchFormClick = $(MobileBy.AccessibilityId("Search Wikipedia"));
    private SelenideElement searchValueInput = $(MobileBy.id("org.wikipedia.alpha:id/search_src_text"));
    private ElementsCollection searchList = $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"));
    private SelenideElement moreButton = $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button"));
    private SelenideElement moreButtonMenuHeadText = $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_account_name"));
    private SelenideElement mainPage = $(MobileBy.id("org.wikipedia.alpha:id/view_card_header_title"));

    public Pages searchFormClick() {
        step("Click on search form", () -> {
            searchFormClick.click();
        });
        return this;
    }

    public Pages setValue(String value) {
        step("Set value on search form", () -> {
            searchValueInput.val(value);
        });
        return this;
    }

    public Pages checkValue() {
        step("Set value on search form", () -> {
            searchList.shouldHave(sizeGreaterThan(0));
        });
        return this;
    }

    public Pages moreButtonClick() {
        step("Click more button", () -> {
            moreButton.click();
        });
        return this;
    }

    public Pages moreButtonCheckForHeadText() {
        step("Click more button", () -> {
            moreButtonMenuHeadText.shouldHave(Condition.text("Log in to Wikipedia"));
        });
        return this;
    }

    public Pages mainPageCheck() {
        step("Click more button", () -> {
            mainPage.shouldHave(Condition.text("In the news"));
        });
        return this;
    }
}
