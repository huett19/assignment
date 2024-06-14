package com.vmo.common;

import com.vmo.driverFactory.localFactory.LocalFactory;
import com.vmo.driverFactory.remoteBrowser.RemoteFactory;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BaseTest {
    private WebDriver driver;

    public WebDriver getBrowserDriver(String browser, String modeRun) {
        if (modeRun.equals("remote")) {
            driver = new RemoteFactory().createDriver(browser);
        }
        if (modeRun.equals("local")) {
            driver = new LocalFactory().createDriver(browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void cleanAllBrowsers() {
        String osName = System.getProperty("os.name");
        String driverName = driver.toString().toLowerCase();
        try {
            String cmd;
            if (driverName.contains("chrome")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                    executeCommand(cmd);
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /IM chrome.exe /T";
                    executeCommand(cmd);
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                    executeCommand(cmd);
                }
            }
            if (driverName.contains("firefox")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill geckodriver";
                    executeCommand(cmd);
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /IM firefox.exe /T";
                    executeCommand(cmd);
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                    executeCommand(cmd);
                }
            } else if (driverName.contains("safari")) {
                cmd = "pkill safaridriver";
                executeCommand(cmd);
            }
        } catch (Exception e) {
            System.err.println("e = " + e);
        }

    }

    private static void executeCommand(String cmd) throws InterruptedException, IOException {
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
    }
}
