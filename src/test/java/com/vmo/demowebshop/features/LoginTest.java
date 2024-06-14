package com.vmo.demowebshop.features;

import com.vmo.common.BaseTest;
import com.vmo.demowebshop.pageObject.LoginPageObject;
import com.vmo.helper.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

@Epic("Demo Web Shop")
@Feature("Login")
@Story("Login with Excel file")
@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPageObject;

    @BeforeClass
    @Parameters({"browser", "modeRun"})
    public void setUp(@Optional("CHROME") String browser, @Optional("local") String modeRun) {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = getBrowserDriver(browser, modeRun);
        loginPageObject = new LoginPageObject(driver);
    }

    @Test
    public void login() {
        loginPageObject.openDemoWebShop();
        loginPageObject.clickLoginTag();
    }
}
