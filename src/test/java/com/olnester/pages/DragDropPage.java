package com.olnester.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class DragDropPage extends BasePage {

    private final SelenideElement success = $(AppiumBy.accessibilityId("success"));

    public DragDropPage dragAndDropItem(String dragDropElement, String dropZone) {
        SelenideElement dragItem = $(AppiumBy.xpath("//*[contains(@text, '" + dragDropElement + "')]"));
        SelenideElement zone = $(AppiumBy.xpath("//*[contains(@text, '" + dropZone + "')]"));
        dragAndDrop(dragItem, zone);
        return this;
    }

    public String getCircleDropped() {
        return success.should(Condition.visible).getText();
    }
}
