package com.mesh01.steps;

import com.mesh01.pages.LoginFunctionalityPage;
import io.qameta.allure.Step;
import static org.testng.Assert.*;

public class LoginFunctionalityStep extends BaseSteps {
    private LoginFunctionalityPage loginfunctionalitypage;

    public LoginFunctionalityStep() {
        this.loginfunctionalitypage = new LoginFunctionalityPage();
    }

    // Step methods with Allure annotations

    @Step("Navigate to the url -:. 'https://mesh01-new-stage.herokuapp.com/login'")
    public void step1Navigate() {
        loginfunctionalitypage.waitForPageLoad();
        logMessageWithScreenshot("Navigate to the url -:. 'https://mesh01-new-stage.herokuapp.com/login'");
    }

    @Step("Enter the username -: 'KrutarthP'")
    public void step2Input(String value) {
        loginfunctionalitypage.waitForPageLoad();
       loginfunctionalitypage.entermeshUsername(value);
        logMessageWithScreenshot("Enter the username -: 'KrutarthP'");
        
    }

    @Step("Enter the password-: 'Admin@1234'")
    public void step3Input(String value) {
        loginfunctionalitypage.waitForPageLoad();
        loginfunctionalitypage.entermeshPassword(value);
        logMessageWithScreenshot("Enter the password-: 'Admin@1234'");



    }

    @Step("Click on login")
    public void step4Click() {
        loginfunctionalitypage.waitForPageLoad();
        loginfunctionalitypage.clickLoginButton4();
        logMessageWithScreenshot("Click on login");
    }

    @Step("Navigate to Login Functionality page")
    public void navigateToPage() {
        loginfunctionalitypage.navigateToPage();
        logMessageWithScreenshot("Navigate to Login Functionality page");
    }

    @Step("Verify Login Functionality functionality")
    public void verifyFunctionality() {
        // Verify expected result: Test should complete successfully
        String pageTitle = loginfunctionalitypage.validatePageTitle();
        assertNotNull(pageTitle, "Page title should not be null");
        logMessageWithScreenshot("Verify Login Functionality functionality");
    }
}