package com.vmo.demowebshop.interfaces;

import static com.vmo.common.Locator.xpath;

public class ProductPageUI {
    public static final String BOOK_TAG = xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]");
}
