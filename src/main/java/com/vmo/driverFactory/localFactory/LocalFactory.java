package com.vmo.driverFactory.localFactory;

import org.openqa.selenium.WebDriver;

public class LocalFactory {
    private WebDriver driver;

    public WebDriver createDriver(String browser) {
        browser = browser.toUpperCase();
        switch (browser) {
            case "CHROME":
                driver = new ChromeDriverManagement().getBrowserDriver();
                break;
            case "EDGE":
                driver = new EdgeDriverManagement().getBrowserDriver();
                break;
            case "FIREFOX":
                driver = new FireFoxDriverManagement().getBrowserDriver();
                break;
            default:
                throw new RuntimeException("Not Support Browser " + browser);
        }
        return driver;
    }
}
