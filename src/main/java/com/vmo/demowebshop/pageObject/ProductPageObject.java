package com.vmo.demowebshop.pageObject;

import com.vmo.common.BasePage;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import com.vmo.demowebshop.interfaces.ProductPageUI;
import com.vmo.helper.Log;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPageObject extends BasePage {
    private WebDriver driver;
    private int iniCartQty;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public void clickBookTag() {
        Log.allure("Click Books Tag");
        clickToElement(driver, ProductPageUI.BOOK_TAG);
    }

    public void verifyBookPage() {
        Log.allure("Verify Book Page");
        Assert.assertEquals(getTitlePage(), ProductPageUI.BOOK_PAGE);
    }

    public void addToCart2Items() {

    }

    public void hoverOnShoppingCart() {

    }







    public void clickDigitalDownloads() {
        Log.allure("Click Digital Downloads");
        clickToElement(driver, ProductPageUI.DIGITAL_DOWNLOADS);
    }

    public void verifyDigitalDownloadPage() {
        Log.allure("Verify Digital Downloads Page");
        Assert.assertEquals(getTitlePage(), ProductPageUI.DIGITAL_DOWNLOADS_PAGE_TITLE);
    }

    public void clickAddToCart() {
        Log.allure("Click Add To Cart Any Item");
//        iniCartQty = Integer.parseInt(getText(driver, ProductPageUI.CART_QTY)); // contain text > just get number
        clickToElement(driver, ProductPageUI.ADD_TO_CART_FIRST_ITEM);
        waitForElementInvisible(driver, ProductPageUI.LOADING_ICON);
    }

//    public void verifyNotiAndCartItem() {
//        Log.allure("Verify Notification And Cart Item");
//        int currentCartQty = Integer.parseInt(getText(driver, ProductPageUI.CART_QTY));
//        Assert.assertEquals(getText(driver, ProductPageUI.BAR_NOTIFICATION), "The product has been added to your");
//        // la so
//        Assert.assertTrue(currentCartQty > iniCartQty);
//        // so sanh string
//        String a = "a", b = "b";
//        a.equals(b);
//    }

    public void clickShoppingCart() {
        Log.allure("Click Shopping Cart");
        clickToElement(driver, ProductPageUI.SHOPPING_CART_TAG);
    }

    public void removeAnyItem() {
        Log.allure("Remove Any Item");
        checkToDefaultCheckboxOrDefaultRadio(driver, ProductPageUI.REMOVE_ICON);
    }

    public void verifyCheckboxIsChecked() {
        Log.allure("Verify Checkbox Is Checked");
        Assert.assertTrue(isElementSelected(driver, ProductPageUI.TERM_OF_SERVICE));
    }

    public void updateShoppingCart() {
        Log.allure("Click Update Shopping Cart Button");
        clickToElement(driver, ProductPageUI.UPDATE_SHOPPING_CART_BTN);
    }

    public void verifyShoppingCartPage() {
        Log.allure("Verify Shopping Cart Page");
        Assert.assertEquals(getTitlePage(), ProductPageUI.SHOPPING_CART_PAGE_TITLE);
        Log.allure("Verify Sum Of Total Equal To Sub-Total");
        Assert.assertEquals(getText(driver, ProductPageUI.SUB_TOTAL), getText(driver, ProductPageUI.TOTAL)); //String
    }

    public void clickTermOfService() {
        Log.allure("Click Term Of Service");
        checkToDefaultCheckboxOrDefaultRadio(driver, ProductPageUI.TERM_OF_SERVICE);
        waitForElementClickable(driver, ProductPageUI.TERM_OF_SERVICE);
    }

    public void verifyTermOfServiceCheckBox() {
        Log.allure("Verify Term Of Service Is Checked");
        Assert.assertTrue(isElementSelected(driver, ProductPageUI.TERM_OF_SERVICE));
    }

    public void clickCheckoutBtn() {
        Log.allure("Click Checkout Button");
        clickToElement(driver, ProductPageUI.CHECKOUT_BTN);
    }

    public void verifyCheckoutPage() {
        Log.allure("Verify Checkout Page");
        Assert.assertEquals(getText(driver, ProductPageUI.CHECKOUT_PAGE), "Welcome, Please Sign In!");
    }

    public void checkOutAsGuest() {
        Log.allure("Click Check Out As Guest Button");
        clickToElement(driver, ProductPageUI.CHECKOUT_AS_GUEST_BTN);
    }

    public void verifyOnePageCheckoutPage() {
        Log.allure("Verify One Page Checkout & Tab Billing Address Is Expanding");
        Assert.assertEquals(getCurrentUrl(driver), ProductPageUI.ONE_PAGE_CHECKOUT);
        Assert.assertTrue(getWebElement(driver, ProductPageUI.BILLING_ADDRESS_TAB).getAttribute("class").contains("active"));
    }

    public void billingAddress() {
        Log.allure("Billing Address Tab");
        waitForElementClickable(driver, ProductPageUI.FIRST_NAME_TXT);
        sendKeysToElement(driver, ProductPageUI.FIRST_NAME_TXT, "A");
        sendKeysToElement(driver, ProductPageUI.LAST_NAME_TXT, "Nguyen Van");
        sendKeysToElement(driver, ProductPageUI.EMAIL_TXT, "a@gmail.com");
        checkToDefaultCheckboxOrDefaultRadio(driver, ProductPageUI.COUNTRY_TXT);
        sendKeysToElement(driver, ProductPageUI.CITY_TXT, "Ha Noi");
        sendKeysToElement(driver, ProductPageUI.ADDRESS_TXT, "Cau Giay");
        sendKeysToElement(driver, ProductPageUI.ZIP_PORTAL_CODE_TXT, "1111");
        sendKeysToElement(driver, ProductPageUI.PHONE_NUMBER_TXT, "0912345678");
        waitForElementClickable(driver, ProductPageUI.BILLING_ADDRESS_CONTINUE_BTN);
        clickToElement(driver, ProductPageUI.BILLING_ADDRESS_CONTINUE_BTN);
    }

    public void verifyShippingAddress() {
        Log.allure("Verify Shipping Address Is Expanding");
        Assert.assertTrue(getWebElement(driver, ProductPageUI.SHIPPING_ADDRESS_TAB).getAttribute("class").contains("active"));
    }

    public void shippingAddress() {
        Log.allure("Shipping Address Tab");
        waitForElementClickable(driver, ProductPageUI.SHIPPING_ADDRESS_CONTINUE_BTN);
        clickToElement(driver, ProductPageUI.SHIPPING_ADDRESS_CONTINUE_BTN);
    }

    public void verifyShippingMethod() {
        Log.allure("Verify Shipping Method Is Expanding");
        Assert.assertTrue(getWebElement(driver, ProductPageUI.SHIPPING_METHOD_TAB).getAttribute("class").contains("active"));
    }

    public void shippingMethod() {
        Log.allure("Shipping Method Tab");
        waitForElementClickable(driver, ProductPageUI.SHIPPING_METHOD_CONTINUE_BTN);
        clickToElement(driver, ProductPageUI.SHIPPING_METHOD_CONTINUE_BTN);
    }

    public void verifyPaymentMethod() {
        Log.allure("Verify Tab Payment Method Is Expanding");
        Assert.assertTrue(getWebElement(driver, ProductPageUI.PAYMENT_METHOD_TAB).getAttribute("class").contains("active"));
        Log.allure("Cash On Delivery Is Selected");
        Assert.assertTrue(getWebElement(driver, ProductPageUI.CASH_ON_DELIVERY_OPTION).isSelected());
    }

    public void paymentMethod() {
        Log.allure("Payment Method Tab");
        waitForElementClickable(driver, ProductPageUI.PAYMENT_METHOD_CONTINUE_BTN);
        clickToElement(driver, ProductPageUI.PAYMENT_METHOD_CONTINUE_BTN);
    }

    public void verifyPaymentInformation() {
        Log.allure("Verify Tab Payment Information Is Expanding");
        Assert.assertTrue(getWebElement(driver, ProductPageUI.PAYMENT_INFORMATION_TAB).getAttribute("class").contains("active"));
        Log.allure("Message You will pay by COD appears");
        Assert.assertEquals(getWebElement(driver, ProductPageUI.PAYMENT_INFORMATION_TEXT), "You will pay by COD");
    }

    public void paymentInformation() {
        Log.allure("Payment Information Tab");
        waitForElementClickable(driver, ProductPageUI.PAYMENT_INFORMATION_CONTINUE_BTN);
        clickToElement(driver, ProductPageUI.PAYMENT_INFORMATION_CONTINUE_BTN);
    }

    public void verifyConfirmOrder() {
        Log.allure("Verify Tab Confirm Order Is Expanding");
        Assert.assertTrue(getWebElement(driver, ProductPageUI.CONFIRM_ORDER_TAB).getAttribute("class").contains("active"));
    }

    public void confirmOrder() {
        Log.allure("Confirm Order tab");
        waitForElementClickable(driver, ProductPageUI.CONFIRM_ORDER_BTN);
        clickToElement(driver, ProductPageUI.CONFIRM_ORDER_BTN);
    }

    public void verifyCompletedCheckout() {
        Log.allure("Verify Completed Checkout");
        Assert.assertEquals(getWebElement(driver, ProductPageUI.COMPLETED_CHECKOUT), "Your order has been successfully processed!");
    }

    public void orderCompleted() {
        Log.allure("Order Completed");
        waitForElementClickable(driver, ProductPageUI.COMPLETED_CONTINUE_BTN);
        clickToElement(driver, ProductPageUI.COMPLETED_CONTINUE_BTN);
    }


}

