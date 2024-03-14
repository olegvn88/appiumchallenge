package com.olnester.cucumber.glue.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.olnester.helper.RunHelper;
import com.olnester.listeners.AllureListener;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.olnester.helper.Constants.SCREENSHOT_TO_SAVE_FOLDER;
import static io.qameta.allure.Allure.step;

@ExtendWith(AllureListener.class)
public class Hooks {

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.reportsFolder = SCREENSHOT_TO_SAVE_FOLDER;
        Configuration.browser = RunHelper.getDriverClass().getName();
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @Before
    public void startDriver() {
        step("Open application", (Allure.ThrowableRunnableVoid) Selenide::open);
    }

    @After
    public void afterEach() {
        step("Close application", Selenide::closeWebDriver);
    }
}
