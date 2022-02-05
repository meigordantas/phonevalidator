package com.jumiaproject.phonevalidator.validator;

import com.jumiaproject.phonevalidator.enums.ValidationStateEnum;

public interface PhoneValidatorStrategy {

    ValidationStateEnum validate(String phoneNumber);
}
