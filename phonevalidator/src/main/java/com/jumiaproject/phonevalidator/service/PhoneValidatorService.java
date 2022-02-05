package com.jumiaproject.phonevalidator.service;

import com.jumiaproject.phonevalidator.database.entity.CustomerEntity;
import com.jumiaproject.phonevalidator.dto.PhoneResponseDto;
import com.jumiaproject.phonevalidator.enums.CountryCodeEnum;
import com.jumiaproject.phonevalidator.enums.PhoneState;
import com.jumiaproject.phonevalidator.utils.PhoneNumberUtils;
import com.jumiaproject.phonevalidator.validator.PhoneValidatorFactory;
import com.jumiaproject.phonevalidator.validator.PhoneValidatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneValidatorService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PhoneValidatorFactory validatorFactory;

    public List<PhoneResponseDto> getAllPhonesValidated() {
        var allCustomers = customerService.findAll();

        var firstPhone = allCustomers.stream().findFirst().get();

        return allCustomers.stream()
                .map(this::getResponseDto)
                .collect(Collectors.toList());

    }

    private PhoneState validatePhoneNumber(CustomerEntity customer) {
        var customerPhoneNumber = customer.getCustomerPhone();
        var validatorClass = this.validatorFactory.create(customerPhoneNumber);

        return validatorClass.validate(customerPhoneNumber);
    }

    private PhoneResponseDto getResponseDto (CustomerEntity customer) {
        var phoneNumber = customer.getCustomerPhone();
        return PhoneResponseDto.builder()
                .phoneNumber(phoneNumber)
                .phoneState(validatePhoneNumber(customer))
                .phoneCountry(CountryCodeEnum.valueOf(PhoneNumberUtils.getCountryCodeAsInteger(phoneNumber))
                .orElse(CountryCodeEnum.UNKNOWN))
                .countryCode(PhoneNumberUtils.getCountryCodeAsString(phoneNumber))
                .build();
    }
}
