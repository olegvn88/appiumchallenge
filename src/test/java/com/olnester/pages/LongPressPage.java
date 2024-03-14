package com.olnester.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class LongPressPage extends BasePage {
    private final SelenideElement longPressedResult = $(AppiumBy.id("android:id/message"));

    public LongPressPage longPressMe(String item) {
        longPress($(AppiumBy.xpath("//android.widget.TextView[@text='" + item + "']")));
        return this;
    }

    public String getLongPressedResult() {
        return longPressedResult.should(Condition.visible).getText();
    }
}
