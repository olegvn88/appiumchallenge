package com.olnester.cucumber.glue.definition;

import com.olnester.context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ThenStepDefinitions {
    private final TestContext testContext;

    private final List<String> expectedNativeViewDemoItems =
            List.of(
                    "Hello World, I'm View one ",
                    "Hello World, I'm View two ",
                    "Hello World, I'm View three ");

    public ThenStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("list of three view items should be displayed")
    public void listOfThreeViewItemsShouldBeDisplayed() {
        List<String> actualNativeViewDemoItems = testContext.getNativeViewDemoPage().getNativeViewDemoItems().attributes("text");
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(actualNativeViewDemoItems.size()).isEqualTo(3);
            softAssertions.assertThat(actualNativeViewDemoItems)
                          .hasSameElementsAs(expectedNativeViewDemoItems);
        });
    }

    @Then("sliders position should be at the {}")
    public void slidersPositionShouldBeAtThe(String position) {
        assertThat(testContext.getSliderPage().getSliderPosition()).isEqualTo(position);
    }

    @Then("the {} item is visible in the bottom of screen")
    public void theItemIsVisibleInTheBottomOfScreen(String item) {
        assertThat(testContext.getVerticalSwipingPage().getTheLastVisibleElement()).isEqualTo(item);
    }

    @Then("the {} text is displayed on drag and drop success screen")
    public void theTextIsDisplayedOnDragAndDropSuccessScreen(String message) {
        assertThat(testContext.getDragDropPage().getCircleDropped()).isEqualTo(message);
    }

    @Then("the {} message is displayed when double tap is succeed")
    public void theMessageIsDisplayedWhenDoubleTapIsSucceed(String message) {
        assertThat(testContext.getDoubleTapDemoPage().getDoubleTapSuccessful()).isEqualTo(message);
    }

    @Then("the {} message is displayed after long pressing")
    public void theMessageIsDisplayedAfterLongPressing(String message) {
        assertThat(testContext.getLongPressPage().getLongPressedResult()).isEqualTo(message);
    }

    @Then("the image is present")
    public void theImageIsPresent() {
        assertThat(testContext.getPhotoViewPage().isImageDisplayed()).isTrue();
    }

    @Then("the submit page on web view is displayed")
    public void theSubmitPageOnWebViewIsDisplayed() {
        assertThat(testContext.getSubmitPage().isSubmitPageDisplayed()).isTrue();
    }

    @Then("the {} item after swiping is displayed")
    public void theItemAfterSwipingIsDisplayed(String item) {
        assertThat(testContext.getCarouselPage().getSwipedItem()).isEqualTo(item);
    }

    @When("user choosing {} color from dropdown menu")
    public void userChoosingColorFromDropdownMenu(String color) {
        testContext.getWheelPickerPage().selectColor(color);
    }

    @Then("the current color is {}")
    public void theCurrentColorIs(String color) {
        assertThat(testContext.getWheelPickerPage().getCurrentColor()).isEqualTo(color);
    }
}
