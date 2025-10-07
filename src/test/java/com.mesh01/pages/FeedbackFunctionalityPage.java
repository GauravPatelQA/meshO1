package com.mesh01.pages;

import com.mesh01.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FeedbackFunctionalityPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(FeedbackFunctionalityPage.class);
    private static final String PAGE_URL = "application-url";

    public FeedbackFunctionalityPage() {
        PageFactory.initElements(driver, this);
    }

    // WebElement declarations
    @FindBy(id = "feedbackType")
    WebElement feedbacktype;
    @FindBy(id = "mat-mdc-error-0")
    WebElement matmdcerror0;
    @FindBy(id = "title")
    WebElement title;
    @FindBy(id = "mat-mdc-error-1")
    WebElement matmdcerror1;
    @FindBy(id = "mat-mdc-error-2")
    WebElement matmdcerror2;
    @FindBy(id = "mat-mdc-error-3")
    WebElement matmdcerror3;
    @FindBy(id = "priority")
    WebElement priority;
    @FindBy(id = "details")
    WebElement details;
    @FindBy(name = "feedbackTitle")
    WebElement feedbacktitle;
    @FindBy(name = "file")
    WebElement file;
    @FindBy(xpath = "//*[@id='main-content']//span[text()='DropdownMenu1']")
    WebElement dropdownmenu1;
    @FindBy(xpath = "//*[@id='main-content']//span[text()='DropdownMenu4']")
    WebElement dropdownmenu4;
    @FindBy(xpath = "//*[@id='main-content']//span[text()='Button6']")
    WebElement button6;
    @FindBy(xpath = "//*[@id='main-content']//span[text()='SubmitButton6']")
    WebElement submitbutton6;

    @FindBy(xpath="//span[@title='Bug']")
    WebElement Bug;

    @FindBy(xpath="//span[@title='Urgent']")
    WebElement urgent;

    @FindBy(xpath="//button[@type='submit']")
    WebElement submit;

    public void waitForPageLoad() {
        sleepForDuration();
    }

    public void navigateToPage() {
        navigateToPage(PAGE_URL);
    }

    // Click methods for buttons and links (using BasePage.click)
    public void clickButton6() {
        click(button6);
    }

    public void clickSubmitButton6() {
        click(submitbutton6);
    }

    //--click feedbacktype----bug
    public void clickfeedbacktype() {
        click(feedbacktype);
    }

    public void clickBug() {
        click(Bug);
    }

    public void clickurgent() {
        click(urgent);
    }

    // Input methods for form fields (using BasePage.sendKeys)
    public void entertitle(String value) {
        sendKeys(title, value);
    }

    public void enterdetails(String value) {
        sendKeys(details, value);
    }

    public void clicksubmit() {
        click(submit);
    }

    public void enterfeedbackTitle(String value) {
        sendKeys(feedbacktitle, value);
    }

    public void enterfile(String value) {
        sendKeys(file, value);
    }

    // Get text methods for text elements (using BasePage.getText)
    public String getfeedbackTypeText() {
        return getText(feedbacktype);
    }

    public String getmatMdcError0Text() {
        return getText(matmdcerror0);
    }

    public String getmatMdcError1Text() {
        return getText(matmdcerror1);
    }

    public String getmatMdcError2Text() {
        return getText(matmdcerror2);
    }

    public String getmatMdcError3Text() {
        return getText(matmdcerror3);
    }

    public String getpriorityText() {
        return getText(priority);
    }
}