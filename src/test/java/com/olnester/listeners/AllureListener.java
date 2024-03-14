package com.olnester.listeners;

import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;

import java.lang.reflect.Method;

import io.qameta.allure.Attachment;

public class AllureListener implements AfterTestExecutionCallback {
    //attach screenshot to allure report
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Method testMethod = context.getRequiredTestMethod();
        String testName = testMethod.getName();
        boolean testField = context.getExecutionException().isPresent();
        if (testField) {
            if (!testName.contains("Screenshot")) {
                saveScreenshot(Selenide.screenshot(OutputType.BYTES));
            }
        }
    }
}
