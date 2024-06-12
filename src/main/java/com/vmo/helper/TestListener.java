package com.vmo.helper;

import com.vmo.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("------------Test Start-------------");
    }

    @Attachment()
    public static byte[] saveScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void onTestSuccess(ITestResult result) {
        Log.info("-------" + result.getName() + "SUCCESS test---------");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);
    }

    public void onTestFailure(ITestResult result) {
        Log.info("-------" + result.getName() + "FAILURE test---------");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("---------Test Skip-------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
}

