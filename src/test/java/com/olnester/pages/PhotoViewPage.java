package com.olnester.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;

public class PhotoViewPage extends BasePage {
    private final SelenideElement photoScreen = $(AppiumBy.xpath("//android.widget.ImageView"));

    public boolean isImageDisplayed() {
        return photoScreen.should(Condition.visible).isDisplayed();
    }
}
