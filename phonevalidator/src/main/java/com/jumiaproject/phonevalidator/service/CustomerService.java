package com.jumiaproject.phonevalidator.service;

import com.jumiaproject.phonevalidator.database.entity.CustomerEntity;
import com.jumiaproject.phonevalidator.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> findAll(){
        return customerRepository.findAll();
    }

}
