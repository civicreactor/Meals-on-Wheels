package com.meals.on.wheels.facades.impl;

import com.meals.on.wheels.dtos.CustomerDTO;
import com.meals.on.wheels.facades.CustomerFacade;
import com.meals.on.wheels.models.CustomerModel;
import com.meals.on.wheels.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
public class DefaultCustomerFacade extends AbstractFacade implements CustomerFacade {

    @Autowired
    private CustomerService customerService;

    @Override
    public Iterable<CustomerDTO> getAllCustomers() {
        Iterable<CustomerModel> customerModels = customerService.getAllCustomers();
        Iterable<CustomerDTO> customerDTOs = StreamSupport.stream(customerModels.spliterator(), false).map(customerModel -> mapper.map(customerModel , CustomerDTO.class)).collect(Collectors.toList());
        return customerDTOs;
    }

    @Override
    public void addCustomer(CustomerDTO customer) {
        customerService.save(mapper.map(customer, CustomerModel.class));
    }

    @Override
    public CustomerDTO getCustomer(Long customerId) {
        return mapper.map(customerService.getCustomerById(customerId), CustomerDTO.class);
    }
}
