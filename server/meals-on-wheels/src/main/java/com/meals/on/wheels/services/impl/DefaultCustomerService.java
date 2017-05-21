package com.meals.on.wheels.services.impl;

import com.meals.on.wheels.daos.CustomerDAO;
import com.meals.on.wheels.models.CustomerModel;
import com.meals.on.wheels.services.CustomerService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerService implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Iterable<CustomerModel> getAllCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public CustomerModel getCustomerById(Long customerId) {
        return customerDAO.findOne(customerId);
    }

    @Override
    public void save(CustomerModel customer) {
        customerDAO.save(customer);
    }
}
