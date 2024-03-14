package com.olnester.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class NativeViewDemoPage extends BasePage {
    private final SelenideElement nativeViewDemo = $(AppiumBy.xpath("//android.widget.TextView[@text='Native View Demo']"));
    private final ElementsCollection nativeViewDemoItems = $$(AppiumBy.xpath("//*[@content-desc='textView']"));

    public ElementsCollection getNativeViewDemoItems() {
        nativeViewDemo.should(Condition.appear);
        return nativeViewDemoItems;
    }
}
