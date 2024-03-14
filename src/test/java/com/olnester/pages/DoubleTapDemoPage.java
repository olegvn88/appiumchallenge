package com.olnester.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;

public class DoubleTapDemoPage extends BasePage {
    private final SelenideElement doubleTapSuccessful = $(AppiumBy.id("android:id/message"));

    public DoubleTapDemoPage doubleTap(String doubleTapItem) {
        doubleTap($(AppiumBy.xpath("//android.widget.TextView[@text='" + doubleTapItem + "']")));
        return this;
    }

    public String getDoubleTapSuccessful() {
        return doubleTapSuccessful.should(Condition.visible).getText();
    }
}
