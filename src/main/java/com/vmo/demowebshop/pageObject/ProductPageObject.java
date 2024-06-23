package com.vmo.demowebshop.pageObject;

import com.vmo.common.BasePage;
import com.vmo.demowebshop.interfaces.ProductPageUI;
import com.vmo.helper.Log;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.*;

import static com.vmo.demowebshop.interfaces.ProductPageUI.SHOPPING_CART_TAG;

public class ProductPageObject extends BasePage {
    private WebDriver driver;
    int iniCartQty;
    int iniCartQty1;
    String firstName = "A";
    String lastName = "Nguyen Van";
    String email = "a@gmail.com";
    String country = "Viet Nam";
    String city = "Ha Noi";
    String address = "Cau Giay";
    String zipCode = "1111";
    String phone = "0912345678";

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public void clickBookTag() {
        Log.allure("Click Books Tag");
        waitForElementClickable(driver, ProductPageUI.BOOK_TAG);
        clickToElement(driver, ProductPageUI.BOOK_TAG);
    }

    public void verifyBookPage() {
        Log.allure("Verify Book Page");
        Assert.assertEquals(getTitlePage(), ProductPageUI.BOOK_PAGE_TITLE);
    }

    public void addToCart2Items() {
        List<WebElement> detailList = driver.findElements(By.xpath("//input[contains(@class,'product-box-add-to-cart-button')]/ancestor::div[@class='details']"));
        List<Double> rates = new ArrayList<Double>();
        for (WebElement div : detailList) {
            WebElement rateDiv = div.findElement(By.xpath(".//div[@class='rating']/div"));
            //System.out.println("rateDiv = " + rateDiv.getAttribute("style"));
            rates.add(Double.parseDouble(rateDiv.getAttribute("style").replaceAll("\\D+", "")));
        }
        Collections.sort(rates, Collections.reverseOrder());
        System.out.println("rates = " + rates);

        for (WebElement div : detailList) {
            WebElement rateDiv = div.findElement(By.xpath(".//div[@class='rating']/div"));

            if (Double.parseDouble(rateDiv.getAttribute("style").replaceAll("\\D+", "")) == rates.get(0)) {
                WebElement buttonAddToCard = div.findElement(By.xpath(".//input[contains(@class,'product-box-add-to-cart-button')]"));
                buttonAddToCard.click();
            }
        }
    }

