package com.vmo.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;
    private long longTimeOut = GlobalConstants.LONG_TIMEOUT;
    private Alert alert;

    private WebDriverWait explicit;
    private Select select;
    private JavascriptExecutor jsExecutor;
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    protected void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    protected By getLocator(String locator) {
        String[] locatorSplit = locator.split(":=");
        String typeLocator = locatorSplit[0].toUpperCase();
        switch (typeLocator) {
            case "XPATH":
                return By.xpath(locatorSplit[1]);
            case "CSS":
                return By.cssSelector(locatorSplit[1]);
            case "NAME":
                return By.name(locatorSplit[1]);
            case "CLASS":
                return By.className(locatorSplit[1]);
            default:
                throw new RuntimeException("Not support type locator " + typeLocator);
        }
    }

    public String getDynamicLocator(String locator, String... params) {
        return String.format(locator, (Object[]) params);
    }

    protected WebElement getWebElement(WebDriver driver, String locator) {
        By locatorBy = getLocator(locator);
        return driver.findElement(locatorBy);
    }

    protected String getText(WebDriver driver, String locator) {
        By locatorBy = getLocator(locator);
        return driver.findElement(locatorBy).getText();
    }

    protected String getText(WebDriver driver, String locator, String... params) {
        return getWebElement(driver, getDynamicLocator(locator, params)).getText();
    }

    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... params) {
        getWebElement(driver, getDynamicLocator(locator, params)).click();
    }

    protected void sendKeysToElement(WebDriver driver, String locator, String value) {
        getWebElement(driver, locator).clear();
        getWebElement(driver, locator).sendKeys(value);
    }

    protected void sendKeysToElement(WebDriver driver, String locator, String... params) {
        locator = getDynamicLocator(locator, params);
        getWebElement(driver, locator).clear();
        getWebElement(driver, locator).sendKeys(params);
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    public boolean isElementSelected(WebDriver driver, String locator, String... params) {
        locator = getDynamicLocator(locator, params);
        return getWebElement(driver, locator).isSelected();
    }

    public void checkToDefaultCheckboxOrDefaultRadio(WebDriver driver, String locator) {

        if (!isElementSelected(driver, locator)) {
            clickToElement(driver, locator);
        }
    }

    public void checkToDefaultCheckboxOrDefaultRadio(WebDriver driver, String locator, String... params) {
        if (!isElementSelected(driver, locator, params)) {
            clickToElement(driver, locator, params);
        }
    }

    protected void waitForElementSelected(WebDriver driver, String locator) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.elementToBeSelected(getLocator(locator)));
    }

    protected void waitForElementClickable(WebDriver driver, String locator) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.elementToBeClickable(getLocator(locator)));
    }

    protected void waitForElementInvisible(WebDriver driver, String locator) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locator)));
    }

    public String getAttributeElement(WebDriver driver, String locator, String attributeName) {
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    public String getAttributeElement(WebDriver driver, String locator, String attributeName, String... params) {
        locator = getDynamicLocator(locator, params);
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

}
