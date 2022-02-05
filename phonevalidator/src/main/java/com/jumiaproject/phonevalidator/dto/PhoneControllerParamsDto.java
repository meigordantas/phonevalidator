package com.jumiaproject.phonevalidator.dto;

import com.jumiaproject.phonevalidator.enums.CountryCodeEnum;
import com.jumiaproject.phonevalidator.enums.ValidationStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhoneControllerParamsDto {

    CountryCodeEnum country;
    ValidationStateEnum validationState;
}
