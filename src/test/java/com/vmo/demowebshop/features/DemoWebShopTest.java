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
    public void TC01_LoginTest(String Username, String Password) {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(Username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);




//        loginPageObject.openDemoWebShop();
//        loginPageObject.clickLoginTag();
    }

    @Test
    public void TC02_Buy2BooksHighestRated(){

    }
    @Test
    public void TC03_RemoveItemOutOfShoppingCart(){
        loginPageObject.openDemoWebShop();
        //Step2

        productPageObject.clickShoppingCart();
        productPageObject.removeItem();

    }
    @Test
    public void TC04_BuyItemSuccessfully() {
        loginPageObject.openDemoWebShop();
        productPageObject.clickDigitalDownloads();
        productPageObject.clickAddToCart();
        productPageObject.verifyNotiAndCartItem();
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
