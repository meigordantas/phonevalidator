package com.jumiaproject.phonevalidator.validator.validators;

import com.jumiaproject.phonevalidator.enums.PhoneState;
import com.jumiaproject.phonevalidator.validator.PhoneValidatorStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoroccoPhoneValidatorStrategy implements PhoneValidatorStrategy {

    @Value("${regex.morocco}")
    private String regex;

    @Override
    public PhoneState validate(String phoneNumber) {
        if (phoneNumber.matches(regex)) {
            return PhoneState.VALID;
        } else {
            return PhoneState.INVALID;
        }
    }
}
