package com.vmo.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    protected WebElement getWebElement(WebDriver driver, String locator) {
        By locatorBy = getLocator(locator);
        return driver.findElement(locatorBy);
    }

    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

}
