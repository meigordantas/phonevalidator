package com.jumiaproject.phonevalidator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jumiaproject.phonevalidator.database.entity.CustomerEntity;
import com.jumiaproject.phonevalidator.enums.CountryCodeEnum;
import com.jumiaproject.phonevalidator.enums.PhoneState;
import com.jumiaproject.phonevalidator.utils.PhoneNumberUtils;
import com.jumiaproject.phonevalidator.validator.PhoneValidatorFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhoneResponseDto {

    @JsonProperty("customer_phone_number")
    private String phoneNumber;

    @JsonProperty("phone_number_country_code")
    private String countryCode;

    @JsonProperty("phone_validation_state")
    private PhoneState phoneState;

    @JsonProperty("phone_number_country")
    private CountryCodeEnum phoneCountry;
}
