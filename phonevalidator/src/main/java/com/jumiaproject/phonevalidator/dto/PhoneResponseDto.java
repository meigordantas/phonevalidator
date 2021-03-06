package com.jumiaproject.phonevalidator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jumiaproject.phonevalidator.enums.CountryCodeEnum;
import com.jumiaproject.phonevalidator.enums.ValidationStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhoneResponseDto {

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("customer_phone_number")
    private String phoneNumber;

    @JsonProperty("phone_number_country_code")
    private String countryCode;

    @JsonProperty("phone_validation_state")
    private ValidationStateEnum validationStateEnum;

    @JsonProperty("phone_number_country")
    private CountryCodeEnum phoneCountry;
}
