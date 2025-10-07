package com.mesh01.tests;

import com.mesh01.steps.DashboardFunctionalityStep;
import com.mesh01.DriverInit;
import com.mesh01.steps.LoginFunctionalityStep;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class DashboardFunctionalityTest {
    private WebDriver driver;
    private DashboardFunctionalityStep dashboardfunctionalitystep;
    private LoginFunctionalityStep loginfunctionalitystep;

    @BeforeClass
    public void setUp() {
        // Initialize driver using DriverInit
        DriverInit.initialization();
        driver = DriverInit.getDriverThread();

        
        dashboardfunctionalitystep = new DashboardFunctionalityStep();
        loginfunctionalitystep = new LoginFunctionalityStep();
    }

    @Test(description = "Dashboard Functionality ", priority = 3)
    public void testDashboardFunctionality() {
        // Test Description: Test case for Dashboard Functionality 
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

        // Expected Result: Test should complete successfully


        
        // Expected Result: Test should complete successfully
        

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