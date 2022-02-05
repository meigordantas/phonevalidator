package com.jumiaproject.phonevalidator.controller;

import com.jumiaproject.phonevalidator.database.entity.CustomerEntity;
import com.jumiaproject.phonevalidator.dto.PhoneResponseDto;
import com.jumiaproject.phonevalidator.service.CustomerService;
import com.jumiaproject.phonevalidator.service.PhoneValidatorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<List<PhoneResponseDto>> getAllPhonesValidated() {

        return ResponseEntity.ok(useCase.getAllPhonesValidated());
    }
}
