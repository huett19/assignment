package com.vmo.demowebshop.pageObject;

import com.vmo.common.BasePage;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import com.vmo.helper.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openDemoWebShop() {
        Log.allure("Get to site: https://demowebshop.tricentis.com/");
        openUrl(driver, "https://demowebshop.tricentis.com/");
    }

    public void verifyHomePageTitle() {
        Log.allure("Verify Home Page Title");
        Assert.assertEquals(getTitlePage(),LoginPageUI.PAGE_TITLE);
    }

    public String getTitlePage() {
        Log.allure("Get Title Page");
        return driver.getTitle();
    }

    public void clickLoginTag() {
        Log.allure("Click login tag");
        clickToElement(driver, LoginPageUI.LOGIN_TAG);
    }

    public void clickLoginBtn() {
        Log.allure("Click login button");
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
    }


}
