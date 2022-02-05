package com.jumiaproject.phonevalidator.config;

import com.jumiaproject.phonevalidator.enums.CountryCodeEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CountryToStringConverter implements Converter<String, CountryCodeEnum> {

    @Override
    public CountryCodeEnum convert(String text){
        try {
            return CountryCodeEnum.valueOf(text.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }
}
