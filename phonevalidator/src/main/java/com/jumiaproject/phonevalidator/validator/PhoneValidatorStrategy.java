package com.jumiaproject.phonevalidator.validator;

import com.jumiaproject.phonevalidator.enums.ValidationState;

public interface PhoneValidatorStrategy {

    ValidationState validate(String phoneNumber);
}
