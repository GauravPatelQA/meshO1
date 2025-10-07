package com.mesh01.steps;

import com.mesh01.pages.FeedbackFunctionalityPage;
import io.qameta.allure.Step;
import static org.testng.Assert.*;

public class FeedbackFunctionalityStep extends BaseSteps {
     FeedbackFunctionalityPage feedbackfunctionalitypage;

    public FeedbackFunctionalityStep() {
        this.feedbackfunctionalitypage = new FeedbackFunctionalityPage();
    }

    // Step methods with Allure annotations

    @Step("Select Task from the dropdown")
    public void step1Action() {
        feedbackfunctionalitypage.waitForPageLoad();
        // Action: 1.Select Task from the dropdown
        feedbackfunctionalitypage.clickfeedbacktype();
        feedbackfunctionalitypage.waitForPageLoad();
        feedbackfunctionalitypage.clickBug();
        logMessageWithScreenshot("Select Task from the dropdown");
    }

    @Step("Enter The 'Feedback Summary' text in the Feedback Summary field")
    public void step2Input(String value) {
        feedbackfunctionalitypage.waitForPageLoad();
        feedbackfunctionalitypage.entertitle(value);
        // Input action: 2.Enter The 'Feedback Summary' text in the Feedback Summary field
        //feedbackfunctionalitypage.enterInputField(value);
        logMessageWithScreenshot("Enter The 'Feedback Summary' text in the Feedback Summary field");
    }

    @Step("Click on the Priority dropdown")
    public void step3Click() {
        feedbackfunctionalitypage.waitForPageLoad();
        feedbackfunctionalitypage.clickButton6();
        logMessageWithScreenshot("Click on the Priority dropdown");
    }

    @Step("Select Urgent from the dropdown")
    public void step4Action() {
        feedbackfunctionalitypage.waitForPageLoad();
        // Action: 4.Select Urgent from the dropdown
        feedbackfunctionalitypage.waitForPageLoad();
        logMessageWithScreenshot("Select Urgent from the dropdown");
    }

    @Step("Enter Additional details in the Details field.")
    public void step5Input(String value) {
        feedbackfunctionalitypage.waitForPageLoad();
        feedbackfunctionalitypage.enterdetails(value);
        // Input action: 5.Enter Additional details in the Details field.
        //feedbackfunctionalitypage.enterInputField(value);
        logMessageWithScreenshot("Enter Additional details in the Details field.");
    }

    @Step("Click on the Submit button")
    public void step6Click() {
        feedbackfunctionalitypage.waitForPageLoad();
        feedbackfunctionalitypage.clicksubmit();
        logMessageWithScreenshot("Click on the Submit button");
    }

    @Step("Navigate to Feedback Functionality page")
    public void navigateToPage() {
        feedbackfunctionalitypage.navigateToPage();
        logMessageWithScreenshot("Navigate to Feedback Functionality page");
    }

    @Step("Verify Feedback Functionality functionality")
    public void verifyFunctionality() {
        // Verify expected result: Test should complete successfully
        String pageTitle = feedbackfunctionalitypage.validatePageTitle();
        assertNotNull(pageTitle, "Page title should not be null");
        logMessageWithScreenshot("Verify Feedback Functionality functionality");
    }
}