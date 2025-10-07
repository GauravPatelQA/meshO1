package com.mesh01.tests;

import com.mesh01.steps.DashboardFunctionalityStep;
import com.mesh01.steps.FeedbackFunctionalityStep;
import com.mesh01.DriverInit;
import com.mesh01.steps.LoginFunctionalityStep;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class FeedbackFunctionalityTest {
    private WebDriver driver;
    private FeedbackFunctionalityStep feedbackfunctionalitystep;
    private DashboardFunctionalityStep dashboardfunctionalitystep;
    private LoginFunctionalityStep loginfunctionalitystep;

    @BeforeClass
    public void setUp() {
        // Initialize driver using DriverInit
        DriverInit.initialization();
        driver = DriverInit.getDriverThread();
        
        feedbackfunctionalitystep = new FeedbackFunctionalityStep();
        dashboardfunctionalitystep = new DashboardFunctionalityStep();
        loginfunctionalitystep = new LoginFunctionalityStep();
    }

    @Test(description = "Feedback Functionality", priority = 3)
    public void testFeedbackFunctionality() {
        // Test Description: Test case for Feedback Functionality
        // Priority: High

        loginfunctionalitystep.navigateToPage();
        loginfunctionalitystep.step2Input("KrutarthP");
        // Step 3: 3. Enter the password-: 'Admin@1234'
        loginfunctionalitystep.step3Input("Admin@1234");
        // Step 4: 4. Click on login
        loginfunctionalitystep.step4Click();

        System.out.println("Test completed successfully: Login Functionality");

        // Verify expected result
        loginfunctionalitystep.verifyFunctionality();
        dashboardfunctionalitystep.step1Click();
        dashboardfunctionalitystep.step2Click();
        System.out.println("Test completed successfully: Dashboard Functionality ");

        feedbackfunctionalitystep.step1Action();
        
        // Test Data:
        // No test data specified
        
        // Execute test steps using step methods:
        // Step 1: 1.Select Task from the dropdown

        // Step 2: 2.Enter The 'Feedback Summary' text in the Feedback Summary field
        feedbackfunctionalitystep.step2Input("Feedback Summary");
        // Step 3: 3.Click on the Priority dropdown

        // Step 5: 5.Enter Additional details in the Details field.
        feedbackfunctionalitystep.step5Input("test-data");
        // Step 6: 6.Click on the Submit button
        feedbackfunctionalitystep.step6Click();
        
        // Verify expected result

        
        // Expected Result: Test should complete successfully
        
        System.out.println("Test completed successfully: Feedback Functionality");
    }

    @AfterClass
    public void tearDown() {
        DriverInit.quitDriver();
    }

    @AfterMethod
    public void afterMethod() {
        // Add any cleanup needed after each test method
        System.out.println("Test method completed: " + this.getClass().getSimpleName());
    }
}