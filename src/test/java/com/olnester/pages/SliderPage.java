package com.olnester.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;

public class SliderPage extends BasePage {
    private final SelenideElement slider = $(AppiumBy.accessibilityId("slider"));
    private final SelenideElement sliderText = $(AppiumBy.xpath("//*[@content-desc='slider']/preceding-sibling::android.widget.TextView"));

    public SliderPage moveSliderToEnd() {
        int startY = slider.should(Condition.enabled).getLocation().getY();
        int endX = slider.getSize().getWidth();
        moveSliderToPosition(slider, endX, startY);
        return this;
    }

    public String getSliderPosition() {
        return sliderText.should(Condition.appear).getText();
    }
}
