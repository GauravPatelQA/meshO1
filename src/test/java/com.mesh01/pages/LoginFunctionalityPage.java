package com.mesh01.pages;

import com.mesh01.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginFunctionalityPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(LoginFunctionalityPage.class);
    private static final String PAGE_URL = "https://mesh01-new-uat-236c653b4b91.herokuapp.com/";

    public LoginFunctionalityPage() {
        PageFactory.initElements(driver, this);
    }

    // WebElement declarations
    @FindBy(id = "mesh-username")
    WebElement meshusername;
    @FindBy(id = "mesh-password")
    WebElement meshpassword;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//*[@id='main-content']//span[text()='UsernameField2']")
    WebElement usernamefield2;
    @FindBy(xpath = "//*[@id='main-content']//span[text()='PasswordField3']")
    WebElement passwordfield3;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginbutton4;

    public void waitForPageLoad() {
        sleepForDuration();
    }

    public void navigateToPage() {
        navigateToPage(PAGE_URL);
    }

    // Click methods for buttons and links (using BasePage.click)
    public void clickLoginButton4() {
        click(loginbutton4);
    }

    // Input methods for form fields (using BasePage.sendKeys)
    public void entermeshUsername(String value) {
        sendKeys(meshusername, value);
    }

    public void entermeshPassword(String value) {
        sendKeys(meshpassword, value);
    }

    public void enteremail(String value) {
        sendKeys(email, value);
    }

    public void enterpassword(String value) {
        sendKeys(password, value);
    }

    public void enterUsernameField2(String value) {
        sendKeys(usernamefield2, value);
    }

    public void enterPasswordField3(String value) {
        sendKeys(passwordfield3, value);
    }

    // Get text methods for text elements (using BasePage.getText)

}