package com.olnester.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.NoSuchContextException;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.DragAndDropOptions.DragAndDropMethod.ACTIONS;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class BasePage {
    private final SelenideElement backButton = $(AppiumBy.id("menu_profile"));

    protected WebDriver driver = webdriver().driver().getWebDriver();

    protected Actions actions = new Actions(driver);

    public void backButton() {
        backButton.should(Condition.enabled).click();
    }

    protected static void scrollAndClick(String text) {
        String uiAutomatorText = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))";
        $(AppiumBy.androidUIAutomator(uiAutomatorText))
                .click();
    }

    protected void moveSliderToPosition(SelenideElement element, int endX, int endY) {
        actions.clickAndHold(element).moveByOffset(endX, endY).release().perform();
    }

    protected void dragAndDrop(SelenideElement dragAndDropElement, SelenideElement dropzone) {
        DragAndDropOptions.DragAndDropTarget.Element element = new DragAndDropOptions.DragAndDropTarget.Element(dropzone);
        DragAndDropOptions options = new DragAndDropOptions(element, ACTIONS);
        dragAndDropElement.should(Condition.visible).dragAndDrop(options);
    }

    protected void doubleTap(SelenideElement element) {
        element.should(Condition.visible);
        actions.click(element).click(element).perform();
    }

    protected void longPress(SelenideElement element) {
        element.should(Condition.visible);
        actions.clickAndHold(element).perform();
    }

    protected void changeContext(String newContext) {
        String context = ((SupportsContextSwitching) driver).getContextHandles().stream()
                                                            .filter(con -> con.contains(newContext)).findFirst()
                                                            .orElseThrow(() -> new NoSuchContextException("Context not found"));
        ((SupportsContextSwitching) driver).context(context);
        String context1 = ((SupportsContextSwitching) driver).getContext();
        System.out.println("The current context is " + context1);
    }

    protected static void swipeHorizontal(String textToSearch) {
        String uiAutomatorText = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).setAsHorizontalList().scrollBackward(5).setMaxSearchSwipes(1).scrollIntoView(new UiSelector().text(\"" + textToSearch + "\"))";
        $(AppiumBy.androidUIAutomator(uiAutomatorText)).click();
    }
}
