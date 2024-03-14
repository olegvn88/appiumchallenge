package com.olnester.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class SamplesListPage extends BasePage {
    private final SelenideElement nativeViewItem = $(AppiumBy.xpath("//*[@content-desc='chainedView']"));
    private final SelenideElement slider = $(AppiumBy.xpath("//*[@content-desc='slider1']"));
    private final SelenideElement verticalSwiping = $(AppiumBy.xpath("//*[@content-desc='verticalSwipe']"));
    private final SelenideElement dragAndDrop = $(AppiumBy.xpath("//android.widget.TextView[@content-desc='dragAndDrop']"));
    private final SelenideElement doubleTap = $(AppiumBy.xpath("//android.widget.TextView[@content-desc='doubleTap']"));
    private final SelenideElement longPress = $(AppiumBy.xpath("//android.widget.TextView[@content-desc='longPress']"));
    private final SelenideElement photoView = $(AppiumBy.xpath("//android.widget.TextView[@content-desc='photoView']"));
    private final SelenideElement webView = $(AppiumBy.xpath("//android.widget.TextView[@content-desc='webView']"));
    private final SelenideElement carousel = $(AppiumBy.xpath("//android.widget.TextView[@content-desc='carousel']"));
    private final SelenideElement wheelPicker = $(AppiumBy.xpath("//android.widget.TextView[@content-desc='wheelPicker']"));

    public NativeViewDemoPage openNativeView() {
        nativeViewItem.should(Condition.visible).click();
        return new NativeViewDemoPage();
    }

    public SliderPage openSlider() {
        slider.should(Condition.visible).click();
        return new SliderPage();
    }

    public VerticalSwipingPage openVerticalSwipe() {
        verticalSwiping.should(Condition.visible).click();
        return new VerticalSwipingPage();
    }

    public DragDropPage openDragDropPage() {
        dragAndDrop.should(Condition.visible).click();
        return new DragDropPage();
    }

    public DoubleTapDemoPage openDoubleTapPage() {
        doubleTap.should(Condition.visible).click();
        return new DoubleTapDemoPage();
    }

    public LongPressPage openLongPressPage() {
        longPress.should(Condition.visible).click();
        return new LongPressPage();
    }

    public PhotoViewPage openPhotoViewPage() {
        photoView.should(Condition.visible).click();
        return new PhotoViewPage();
    }

    public WebViewPage openWebViewPage() {
        scrollAndClick("Web View");
//        webView.should(Condition.visible).click();
        return new WebViewPage();
    }

    public CarouselPage openCarouselPage() {
        scrollAndClick("Carousel");
//        carousel.should(Condition.visible).click();
        return new CarouselPage();
    }

    public WheelPickerPage openWheelPickerDemoPage() {
        scrollAndClick("Wheel Picker");
//        wheelPicker.should(Condition.visible).click();
        return new WheelPickerPage();
    }
}
