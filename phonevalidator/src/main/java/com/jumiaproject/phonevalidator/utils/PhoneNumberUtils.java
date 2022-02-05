package com.jumiaproject.phonevalidator.utils;

public class PhoneNumberUtils {

    public static String getCountryCodeAsString (String phonenumber) {
        return "+" + phonenumber.replaceAll("[()]", "").split("\\ ", 2)[0];
    }

    public static Integer getCountryCodeAsInteger (String phonenumber) {
        return Integer.parseInt(phonenumber.replaceAll("[()]", "").split("\\ ", 2)[0]);
    }
}
