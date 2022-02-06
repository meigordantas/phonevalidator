package com.jumiaproject.phonevalidator.controller;

import com.jumiaproject.phonevalidator.dto.PhoneControllerParamsDto;
import com.jumiaproject.phonevalidator.enums.CountryCodeEnum;
import com.jumiaproject.phonevalidator.enums.ValidationStateEnum;
import com.jumiaproject.phonevalidator.service.PhoneValidatorService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.stream.Collectors;

@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PhoneValidatorServiceTest {

    @Autowired
    PhoneValidatorService validatorService;

    @Test
    public void shouldReturnOnlyValidUgandaNumbers() {
        var controllerParams = PhoneControllerParamsDto.builder()
                .validationState(ValidationStateEnum.VALID)
                .country(CountryCodeEnum.UGANDA)
                .build();

        var phoneList = validatorService.getAllPhonesValidated(controllerParams);

        Assert.assertEquals(
                phoneList.stream()
                .filter(p -> p.getPhoneCountry().equals(CountryCodeEnum.UGANDA))
                        .filter(p -> p.getValidationStateEnum().equals(ValidationStateEnum.VALID))
                .collect(Collectors.toList()).size(), phoneList.size()
        );
    }

    @Test
    public void shouldReturnOnlyValidMozambiqueNumbers() {
        var controllerParams = PhoneControllerParamsDto.builder()
                .validationState(ValidationStateEnum.VALID)
                .country(CountryCodeEnum.MOZAMBIQUE)
                .build();

        var phoneList = validatorService.getAllPhonesValidated(controllerParams);

        Assert.assertEquals(
                phoneList.stream()
                        .filter(p -> p.getPhoneCountry().equals(CountryCodeEnum.MOZAMBIQUE))
                        .filter(p -> p.getValidationStateEnum().equals(ValidationStateEnum.VALID))
                        .collect(Collectors.toList()).size(), phoneList.size()
        );
    }

    @Test
    public void shouldReturnOnlyValidMoroccoNumbers() {
        var controllerParams = PhoneControllerParamsDto.builder()
                .validationState(ValidationStateEnum.VALID)
                .country(CountryCodeEnum.MOROCCO)
                .build();

        var phoneList = validatorService.getAllPhonesValidated(controllerParams);

        Assert.assertEquals(
                phoneList.stream()
                        .filter(p -> p.getPhoneCountry().equals(CountryCodeEnum.MOROCCO))
                        .filter(p -> p.getValidationStateEnum().equals(ValidationStateEnum.VALID))
                        .collect(Collectors.toList()).size(), phoneList.size()
        );
    }

    @Test
    public void shouldReturnOnlyValidEthiopiaNumbers() {
        var controllerParams = PhoneControllerParamsDto.builder()
                .validationState(ValidationStateEnum.VALID)
                .country(CountryCodeEnum.ETHIOPIA)
                .build();

        var phoneList = validatorService.getAllPhonesValidated(controllerParams);

        Assert.assertEquals(
                phoneList.stream()
                        .filter(p -> p.getPhoneCountry().equals(CountryCodeEnum.ETHIOPIA))
                        .filter(p -> p.getValidationStateEnum().equals(ValidationStateEnum.VALID))
                        .collect(Collectors.toList()).size(), phoneList.size()
        );
    }

    @Test
    public void shouldReturnOnlyValidCameroonNumbers() {
        var controllerParams = PhoneControllerParamsDto.builder()
                .validationState(ValidationStateEnum.VALID)
                .country(CountryCodeEnum.CAMEROON)
                .build();

        var phoneList = validatorService.getAllPhonesValidated(controllerParams);

        Assert.assertEquals(
                phoneList.stream()
                        .filter(p -> p.getPhoneCountry().equals(CountryCodeEnum.CAMEROON))
                        .filter(p -> p.getValidationStateEnum().equals(ValidationStateEnum.VALID))
                        .collect(Collectors.toList()).size(), phoneList.size()
        );
    }

    @Test
    public void shouldReturnOnlyInvalidUgandaNumbers() {
        var controllerParams = PhoneControllerParamsDto.builder()
                .validationState(ValidationStateEnum.INVALID)
                .country(CountryCodeEnum.UGANDA)
                .build();

        var phoneList = validatorService.getAllPhonesValidated(controllerParams);

        Assert.assertEquals(
                phoneList.stream()
                        .filter(p -> p.getPhoneCountry().equals(CountryCodeEnum.UGANDA))
                        .filter(p -> p.getValidationStateEnum().equals(ValidationStateEnum.INVALID))
                        .collect(Collectors.toList()).size(), phoneList.size()
        );
    }

    @Test
    public void shouldReturnOnlyInvalidMozambiqueNumbers() {
        var controllerParams = PhoneControllerParamsDto.builder()
                .validationState(ValidationStateEnum.INVALID)
                .country(CountryCodeEnum.MOZAMBIQUE)
                .build();

        var phoneList = validatorService.getAllPhonesValidated(controllerParams);

        Assert.assertEquals(
                phoneList.stream()
                        .filter(p -> p.getPhoneCountry().equals(CountryCodeEnum.MOZAMBIQUE))
                        .filter(p -> p.getValidationStateEnum().equals(ValidationStateEnum.INVALID))
                        .collect(Collectors.toList()).size(), phoneList.size()
        );
    }

    @Test
    public void shouldReturnOnlyInvalidMoroccoNumbers() {
        var controllerParams = PhoneControllerParamsDto.builder()
                .validationState(ValidationStateEnum.INVALID)
                .country(CountryCodeEnum.MOROCCO)
                .build();

        var phoneList = validatorService.getAllPhonesValidated(controllerParams);

        Assert.assertEquals(
                phoneList.stream()
                        .filter(p -> p.getPhoneCountry().equals(CountryCodeEnum.MOROCCO))
                        .filter(p -> p.getValidationStateEnum().equals(ValidationStateEnum.INVALID))
                        .collect(Collectors.toList()).size(), phoneList.size()
        );
    }

    @Test
    public void shouldReturnOnlyInvalidEthiopiaNumbers() {
        var controllerParams = PhoneControllerParamsDto.builder()
                .validationState(ValidationStateEnum.INVALID)
                .country(CountryCodeEnum.ETHIOPIA)
                .build();

        var phoneList = validatorService.getAllPhonesValidated(controllerParams);

        Assert.assertEquals(
                phoneList.stream()
                        .filter(p -> p.getPhoneCountry().equals(CountryCodeEnum.ETHIOPIA))
                        .filter(p -> p.getValidationStateEnum().equals(ValidationStateEnum.INVALID))
                        .collect(Collectors.toList()).size(), phoneList.size()
        );
    }

    @Test
    public void shouldReturnOnlyInvalidCameroonNumbers() {
        var controllerParams = PhoneControllerParamsDto.builder()
                .validationState(ValidationStateEnum.INVALID)
                .country(CountryCodeEnum.CAMEROON)
                .build();

        var phoneList = validatorService.getAllPhonesValidated(controllerParams);

        Assert.assertEquals(
                phoneList.stream()
                        .filter(p -> p.getPhoneCountry().equals(CountryCodeEnum.CAMEROON))
                        .filter(p -> p.getValidationStateEnum().equals(ValidationStateEnum.INVALID))
                        .collect(Collectors.toList()).size(), phoneList.size()
        );
    }
}
