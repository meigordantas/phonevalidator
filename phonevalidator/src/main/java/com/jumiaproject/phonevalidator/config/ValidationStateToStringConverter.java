package com.jumiaproject.phonevalidator.config;

import com.jumiaproject.phonevalidator.enums.CountryCodeEnum;
import com.jumiaproject.phonevalidator.enums.ValidationStateEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ValidationStateToStringConverter implements Converter<String, ValidationStateEnum> {

    @Override
    public ValidationStateEnum convert(String text){
        try {
            return ValidationStateEnum.valueOf(text.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }
}
