package com.jumiaproject.phonevalidator.service;

import com.jumiaproject.phonevalidator.database.entity.CustomerEntity;
import com.jumiaproject.phonevalidator.dto.PhoneControllerParamsDto;
import com.jumiaproject.phonevalidator.dto.PhoneResponseDto;
import com.jumiaproject.phonevalidator.enums.CountryCodeEnum;
import com.jumiaproject.phonevalidator.enums.ValidationState;
import com.jumiaproject.phonevalidator.utils.PhoneNumberUtils;
import com.jumiaproject.phonevalidator.validator.PhoneValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneValidatorService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PhoneValidatorFactory validatorFactory;

    public List<PhoneResponseDto> getAllPhonesValidated(PhoneControllerParamsDto controllerParams) {
        var allCustomers = customerService.findAll();

        var firstPhone = allCustomers.stream().findFirst().get();

        List<PhoneResponseDto> returnList = new ArrayList<PhoneResponseDto>();

        var phoneList = allCustomers.stream()
                .map(this::getResponseDto)
                .collect(Collectors.toList());

        if(controllerParams != null) {
            returnList = controllerParams.getCountry() != null ?
                    phoneList.stream().filter(p -> p.getPhoneCountry().equals(controllerParams.getCountry()))
                    .collect(Collectors.toList()) : phoneList;

            returnList = controllerParams.getValidationState() != null ?
                    returnList.stream().filter(p -> p.getValidationState().equals(controllerParams.getValidationState()))
                    .collect(Collectors.toList()) : returnList;
        }

        return returnList;

    }

    private ValidationState validatePhoneNumber(CustomerEntity customer) {
        var customerPhoneNumber = customer.getCustomerPhone();
        var validatorClass = this.validatorFactory.create(customerPhoneNumber);

        return validatorClass.validate(customerPhoneNumber);
    }

    private PhoneResponseDto getResponseDto (CustomerEntity customer) {
        var phoneNumber = customer.getCustomerPhone();
        return PhoneResponseDto.builder()
                .phoneNumber(phoneNumber)
                .validationState(validatePhoneNumber(customer))
                .phoneCountry(CountryCodeEnum.valueOf(PhoneNumberUtils.getCountryCodeAsInteger(phoneNumber))
                .orElse(CountryCodeEnum.UNKNOWN))
                .countryCode(PhoneNumberUtils.getCountryCodeAsString(phoneNumber))
                .build();
    }
}
