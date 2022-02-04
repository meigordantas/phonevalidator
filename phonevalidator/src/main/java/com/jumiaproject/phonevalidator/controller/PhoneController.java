package com.jumiaproject.phonevalidator.controller;

import com.jumiaproject.phonevalidator.database.entity.CustomerEntity;
import com.jumiaproject.phonevalidator.dto.PhoneResponseDto;
import com.jumiaproject.phonevalidator.service.CustomerService;
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
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<CustomerEntity>> getPhoneList(){
        var returnValue = customerService.findAll();
        return ResponseEntity.ok(returnValue);
    }
}
