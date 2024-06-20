package com.vmo.demowebshop.features;

import com.vmo.common.BaseTest;
import com.vmo.demowebshop.pageObject.LoginPageObject;
import com.vmo.demowebshop.pageObject.ProductPageObject;
import com.vmo.helper.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

@Epic("Demo Web Shop")
@Feature("Buy Item")
@Story("Buy Item Successfully")
@Listeners(TestListener.class)
public class BuyItemSuccessfullyTest extends BaseTest {
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
    public void TC04_BuyItemSuccessfully() {
        productPageObject.openDemoWebShop();
        productPageObject.clickDigitalDownloads();
        productPageObject.clickAddToCart();
        productPageObject.clickShoppingCart();
        productPageObject.clickTermOfService();
        productPageObject.clickCheckoutBtn();

        productPageObject.checkOutAsGuest();
        productPageObject.onePageCheckout();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
