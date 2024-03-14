package com.olnester.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private final SelenideElement loginButton = $(AppiumBy.xpath("//android.widget.TextView[@text='LOG IN']"));

    public SamplesListPage login() {
        loginButton.should(Condition.visible).click();
        return new SamplesListPage();
    }
}
