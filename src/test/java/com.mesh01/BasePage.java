package com.mesh01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class BasePage {

    protected WebDriver driver;
    public WebDriverWait wait;
    public static final String DIR = System.getProperty("user.dir");
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    public static int explicitWaitInSeconds = 60;
    public static int sleepDurationInMiliSeconds = 5000;
    int secondsForPageLoad = 90;

    public BasePage() {
        driver = DriverInit.getDriverThread();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitInSeconds));
    }

    public String validatePageTitle() {
        sleepForDuration();
        return driver.getTitle();
    }

    public void navigateToPage(String pageURL) {
        sleepForDuration();
        driver.get(pageURL);
    }
    
    public void sleepForDuration() {
        try {
            Thread.sleep(sleepDurationInMiliSeconds);
            logger.debug("Waiting for the next operation.");
        } catch (Exception ex) {
            logger.warn(ex.fillInStackTrace().getLocalizedMessage());
        }
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border = '3px solid blue'", element);
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: \"auto\", block: \"center\", inline: \"center\"});", element);
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border = '3px solid blue'", element);
    }

    protected void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '3px solid red'", element);
        js.executeScript("arguments[0].click();", element);
    }


    protected void click(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        sleepForDuration();
        element.click();
        logger.debug("we click element " + element);
    }

    protected void dynamicClick(String element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitInSeconds));
        WebElement SeleniumElement = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(element))));
        scrollIntoView(SeleniumElement);
        SeleniumElement.click();
        logger.debug("we click element " + element);
    }

    public void WaitTillGeneratingContract(WebElement element) {
        try {
            scrollIntoView(element);
            wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitInSeconds));
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
        }
    }

    protected void sendKeys(WebElement element, String val) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollIntoView(element);
        element.clear();
        element.sendKeys(val);
        logger.debug("we sent following string " + val + " to element " + element);
    }

    protected void sendSpecialKeys(WebElement element, Keys val) {
        scrollIntoView(element);
        element.sendKeys(val);
        logger.debug("we sent following key " + val + " to element " + element);
    }

    protected void clickbyTextindex(String element, String data, int index) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitInSeconds));
        WebElement SeleniumElement = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
                By.xpath("(" + element + "[text()='" + data + "'])[" + index + "]"))));
        scrollIntoView(SeleniumElement);
        SeleniumElement.click();
        logger.debug("we click element " + SeleniumElement);
    }

    protected String getTitleofPage() {
        String title = driver.getTitle();
        logger.debug("Title of page is " + title);
        return title;
    }

    protected void clickByText(String element, String data) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitInSeconds));
        try {
            String xpathExpression = element + "[text()='" + data + "']";
            WebElement seleniumElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            scrollIntoView(seleniumElement);
            seleniumElement.click();
            logger.debug("Clicked on element with text '{}': {}", data, seleniumElement);
        } catch (Exception e) {
            logger.error("An error occurred while clicking on element with text '{}'. Error: {}", data, e.getMessage());
            throw e;
        }
    }

    protected WebElement findVisibleAndClickableElement(String xpath) {
        logger.debug("Looking for elements with xpath " + xpath);
        List<WebElement> elements = driver.findElements(By.xpath(xpath));

        for (WebElement element : elements) {
            boolean isD = element.isDisplayed();
            boolean isCl = isClickable(element, 2);
            if (isD && isCl) {
                return element;
            } else {
                logger.debug("element is not visible/clicable " + isD + " / " + isCl + " /" + element);
            }
        }
        return null;
    }

    protected boolean isClickable(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected void switchtoiframe(String frame) {
        driver.switchTo().frame(frame);
        logger.debug("Switched to frame " + frame);
    }

    protected void switchtoiframe(WebElement frame) {
        driver.switchTo().frame(frame);
        logger.debug("Switched to frame " + frame);
    }

    public void switchToIframeByNameOrId(String expectedNameOrId) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitInSeconds));
        List<WebElement> iframes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("iframe")));

        for (WebElement iframe : iframes) {
            if (expectedNameOrId.equals(iframe.getAttribute("name")) || expectedNameOrId.equals(iframe.getAttribute("id"))) {
                driver.switchTo().frame(iframe);
                logger.debug("Switched to frame " + iframe);
            }
        }
        logger.error("No matching iframe was found.");
    }

    protected void switchtodefault() {
        driver.switchTo().defaultContent();
        logger.debug("Switched to default content");
    }

    protected String getText(WebElement element) {
        highlightElement(element);
        String str = element.getText();
        logger.debug("Get element string " + element + " String = " + str);
        return str;
    }

    protected String getValue(WebElement element) {
        highlightElement(element);
        String str = element.getAttribute("value");
        logger.debug("Get element string " + element + " String = " + str);
        return str;
    }

    protected void waitForVisiblityofobject(String element, String data) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitInSeconds));
        WebElement SeleniumElement = wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath(element + "[text()='" + data + "']"))));
        logger.debug("element Visible " + SeleniumElement);
    }

    public boolean isElementPresentAndVisible(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    protected void waitForElementBecameVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.debug("element Visible " + element);
    }

    protected void waitForPageLoad(WebElement... elements) {
        Duration dur = Duration.ofSeconds(secondsForPageLoad);
        new WebDriverWait(driver, dur).until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        try {
            new WebDriverWait(driver, dur).until(webDriver ->
                    ((JavascriptExecutor) webDriver).executeScript("return jQuery.active").toString().equals("0"));
        } catch (Exception ex) {
        }

        for (WebElement element : elements) {
            new WebDriverWait(driver, dur).until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    protected void waitForElement(WebElement webElement) {
        Duration dur = Duration.ofSeconds(explicitWaitInSeconds);

        new WebDriverWait(driver, dur).until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        try {
            new WebDriverWait(driver, dur).until(webDriver ->
                    ((JavascriptExecutor) webDriver).executeScript("return jQuery.active").toString().equals("0"));
        } catch (Exception ex) {
        }

        new WebDriverWait(driver, dur).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitForTextToDisappear(String text) {
        try {
            Duration duration = Duration.ofSeconds(explicitWaitInSeconds * 3L);
            wait = new WebDriverWait(driver, duration);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()=\"" + text + "\"]")));
            logger.debug("Waiting for the " + text + " to disappear from the page.");
        } catch (Exception e) {
            logger.error("An error occurred while waiting for the " + text + " to disappear from the page. Error: {}", e.getMessage());
            sleepForDuration();
            sleepForDuration();
        }
    }

    protected void waitForTextToAppear(String expectedText) {
        Duration duration = Duration.ofSeconds(explicitWaitInSeconds);
        wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"" + expectedText + "\"]")));
        logger.debug("Waiting for the text '" + expectedText + "' to appear on the page.");
    }

    protected WebElement findElementByExactText(String text) {
        return driver.findElement(By.xpath("//*[text()=\"" + text + "\"]"));
    }

    protected WebElement[] getElementsByXPath(String xpath) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        WebElement[] elementsArray = new WebElement[elements.size()];
        elements.toArray(elementsArray);
        return elementsArray;
    }

    public void switchToNewTab() {
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(allWindows);
        driver.switchTo().window(windowList.get(windowList.size() - 1));
        sleepForDuration();
    }

    public void actions(WebElement element) {
        Actions a = new Actions(driver);
        a.moveToElement(element).perform();
    }

    public void closebrowser() {
        driver.close();
    }
}