    public void hoverOnShoppingCart() {
        waitForElementVisible(driver, SHOPPING_CART_TAG);
        WebElement shoppingCart = getWebElement(driver, ProductPageUI.SHOPPING_CART_TAG);
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).perform();
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
        String cartQtyText = getText(driver, ProductPageUI.CART_QTY);
        String numbersOnly = cartQtyText.replaceAll("\\D+", "");
        int iniCartQty = Integer.parseInt(numbersOnly);
        System.out.println("iniCartQty = " + iniCartQty);
        clickToElement(driver, ProductPageUI.ADD_TO_CART_FIRST_ITEM);
        waitForElementInvisible(driver, ProductPageUI.LOADING_ICON);
    }

    public void verifyNotiAndCartItem() {
        Log.allure("Verify Notification And Cart Item");
        waitForElementVisible(driver, ProductPageUI.BAR_NOTIFICATION);

        int currentCartQty = Integer.parseInt(getText(driver, ProductPageUI.CART_QTY).replaceAll("\\D+", ""));
        System.out.println("currentCartQty = " + currentCartQty);
        Assert.assertTrue(currentCartQty == iniCartQty + 1);
    }

    public void addToCart3Products() {
//
//        Log.allure("Click Add To Cart Any Item");
//        String cartQtyText1 = getText(driver, ProductPageUI.CART_QTY);
//        String numbersOnly1 = cartQtyText1.replaceAll("\\D+", "");
//        int iniCartQty1 = Integer.parseInt(numbersOnly1);
//        System.out.println("iniCartQty = " + iniCartQty1);


        List<WebElement> productList = driver.findElements(By.xpath("//input[contains(@class,'product-box-add-to-cart-button')]/ancestor::div[@class='details']"));
        List<Double> product = new ArrayList<Double>();
        int i = 0;
        for (WebElement div : productList) {
            if (i == 2) {
                WebElement productTitle = div.findElement(By.xpath(".//h2[@class='product-title']/a"));
                productTitle.click();
            }
            i++;
        }

    }

    public void addToCartFromDetailPage() {
        getWebElement(driver, ProductPageUI.ADD_TO_CART_BTN).click();
    }

    public void verifyAfterAddToCart3Products() {
        Log.allure("Verify After Add To Cart 3 Produts");

    }

    public void clickShoppingCart() {
        Log.allure("Click Shopping Cart");
        clickToElement(driver, SHOPPING_CART_TAG);
    }

    public void removeAnyItem() {
        Log.allure("Remove Any Item");
        waitForElementSelected(driver, ProductPageUI.REMOVE_FIRST_ITEM);
        checkToDefaultCheckboxOrDefaultRadio(driver, ProductPageUI.REMOVE_ICON);
    }

    public void verifyCheckboxIsChecked() {
        Log.allure("Verify Checkbox Is Checked");
        Assert.assertTrue(isElementSelected(driver, ProductPageUI.TERM_OF_SERVICE));
    }

    public void clickUpdateShoppingCart() {
        Log.allure("Click Update Shopping Cart Button");
        clickToElement(driver, ProductPageUI.UPDATE_SHOPPING_CART_BTN);
    }

    public void verifyAfterUpdateShoppingCart() {
        Log.allure("Verify After Update Shopping Cart");
        waitForElementVisible(driver, ProductPageUI.BAR_NOTIFICATION);

        int currentCartQty1 = Integer.parseInt(getText(driver, ProductPageUI.CART_QTY).replaceAll("\\D+", ""));
        System.out.println("currentCartQty1 = " + currentCartQty1);
        Assert.assertTrue(currentCartQty1 == iniCartQty1 - 1);

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

    public void verifyBillingAddress() {
        Log.allure("Verify One Page Checkout & Tab Billing Address Is Expanding");
        Assert.assertEquals(getCurrentUrl(driver), ProductPageUI.ONE_PAGE_CHECKOUT);
        Assert.assertTrue(getWebElement(driver, ProductPageUI.BILLING_ADDRESS_TAB).getAttribute("class").contains("active"));
    }

    public void billingAddress() {
        Log.allure("Billing Address Tab");
        waitForElementClickable(driver, ProductPageUI.FIRST_NAME_TXT);
        sendKeysToElement(driver, ProductPageUI.FIRST_NAME_TXT, firstName);
        sendKeysToElement(driver, ProductPageUI.LAST_NAME_TXT, lastName);
        sendKeysToElement(driver, ProductPageUI.EMAIL_TXT, email);
        checkToDefaultCheckboxOrDefaultRadio(driver, ProductPageUI.COUNTRY_TXT);
        waitForElementInvisible(driver, ProductPageUI.STATES_LOADING_PROGRESS_ICON);
        sendKeysToElement(driver, ProductPageUI.CITY_TXT, city);
        sendKeysToElement(driver, ProductPageUI.ADDRESS_TXT, address);
        sendKeysToElement(driver, ProductPageUI.ZIP_PORTAL_CODE_TXT, zipCode);
        sendKeysToElement(driver, ProductPageUI.PHONE_NUMBER_TXT, phone);
        waitForElementClickable(driver, ProductPageUI.BILLING_ADDRESS_CONTINUE_BTN);
        clickToElement(driver, ProductPageUI.BILLING_ADDRESS_CONTINUE_BTN);
        waitForElementInvisible(driver, ProductPageUI.BILLING_PLEASE_WAIT_ICON);
    }


    public void verifyPaymentMethod() {
        Log.allure("Verify Tab Payment Method Is Expanding");
        waitForElementVisible(driver, ProductPageUI.PAYMENT_METHOD_TAB);
//        Assert.assertTrue(getWebElement(driver, ProductPageUI.PAYMENT_METHOD_TAB).getAttribute("class").contains("active"));
        Log.allure("Cash On Delivery Is Selected");
//        Assert.assertTrue(getWebElement(driver, ProductPageUI.CASH_ON_DELIVERY_RADIO).isSelected());
    }

    public void paymentMethod() {
        Log.allure("Payment Method Tab");
        waitForElementClickable(driver, ProductPageUI.PAYMENT_METHOD_CONTINUE_BTN);
        clickToElement(driver, ProductPageUI.PAYMENT_METHOD_CONTINUE_BTN);
        waitForElementInvisible(driver, ProductPageUI.PAYMENT_PLEASE_WAIT_ICON);
    }

    public void verifyPaymentInformation() {
        Log.allure("Verify Tab Payment Information Is Expanding");
        waitForElementVisible(driver, ProductPageUI.PAYMENT_INFORMATION_TAB);
//        Assert.assertTrue(getWebElement(driver, ProductPageUI.PAYMENT_INFORMATION_TAB).getAttribute("class").contains("active"));
        Log.allure("Message You will pay by COD appears");
        waitForElementVisible(driver, ProductPageUI.PAYMENT_INFORMATION_TEXT);
        Assert.assertEquals(getText(driver, ProductPageUI.PAYMENT_INFORMATION_TEXT), "You will pay by COD");
    }

    public void paymentInformation() {
        Log.allure("Payment Information Tab");
        waitForElementClickable(driver, ProductPageUI.PAYMENT_INFORMATION_CONTINUE_BTN);
        clickToElement(driver, ProductPageUI.PAYMENT_INFORMATION_CONTINUE_BTN);
        waitForElementInvisible(driver, ProductPageUI.PAYMENT_INFO_PLEASE_WAIT_ICON);
    }

    public void verifyConfirmOrder() {
        Log.allure("Verify Tab Confirm Order Is Expanding");
//        Assert.assertTrue(getWebElement(driver, ProductPageUI.CONFIRM_ORDER_TAB).getAttribute("class").contains("active"));

        Log.allure("Verify Information Filled In");
        waitForElementVisible(driver, ProductPageUI.RESPONSE_BILLING_EMAIL);
        String name = firstName + " " + lastName;
        Assert.assertTrue(getText(driver, ProductPageUI.RESPONSE_BILLING_NAME).contains(name));
        Assert.assertTrue(getText(driver, ProductPageUI.RESPONSE_BILLING_EMAIL).contains(email));
        Assert.assertTrue(getText(driver, ProductPageUI.RESPONSE_BILLING_PHONE).contains(phone));
        Assert.assertTrue(getText(driver, ProductPageUI.RESPONSE_BILLING_ADDRESS).contains(address));

        String cityStateZip = city + " " + "," + " " + zipCode;
        Assert.assertTrue(getText(driver, ProductPageUI.RESPONSE_BILLING_CITY_STATE_ZIP).contains(cityStateZip));
        Assert.assertTrue(getText(driver, ProductPageUI.RESPONSE_BILLING_COUNTRY).contains(country));
        Assert.assertTrue(getText(driver, ProductPageUI.RESPONSE_PAYMENT_METHOD).contains("Cash On Delivery (COD)"));
        hoverOnShoppingCart();
        Assert.assertEquals(getText(driver, ProductPageUI.RESPONSE_PRODUCT_NAME), getText(driver, ProductPageUI.PRODUCT_NAME));
        double subTotal = Double.parseDouble(getText(driver, ProductPageUI.SUB_TOTAL));
        double fee = Double.parseDouble(getText(driver, ProductPageUI.PAYMENT_METHOD_FEE));
        double total = subTotal + fee;
        double responseTotal = Double.parseDouble(getText(driver, ProductPageUI.RESPONSE_TOTAL));
        Assert.assertTrue(responseTotal == total);
    }

    public void confirmOrder() {
        Log.allure("Confirm Order tab");
        waitForElementClickable(driver, ProductPageUI.CONFIRM_ORDER_BTN);
        clickToElement(driver, ProductPageUI.CONFIRM_ORDER_BTN);
        waitForElementInvisible(driver, ProductPageUI.CONFIRM_ORDER_PLEASE_WAIT_ICON);
    }

    public void verifyCompletedCheckout() {
        Log.allure("Verify Completed Checkout");
        waitForElementVisible(driver, ProductPageUI.COMPLETED_CHECKOUT);
        Assert.assertEquals(getText(driver, ProductPageUI.COMPLETED_CHECKOUT), "Your order has been successfully processed!");
    }

    public void orderCompleted() {
        Log.allure("Order Completed");
        waitForElementClickable(driver, ProductPageUI.COMPLETED_CONTINUE_BTN);
        clickToElement(driver, ProductPageUI.COMPLETED_CONTINUE_BTN);
    }


}

