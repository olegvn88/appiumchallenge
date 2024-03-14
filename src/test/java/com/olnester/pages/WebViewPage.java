package com.olnester.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.SupportsContextSwitching;

import static com.codeborne.selenide.Selenide.$;

public class WebViewPage extends BasePage {
    private final SelenideElement submit = $(AppiumBy.accessibilityId("submit"));

    public SubmitPage navigateSubmitPage() {
        String context1 = ((SupportsContextSwitching) driver).getContext();
        System.out.println("The current context is " + context1);
        submit.should(Condition.visible).click();
        return new SubmitPage();
    }
}
