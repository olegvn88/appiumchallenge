package com.olnester.cucumber.glue.definition;

import com.olnester.context.TestContext;
import io.cucumber.java.en.When;

public class WhenStepDefinitions {
    private final TestContext testContext;

    public WhenStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("user opening native view page")
    public void userOpeningNativeViewPage() {
        testContext.setNativeViewDemoPage(testContext.getSamplesListPage().openNativeView());
    }

    @When("user opening slider page")
    public void userOpeningSliderPage() {
        testContext.setSliderPage(testContext.getSamplesListPage().openSlider());
    }

    @When("setting slider to the end position")
    public void settingSliderToTheEndPosition() {
        testContext.getSliderPage().moveSliderToEnd();
    }

    @When("user opening swipe page")
    public void userOpeningSwipePage() {
        testContext.setVerticalSwipingPage(testContext.getSamplesListPage().openVerticalSwipe());
    }

    @When("user swiping the page to the {} item")
    public void userSwipingThePageToTheItem(String item) {
        testContext.getVerticalSwipingPage().swipePage(item);
    }

    @When("user opening drag and drop page")
    public void userOpeningDragAndDropPage() {
        testContext.setDragDropPage(testContext.getSamplesListPage().openDragDropPage());
    }

    @When("user drag and drop {} item to the {}")
    public void userDragAndDropItemToThe(String dragElement, String dropZone) {
        testContext.getDragDropPage().dragAndDropItem(dragElement, dropZone);
    }

    @When("user opening double tap page")
    public void userOpeningDoubleTapPage() {
        testContext.setDoubleTapDemoPage(testContext.getSamplesListPage().openDoubleTapPage());
    }

    @When("user making a double tap on {}")
    public void userMakingADoubleTapOn(String doubleTapText) {
        testContext.getDoubleTapDemoPage().doubleTap(doubleTapText);
    }

    @When("user opening long press page")
    public void userOpeningLongPressPage() {
        testContext.setLongPressPage(testContext.getSamplesListPage().openLongPressPage());
    }

    @When("user making long press on {}")
    public void userMakingLongPressOn(String item) {
        testContext.getLongPressPage().longPressMe(item);
    }

    @When("user opening photo view page")
    public void userOpeningPhotoViewPage() {
        testContext.setPhotoViewPage(testContext.getSamplesListPage().openPhotoViewPage());
    }

    @When("user opening web view")
    public void userOpeningWebView() {
        testContext.setWebViewPage(testContext.getSamplesListPage().openWebViewPage());
    }

    @When("user navigating to submit page")
    public void userNavigatingToPage() {
        testContext.setSubmitPage(testContext.getWebViewPage().navigateSubmitPage());
    }

    @When("user opening carousel page")
    public void userOpeningCarouselPage() {
        testContext.setCarouselPage(testContext.getSamplesListPage().openCarouselPage());
    }

    @When("user making horizontal left swipe to {}")
    public void userMakingHorizontalLeftSwipeTo(String textToSearch) {
        testContext.getCarouselPage().swipeLeft(textToSearch);
    }

    @When("user opening wheel picker page")
    public void userOpeningWheelPickerPage() {
        testContext.setWheelPickerPage(testContext.getSamplesListPage().openWheelPickerDemoPage());
    }
}
