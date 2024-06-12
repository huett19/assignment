package com.vmo.driverFactory.localFactory;

import com.vmo.driverFactory.IBrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverManagement implements IBrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        return new FirefoxDriver();
    }
}
