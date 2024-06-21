package com.vmo.demowebshop.interfaces;

import static com.vmo.common.Locator.xpath;

public class ProductPageUI {

    //TC02
    public static final String BOOK_TAG = xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]");
    public static final String BOOK_PAGE_TITLE = ("Demo Web Shop. Books");
    public static final String RATING = xpath("//div[@class='rating']//div");


    //TC03
    public static final String REMOVE_ICON = xpath("//td[@class='remove-from-cart'])[1]");
    public static final String REMOVE_FIRST_ITEM = xpath("(//input[@name='removefromcart'])[1]");
    public static final String UPDATE_SHOPPING_CART_BTN = xpath("//input[@name='updatecart']");


    //TC04
    public static final String DIGITAL_DOWNLOADS = xpath("//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]");
    public static final String DIGITAL_DOWNLOADS_PAGE_TITLE = "Demo Web Shop. Digital downloads";
    public static final String ADD_TO_CART_FIRST_ITEM = xpath("(//div[@class='product-item'])[1]//input[@value='Add to cart']");
    public static final String BAR_NOTIFICATION = xpath("//div[@id='bar-notification']/p");
    public static final String LOADING_ICON = xpath("//div[@class='ajax-loading-block-window']");
    public static final String SHOPPING_CART_TAG = xpath("//span[text()='Shopping cart']");
    public static final String SHOPPING_CART_PAGE_TITLE = "Demo Web Shop. Shopping Cart";
    public static final String CART_QTY = xpath("//span[@class='cart-qty']");
    public static final String SUB_TOTAL = xpath("//span[contains(text(),'Sub-Total:')]/parent::td/following-sibling::td//span[@class='product-price']");
    public static final String TOTAL = xpath("//span[contains(text(),'Total:')]/parent::td/following-sibling::td//span[@class='product-price order-total']");
    public static final String TERM_OF_SERVICE = xpath("//input[@id='termsofservice']");
    public static final String CHECKOUT_BTN = xpath("//button[@id='checkout']");
    public static final String CHECKOUT_PAGE = xpath("//div[@class='page-title']");
    public static final String CHECKOUT_AS_GUEST_BTN = xpath("//input[@value='Checkout as Guest']");
    public static final String ONE_PAGE_CHECKOUT = "https://demowebshop.tricentis.com/onepagecheckout";
    public static final String FIRST_NAME_TXT = xpath("//input[@id='BillingNewAddress_FirstName']");
    public static final String LAST_NAME_TXT = xpath("//input[@id='BillingNewAddress_LastName']");
    public static final String EMAIL_TXT = xpath("//input[@id='BillingNewAddress_Email']");
    public static final String COUNTRY_TXT = xpath("//select//option[text()='United States']");
    public static final String CITY_TXT = xpath("//input[@id='BillingNewAddress_City']");
    public static final String ADDRESS_TXT = xpath("//input[@id='BillingNewAddress_Address1']");
    public static final String ZIP_PORTAL_CODE_TXT = xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    public static final String PHONE_NUMBER_TXT = xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    public static final String BILLING_ADDRESS_TAB = xpath("//li[@id='opc-billing']");
    public static final String BILLING_ADDRESS_CONTINUE_BTN = xpath("//div[@id='checkout-step-billing']//input[@title='Continue']");
    public static final String BILLING_PLEASE_WAIT_ICON = xpath("//span[@id='billing-please-wait']");
    public static final String PAYMENT_METHOD_TAB = xpath("//li[@id='opc-payment_method']");
    public static final String CASH_ON_DELIVERY_OPTION = xpath("//input[@id='paymentmethod_0']");
    public static final String PAYMENT_METHOD_CONTINUE_BTN = xpath("//div[@id='checkout-step-payment-method']//input[@value='Continue']");
    public static final String PAYMENT_INFORMATION_TAB = xpath("//li[@id='opc-payment_info']");
    public static final String PAYMENT_INFORMATION_TEXT = xpath("//div[@class='section payment-info']");
    public static final String PAYMENT_INFORMATION_CONTINUE_BTN = xpath("//div[@id='checkout-step-payment-info']//input[@value='Continue']");
    public static final String CONFIRM_ORDER_TAB = xpath("//li[@id='opc-confirm_order']");
    public static final String CONFIRM_ORDER_BTN = xpath("//div[@id='checkout-step-confirm-order']//input[@value='Confirm']");
    public static final String COMPLETED_CHECKOUT = xpath("//div[@class='title']");
    public static final String COMPLETED_CONTINUE_BTN = xpath("//div[@class='buttons']/input[@value='Continue']");
}
