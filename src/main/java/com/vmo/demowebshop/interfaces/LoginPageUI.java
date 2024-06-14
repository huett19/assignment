package com.vmo.demowebshop.interfaces;

import static com.vmo.common.Locator.xpath;

public class LoginPageUI {
    public static final String PAGE_TITLE = "Demo Web Shop";
    public static final String LOGIN_TAG = xpath("//li/a[@class='ico-login']");
    public static final String EMAIL_TXT = xpath("//input[@id='Email']");
    public static final String PASSWORD_TXT = xpath("//input[@id='Password']");
    public static final String LOGIN_BTN = xpath("//input[contains(@class,'login-button')]");
}
