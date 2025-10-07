package com.mesh01.steps;

import com.mesh01.pages.DashboardFunctionalityPage;
import io.qameta.allure.Step;
import static org.testng.Assert.*;

public class DashboardFunctionalityStep extends BaseSteps {
    private DashboardFunctionalityPage dashboardfunctionalitypage;

    public DashboardFunctionalityStep() {
        this.dashboardfunctionalitypage = new DashboardFunctionalityPage();
    }

    // Step methods with Allure annotations

    @Step("Click on the Profile dropdown.")
    public void step1Click() {
        dashboardfunctionalitypage.waitForPageLoad();
        dashboardfunctionalitypage.clickProfile();
        logMessageWithScreenshot("Click on the Profile dropdown.");
    }

    @Step("Click on Feedback")
    public void step2Click() {
        dashboardfunctionalitypage.waitForPageLoad();
        dashboardfunctionalitypage.clickActionButton();
        logMessageWithScreenshot("Click on Feedback");
    }

    @Step("Navigate to Dashboard Functionality  page")
    public void navigateToPage() {
        dashboardfunctionalitypage.navigateToPage();
        logMessageWithScreenshot("Navigate to Dashboard Functionality  page");
    }

    @Step("Verify Dashboard Functionality  functionality")
    public void verifyFunctionality() {
        // Verify expected result: Test should complete successfully
        String pageTitle = dashboardfunctionalitypage.validatePageTitle();
        assertNotNull(pageTitle, "Page title should not be null");
        logMessageWithScreenshot("Verify Dashboard Functionality  functionality");
    }
}