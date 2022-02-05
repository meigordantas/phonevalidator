package com.jumiaproject.phonevalidator.validator;

import com.jumiaproject.phonevalidator.enums.PhoneState;

public interface PhoneValidatorStrategy {

    PhoneState validate(String phoneNumber);
}
