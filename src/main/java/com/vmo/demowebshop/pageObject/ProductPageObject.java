package com.vmo.demowebshop.pageObject;

import com.vmo.common.BasePage;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import com.vmo.demowebshop.interfaces.ProductPageUI;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPageObject extends BasePage {
    private WebDriver driver;
    private int iniCart;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public void clickDigitalDownloads() {
        clickToElement(driver, ProductPageUI.DIGITAL_DOWNLOADS);
        Assert.assertEquals(getTitlePage(), ProductPageUI.DIGITAL_DOWNLOADS_PAGE_TITLE);
    }

    public void clickAddToCart() {
        iniCart = Integer.parseInt(getText(driver, ProductPageUI.CART_QTY)); // contain text > just get number
        clickToElement(driver, ProductPageUI.ADD_TO_CART_FIRST_ITEM);
        waitForElementInvisible(driver, ProductPageUI.LOADING_ICON);
    }

    public void verifyNotiAndCartItem() {
        int currentCartQty = Integer.parseInt(getText(driver, ProductPageUI.CART_QTY));
        // la so
        Assert.assertTrue(currentCartQty-1== iniCart);
        // so sanh string
        String a = "a", b = "b";
        a.equals(b);
    }

    public void clickShoppingCart() {
        clickToElement(driver, ProductPageUI.SHOPPING_CART_TAG);
    }

    public void clickTermOfService() {
        checkToDefaultCheckboxOrDefaultRadio(driver, ProductPageUI.TERM_OF_SERVICE);
        waitForElementClickable(driver, ProductPageUI.TERM_OF_SERVICE);
    }

    public void clickCheckoutBtn() {
        clickToElement(driver, ProductPageUI.CHECKOUT_BTN);
    }

    public void checkOutAsGuest() {
        clickToElement(driver, ProductPageUI.CHECKOUT_AS_GUEST_BTN);
    }

    public void onePageCheckout() {
        waitForElementClickable(driver, ProductPageUI.FIRST_NAME_TXT);
        sendKeysToElement(driver, ProductPageUI.FIRST_NAME_TXT, "A");
        sendKeysToElement(driver, ProductPageUI.LAST_NAME_TXT, "Nguyen Van");
        sendKeysToElement(driver, ProductPageUI.EMAIL_TXT, "a@gmail.com");
        checkToDefaultCheckboxOrDefaultRadio(driver, ProductPageUI.COUNTRY_TXT);
        sendKeysToElement(driver, ProductPageUI.CITY_TXT, "Ha Noi");
        sendKeysToElement(driver, ProductPageUI.ADDRESS_TXT, "Cau Giay");
        sendKeysToElement(driver, ProductPageUI.ZIP_PORTAL_CODE_TXT, "1111");
        sendKeysToElement(driver, ProductPageUI.PHONE_NUMBER_TXT, "0912345678");
        waitForElementClickable(driver, ProductPageUI.CONTINUE1_BTN);
        clickToElement(driver, ProductPageUI.CONTINUE1_BTN);
        waitForElementClickable(driver, ProductPageUI.CONTINUE2_BTN);
        clickToElement(driver, ProductPageUI.CONTINUE2_BTN);
        waitForElementClickable(driver, ProductPageUI.CONTINUE3_BTN);
        clickToElement(driver, ProductPageUI.CONTINUE3_BTN);
        waitForElementClickable(driver, ProductPageUI.CONFIRM_BTN);
        clickToElement(driver, ProductPageUI.CONFIRM_BTN);
    }


    public void removeItem() {
        checkToDefaultCheckboxOrDefaultRadio(driver, ProductPageUI.REMOVE_ICON);
        clickToElement(driver, ProductPageUI.UPDATE_SHOPPING_CART_BTN);
    }

}

