package com.jumiaproject.phonevalidator.controller;

import com.jumiaproject.phonevalidator.database.entity.CustomerEntity;
import com.jumiaproject.phonevalidator.dto.PhoneControllerParamsDto;
import com.jumiaproject.phonevalidator.dto.PhoneResponseDto;
import com.jumiaproject.phonevalidator.enums.CountryCodeEnum;
import com.jumiaproject.phonevalidator.enums.ValidationStateEnum;
import com.jumiaproject.phonevalidator.service.CustomerService;
import com.jumiaproject.phonevalidator.service.PhoneValidatorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phone")

@SwaggerDefinition(tags = {
        @Tag(name = "PhoneController")
})
public class PhoneController {

    @Autowired
    private PhoneValidatorService useCase;

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    @ApiOperation(
            value = "Get all customers"
    )
    public ResponseEntity<List<CustomerEntity>> getPhoneList(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("phones")
    @ApiOperation(
            value = "Get all phone numbers with validation status"
    )
    @Validated

    public ResponseEntity<List<PhoneResponseDto>> getAllPhonesValidated(
            @ApiParam(
                    name = "validation-state",
                    value = "Phone number validation state",
                    example = "VALID, INVALID"
            )

            @RequestParam(value = "validation-state", required = false)
            final ValidationStateEnum validationState,

            @ApiParam(
                    name = "country",
                    value = "Phone number country",
                    example = "MOZAMBIQUE"
            )
            @RequestParam(value = "country", required = false) final CountryCodeEnum country
    )
    {
        PhoneControllerParamsDto controllerParams;

        if(country != null || validationState != null) {
            controllerParams = PhoneControllerParamsDto.builder()
                    .country(country)
                    .validationState(validationState)
                    .build();
        } else {controllerParams = null;}


        return ResponseEntity.ok(useCase.getAllPhonesValidated(controllerParams));
    }
}
