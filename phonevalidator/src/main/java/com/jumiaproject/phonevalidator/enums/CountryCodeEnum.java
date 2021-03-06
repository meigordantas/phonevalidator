package com.jumiaproject.phonevalidator.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CountryCodeEnum {

    CAMEROON(237),
    ETHIOPIA(251),
    MOROCCO(212),
    MOZAMBIQUE(258),
    UGANDA(256),
    UNKNOWN(-1);

    private int numValue;

    CountryCodeEnum(int val) {
        this.numValue = val;
    }

    public int getNumValue() {
        return numValue;
    }

    public static Optional<CountryCodeEnum> valueOf(int value) {
        return Arrays.stream(values())
                .filter(CountryCodeEnum -> CountryCodeEnum.numValue == value)
        .findFirst();
    }
}
