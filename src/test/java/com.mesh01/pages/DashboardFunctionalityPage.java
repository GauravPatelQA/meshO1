package com.mesh01.pages;

import com.mesh01.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DashboardFunctionalityPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(DashboardFunctionalityPage.class);
    private static final String PAGE_URL = "application-url";

    public DashboardFunctionalityPage() {
        PageFactory.initElements(driver, this);
    }

    // WebElement declarations
    @FindBy(xpath = "//*[@id='main-content']//span[text()='MainContent']")
    WebElement maincontent;
    ///---Changes in xpath as its not taking when sending in DOM
    @FindBy(xpath = "//span[normalize-space()='Feedback']")
    WebElement actionbutton;
    @FindBy(xpath="//button[@class='mat-mdc-menu-trigger btn btn-transparent text-uppercase fw-semibold nav-link ps-2']")
    WebElement profile;

    //////////////////////
    @FindBy(xpath = "//*[@id='main-content']//span[text()='InputField']")
    WebElement inputfield;

    public void waitForPageLoad() {
        sleepForDuration();
        super.waitForElement(profile);
    }

    public void navigateToPage() {
        navigateToPage(PAGE_URL);
    }

    // Click methods for buttons and links (using BasePage.click)
    public void clickActionButton() {
        click(actionbutton);
    }

    public void clickProfile() {
        click(profile);
    }

    // Input methods for form fields (using BasePage.sendKeys)
    public void enterInputField(String value) {
        sendKeys(inputfield, value);
    }

    // Get text methods for text elements (using BasePage.getText)
    public String getMainContentText() {
        return getText(maincontent);
    }
}