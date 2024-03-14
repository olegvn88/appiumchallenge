package com.olnester.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;

public class CarouselPage extends BasePage {
    private final SelenideElement carousel = $(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.View/android.view.View/android.view.View"));
    private final SelenideElement swipeThree = $(AppiumBy.xpath("//android.widget.TextView[@text='3']"));

    public CarouselPage swipeLeft(String textToSearch) {
        carousel.should(Condition.visible);
        swipeHorizontal(textToSearch);
        return this;
    }

    public String getSwipedItem() {
        return swipeThree.should(Condition.visible).getText();
    }
}
