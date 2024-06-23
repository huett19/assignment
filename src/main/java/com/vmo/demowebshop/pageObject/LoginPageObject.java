package com.vmo.demowebshop.pageObject;

import com.vmo.common.BasePage;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import com.vmo.helper.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
    By emailTxt = By.xpath("//input[@id='Email']");
    By passwordTxt = By.xpath("//input[@id='Password']");
    By loginBtn = By.xpath("//input[contains(@class,'login-button')]");
    By actualMsg = By.xpath("//div[@class='validation-summary-errors']/ul/li");

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openDemoWebShop() {
        Log.allure("Get To Site: https://demowebshop.tricentis.com/");
        openUrl(driver, "https://demowebshop.tricentis.com/");
    }

    public void verifyHomePageTitle() {
        Log.allure("Verify Home Page Title");
        Assert.assertEquals(getTitlePage(), LoginPageUI.PAGE_TITLE);
    }

    public String getTitlePage() {
        Log.allure("Get Title Page");
        return driver.getTitle();
    }

    public void clickLoginTag() {
        Log.allure("Click Login Tag");
        waitForElementClickable(driver, LoginPageUI.LOGIN_TAG);
        clickToElement(driver, LoginPageUI.LOGIN_TAG);
    }

    public void verifyLoginPageTitle() {
        Log.allure("Verify Login Page Title");
        Assert.assertEquals(getTitlePage(), LoginPageUI.LOGIN_PAGE_TITLE);
    }

    public void setEmail(String Username) {
        Log.allure("Fill Username");
        waitForElementClickable(driver, LoginPageUI.EMAIL_TXT);
        driver.findElement(emailTxt).sendKeys(Username);
    }

    public void setPassword(String Password) {
        Log.allure("Fill Password");
        waitForElementClickable(driver, LoginPageUI.PASSWORD_TXT);
        driver.findElement(passwordTxt).sendKeys(Password);
    }

    public void clickLogin() {
        Log.allure("Click Login Button");
        waitForElementClickable(driver, LoginPageUI.LOGIN_BTN);
        driver.findElement(loginBtn).click();
    }

    public String getLoginSuccessMessage() {
        Log.allure("Get Message After Login");
        waitForElementVisible(driver, LoginPageUI.MESSAGE);
        return driver.findElement(actualMsg).getText();
    }

    public void verifyAfterLogin(String message) {
        Log.allure("Verify Message After Login");
        String actualMessage = driver.findElement(actualMsg).getText();
        Assert.assertEquals(actualMessage, message);
    }
}
