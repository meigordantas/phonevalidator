package com.jumiaproject.phonevalidator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneResponseDto {

    private String phoneNumber;

    private String phoneState;

    private String phoneCategory;
}
