package com.jumiaproject.phonevalidator.validator;


import com.jumiaproject.phonevalidator.enums.CountryCodeEnum;
import com.jumiaproject.phonevalidator.validator.validators.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Component
@RequiredArgsConstructor
public class PhoneValidatorFactory {

    @Autowired
    private final ListableBeanFactory beanFactory;

    public PhoneValidatorStrategy create(final String phoneNumber) {
        Class<? extends PhoneValidatorStrategy> validatorClass;

        if(getCountryCodeEnum(phoneNumber).equals(CountryCodeEnum.CAMEROON)) {
            validatorClass = CameroonPhoneValidatorStrategy.class;
        } else if(getCountryCodeEnum(phoneNumber).equals(CountryCodeEnum.ETHIOPIA)) {
            validatorClass = EthiopiaPhoneValidatorStrategy.class;
        }  else if(getCountryCodeEnum(phoneNumber).equals(CountryCodeEnum.UGANDA)) {
            validatorClass = UgandaPhoneValidatorStrategy.class;
        }  else if(getCountryCodeEnum(phoneNumber).equals(CountryCodeEnum.MOROCCO)) {
            validatorClass = MoroccoPhoneValidatorStrategy.class;
        }  else if(getCountryCodeEnum(phoneNumber).equals(CountryCodeEnum.MOZAMBIQUE)) {
            validatorClass = MozambiquePhoneValidatorStrategy.class;
        }
        else {
            throw new InvalidParameterException("Unknown country code");
        }

        return BeanFactoryUtils.beanOfType(beanFactory, validatorClass);
    }

    private CountryCodeEnum getCountryCodeEnum(String phoneNumber) {
        var countryCode =
               CountryCodeEnum.valueOf(Integer.parseInt(phoneNumber.replaceAll("[()]", "").split("\\ ", 2)[0]));

        return countryCode.orElse(CountryCodeEnum.UNKNOWN);
    }


}
