package com.vmo.driverFactory.remoteBrowser;

import org.openqa.selenium.WebDriver;

public class RemoteFactory {
    public WebDriver driver;

    public WebDriver createDriver(String browser) {
        browser = browser.toUpperCase();
        switch (browser) {
            case "CHROME":
                driver = new ChromeRemoteDriverManagement().getBrowserDriver();
                break;
            case "EDGE":
                driver = new EdgeRemoteDriverManagement().getBrowserDriver();
                break;
            case "FIREFOX":
                driver = new FireFoxRemoteDriverManagement().getBrowserDriver();
            default:
                throw new RuntimeException("Not Support Browser " + browser);
        }
        return driver;
    }
}
