package com.olnester.cucumber.glue.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.olnester.helper.RunHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.olnester.helper.Constants.SCREENSHOT_TO_SAVE_FOLDER;

public class Hooks {

    @BeforeAll
    public static void setup() {
        Configuration.reportsFolder = SCREENSHOT_TO_SAVE_FOLDER;
        Configuration.browser = RunHelper.getDriverClass().getName();
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
    }

    @Before
    public void startDriver() {
        Selenide.open();
    }

    @After
    public void afterEach(Scenario scenario) {
        if (scenario.isFailed()) {
            String fileName = scenario.getName() + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            screenshot(fileName);
        }
        Selenide.closeWebDriver();
    }
}
