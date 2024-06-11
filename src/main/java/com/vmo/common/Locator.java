package com.vmo.common;

public class Locator {
    public static String id(String locator){
        return Prefix.ID + locator;
    }
    public static String className(String locator){
        return Prefix.CLASS + locator;
    }
}
