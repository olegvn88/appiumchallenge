package com.olnester.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;

public class SubmitPage extends WebViewPage {
    private final SelenideElement login = $(AppiumBy.xpath("//android.view.View[@content-desc='You have to be logged in to submit.Login']"));

    public Boolean isSubmitPageDisplayed() {
        return login.should(Condition.visible).isDisplayed();
    }
}
