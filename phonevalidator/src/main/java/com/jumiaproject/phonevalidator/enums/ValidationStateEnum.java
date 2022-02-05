package com.jumiaproject.phonevalidator.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ValidationStateEnum {

    VALID,
    INVALID;

    public static ValidationStateEnum fromString(String text) {
        try {
            return ValidationStateEnum.valueOf(text);
        } catch (Exception e) {
            return null;
        }
    }
}
