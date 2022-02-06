package com.jumiaproject.phonevalidator.service;

import com.jumiaproject.phonevalidator.database.entity.CustomerEntity;
import com.jumiaproject.phonevalidator.dto.PhoneControllerParamsDto;
import com.jumiaproject.phonevalidator.dto.PhoneResponseDto;
import com.jumiaproject.phonevalidator.enums.CountryCodeEnum;
import com.jumiaproject.phonevalidator.enums.ValidationStateEnum;
import com.jumiaproject.phonevalidator.utils.PhoneNumberUtils;
import com.jumiaproject.phonevalidator.validator.PhoneValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PhoneValidatorService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PhoneValidatorFactory validatorFactory;

    public List<PhoneResponseDto> getAllPhonesValidated(PhoneControllerParamsDto controllerParams) {

        try {
            var allCustomers = customerService.findAll();

            List<PhoneResponseDto> returnList = new ArrayList<PhoneResponseDto>();

            var phoneList = allCustomers.stream()
                    .map(this::getResponseDto)
                    .collect(Collectors.toList());

            if (controllerParams != null) {
                returnList = controllerParams.getCountry() != null ? phoneList.stream().filter(
                        p -> p.getPhoneCountry().equals(controllerParams.getCountry()))
                        .collect(Collectors.toList()) : phoneList;

                returnList = controllerParams.getValidationState() != null ?  returnList.stream().filter(
                        p -> p.getValidationStateEnum().equals(controllerParams.getValidationState()))
                                .collect(Collectors.toList()) : returnList;
            }

            return returnList;
        } catch (Exception e) {
            log.error("class=PhonValidatorService, method=getAllPhonesValidated");
            throw  e;
        }

    }

    private ValidationStateEnum validatePhoneNumber(CustomerEntity customer) {
        var customerPhoneNumber = customer.getCustomerPhone();
        var validatorClass = this.validatorFactory.create(customerPhoneNumber);

        return validatorClass.validate(customerPhoneNumber);
    }

    private PhoneResponseDto getResponseDto (CustomerEntity customer) {
        var phoneNumber = customer.getCustomerPhone();
        return PhoneResponseDto.builder()
                .phoneNumber(phoneNumber)
                .validationStateEnum(validatePhoneNumber(customer))
                .phoneCountry(CountryCodeEnum.valueOf(PhoneNumberUtils.getCountryCodeAsInteger(phoneNumber))
                .orElse(CountryCodeEnum.UNKNOWN))
                .countryCode(PhoneNumberUtils.getCountryCodeAsString(phoneNumber))
                .build();
    }
}
