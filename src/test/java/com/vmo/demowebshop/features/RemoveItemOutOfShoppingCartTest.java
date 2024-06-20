package com.vmo.demowebshop.features;

import com.vmo.common.BaseTest;
import com.vmo.demowebshop.interfaces.ProductPageUI;
import com.vmo.demowebshop.pageObject.LoginPageObject;
import com.vmo.demowebshop.pageObject.ProductPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RemoveItemOutOfShoppingCartTest extends BaseTest {
    private WebDriver driver;
    private ProductPageObject productPageObject;
    private LoginPageObject loginPageObject;

    @BeforeMethod
    @Parameters({"browser", "modeRun"})
    public void setUp(@Optional("CHROME") String browser, @Optional("local") String modeRun) {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = getBrowserDriver(browser, modeRun);
        productPageObject = new ProductPageObject(driver);
    }

    @Test
    public void TC03_RemoveItemOutOfShoppingCart(){
        productPageObject.openDemoWebShop();
        //Step2

        productPageObject.clickShoppingCart();
        productPageObject.removeItem();

    }
}
