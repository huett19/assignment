package com.vmo.demowebshop.features;

import com.vmo.common.BaseTest;
import com.vmo.demowebshop.pageObject.LoginPageObject;
import com.vmo.demowebshop.pageObject.ProductPageObject;
import com.vmo.helper.ExcelConfig;
import com.vmo.helper.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

@Epic("Demo Web Shop")
@Feature("Buy Item")
@Story("Buy Item Successfully")
@Listeners(TestListener.class)
public class DemoWebShopTest extends BaseTest {
    private WebDriver driver;
    private ProductPageObject productPageObject;
    private LoginPageObject loginPageObject;

    @BeforeMethod
    @Parameters({"browser", "modeRun"})
    public void setUp(@Optional("CHROME") String browser, @Optional("local") String modeRun) {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = getBrowserDriver(browser, modeRun);
        productPageObject = new ProductPageObject(driver);
        loginPageObject = new LoginPageObject(driver);
    }

    ExcelConfig excelConfig = new ExcelConfig("src/main/resources/data.xlsx");

    @DataProvider(name = "ExcelData")
    public Object[][] getCredential() {
        return excelConfig.data();
    }

    @Test(dataProvider = "ExcelData")
    public void TC01_LoginTest(String Username, String Password, String Message) {
        loginPageObject.openDemoWebShop();
        loginPageObject.verifyHomePageTitle();
        loginPageObject.clickLoginTag();
        loginPageObject.verifyLoginPageTitle();
        loginPageObject.setEmail(Username);
        loginPageObject.setPassword(Password);
        loginPageObject.clickLogin();
        String actualMessage = loginPageObject.getLoginSuccessMessage();
        loginPageObject.verifyAfterLogin(Message);
    }

    @Test
    public void TC02_Buy2BooksHighestRated() {
        loginPageObject.openDemoWebShop();
        loginPageObject.verifyHomePageTitle();
        productPageObject.clickBookTag();
        productPageObject.verifyBookPage();
        productPageObject.addToCart2Items();
        productPageObject.verifyNotiAndCartItem();
        productPageObject.hoverOnShoppingCart();
    }

    @Test
    public void TC03_RemoveItemOutOfShoppingCart() {
        loginPageObject.openDemoWebShop();
        loginPageObject.verifyHomePageTitle();
        //Step2
        productPageObject.addToCart3Products();
        productPageObject.addToCartFromDetailPage();
        productPageObject.verifyAfterAddToCart3Products();

        productPageObject.clickShoppingCart();
        productPageObject.verifyShoppingCartPage();
        productPageObject.removeAnyItem();
        productPageObject.verifyCheckboxIsChecked();
        productPageObject.clickUpdateShoppingCart();
        productPageObject.verifyAfterUpdateShoppingCart();
    }

    @Test
    public void TC04_BuyItemSuccessfully() {
        loginPageObject.openDemoWebShop();
        loginPageObject.verifyHomePageTitle();
        productPageObject.clickDigitalDownloads();
        productPageObject.verifyDigitalDownloadPage();
        productPageObject.clickAddToCart();
        productPageObject.verifyNotiAndCartItem();
        productPageObject.clickShoppingCart();
        productPageObject.verifyShoppingCartPage();
        productPageObject.clickTermOfService();
        productPageObject.verifyTermOfServiceCheckBox();
        productPageObject.clickCheckoutBtn();
        productPageObject.verifyCheckoutPage();

        productPageObject.checkOutAsGuest();
        productPageObject.verifyBillingAddress();
        productPageObject.billingAddress();

        productPageObject.verifyPaymentMethod();
        productPageObject.paymentMethod();
        productPageObject.verifyPaymentInformation();
        productPageObject.paymentInformation();
        productPageObject.verifyConfirmOrder();
        productPageObject.confirmOrder();

        productPageObject.verifyCompletedCheckout();
        productPageObject.orderCompleted();
        loginPageObject.verifyHomePageTitle();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
