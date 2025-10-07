package com.mesh01.tests;

import com.mesh01.steps.LoginFunctionalityStep;
import com.mesh01.DriverInit;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class LoginFunctionalityTest {
    private WebDriver driver;
    private LoginFunctionalityStep loginfunctionalitystep;

    @BeforeClass
    public void setUp() {
        // Initialize driver using DriverInit
        DriverInit.initialization();
        driver = DriverInit.getDriverThread();
        
        loginfunctionalitystep = new LoginFunctionalityStep();
    }

    @Test(description = "Login Functionality", priority = 3)
    public void testLoginFunctionality() {
        // Test Description: Test case for Login Functionality
        // Priority: High
        
        loginfunctionalitystep.navigateToPage();
        
        // Test Data:
        // No test data specified
        
        // Execute test steps using step methods:
        // Step 1: 1. Navigate to the url -:. 'https://mesh01-new-stage.herokuapp.com/login'
    
        // Step 2: 2. Enter the username -: 'KrutarthP'
        loginfunctionalitystep.step2Input("KrutarthP");
        // Step 3: 3. Enter the password-: 'Admin@1234'
        loginfunctionalitystep.step3Input("Admin@1234");
        // Step 4: 4. Click on login
        loginfunctionalitystep.step4Click();
        
        // Verify expected result
        loginfunctionalitystep.verifyFunctionality();
        
        // Expected Result: Test should complete successfully
        
        System.out.println("Test completed successfully: Login Functionality");
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