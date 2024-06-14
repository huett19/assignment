package com.vmo.demowebshop.features;

import com.vmo.common.BaseTest;
import com.vmo.demowebshop.pageObject.LoginPageObject;
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
@Feature("Login")
@Story("Login with Excel file")
@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPageObject;

//    @BeforeClass
//    @Parameters({"browser", "modeRun"})
//    public void setUp(@Optional("CHROME") String browser, @Optional("local") String modeRun) {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        driver = getBrowserDriver(browser, modeRun);
//        loginPageObject = new LoginPageObject(driver);
//    }

    ExcelConfig excelConfig = new ExcelConfig("src/main/resources/data.xlsx");

    @DataProvider(name = "ExcelData")
    public Object[][] getCredential() {
        return excelConfig.data();
    }

    @Test(dataProvider = "ExcelData")
    public void testLogin(String Username, String Password) {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(Username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);












//        loginPageObject.openDemoWebShop();
//        loginPageObject.clickLoginTag();
    }


}
