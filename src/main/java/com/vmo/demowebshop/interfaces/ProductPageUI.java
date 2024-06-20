package com.vmo.demowebshop.interfaces;

import static com.vmo.common.Locator.xpath;

public class ProductPageUI {
    public static final String BOOK_TAG = xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]");



    //TC03
    public static final String REMOVE_ICON = xpath("//td[@class='remove-from-cart'])[1]");
    public static final String UPDATE_SHOPPING_CART_BTN = xpath("//input[@name='updatecart']");




    //TC04
    public static final String DIGITAL_DOWNLOADS = xpath("//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]");
    public static final String DIGITAL_DOWNLOADS_PAGE_TITLE = "Demo Web Shop. Digital downloads";
    public static final String ADD_TO_CART_FIRST_ITEM = xpath("(//div[@class='product-item'])[1]//input[@value='Add to cart']");
    public static final String BAR_NOTIFICATION = xpath("//div[@id='bar-notification']/p");
    public static final String LOADING_ICON = xpath("//div[@class='ajax-loading-block-window']");
    public static final String SHOPPING_CART_TAG = xpath("//span[text()='Shopping cart']");
    public static final String CART_QTY = xpath("//span[@class='cart-qty']");
    public static final String TERM_OF_SERVICE = xpath("//input[@id='termsofservice']");
    public static final String CHECKOUT_BTN = xpath("//button[@id='checkout']");
    public static final String CHECKOUT_AS_GUEST_BTN = xpath("//input[@value='Checkout as Guest']");



    public static final String FIRST_NAME_TXT = xpath("//input[@id='BillingNewAddress_FirstName']");
    public static final String LAST_NAME_TXT = xpath("//input[@id='BillingNewAddress_LastName']");
    public static final String EMAIL_TXT = xpath("//input[@id='BillingNewAddress_Email']");
    public static final String COUNTRY_TXT = xpath("//select//option[text()='United States']");
    public static final String CITY_TXT = xpath("//input[@id='BillingNewAddress_City']");
    public static final String ADDRESS_TXT = xpath("//input[@id='BillingNewAddress_Address1']");
    public static final String ZIP_PORTAL_CODE_TXT = xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    public static final String PHONE_NUMBER_TXT = xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    public static final String CONTINUE1_BTN = xpath("//div[@id='checkout-step-billing']//input[@title='Continue']");
    public static final String CONTINUE2_BTN = xpath("//div[@id='checkout-step-payment-method']//input[@value='Continue']");
    public static final String CONTINUE3_BTN = xpath("//div[@id='checkout-step-payment-info']//input[@value='Continue']");
    public static final String CONFIRM_BTN = xpath("//div[@id='checkout-step-confirm-order']//input[@value='Confirm']");



}
