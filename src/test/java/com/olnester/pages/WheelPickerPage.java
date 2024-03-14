package com.olnester.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class WheelPickerPage extends BasePage {
    private final SelenideElement colorMenu = $(AppiumBy.id("android:id/text1"));
    private final SelenideElement currentColor = $(AppiumBy.xpath("//android.view.View[1]/android.view.View/android.view.View/android.widget.TextView"));

    public WheelPickerPage selectColor(String color) {
        colorMenu.should(Condition.visible).click();
        SelenideElement selectedColor = $(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='" + color + "']"));
        selectedColor.should(Condition.visible).click();
        return this;
    }

    public String getCurrentColor() {
        return currentColor.should(Condition.visible).getText().trim();
    }

}
