package com.olnester.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class VerticalSwipingPage extends BasePage {
    private final By allVisibleItems = AppiumBy.xpath("//android.widget.ScrollView[@content-desc='listview']/android.view.View/android.view.View[*]/android.widget.TextView");

    public VerticalSwipingPage() {
        $(allVisibleItems).should(Condition.visible);
    }

    public VerticalSwipingPage swipePage(String textItem) {
        swipeVertical(textItem);
        return this;
    }

    public String getTheLastVisibleElement() {
        return $$(allVisibleItems).last().getText();
    }
}
