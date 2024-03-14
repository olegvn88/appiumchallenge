package com.olnester.cucumber.glue.definition;

import com.olnester.context.TestContext;
import com.olnester.pages.LoginPage;
import io.cucumber.java.en.Given;

public class GivenStepDefinitions {
    private final TestContext testContext;

    public GivenStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("user is logged to application as admin user")
    public void userIsLoggedToApplicationAsAdminUser() {
        testContext.setSamplesListPage(new LoginPage().login());
        System.out.println("application is started");
    }
}
