package com.meals.on.wheels.services;

import com.meals.on.wheels.daos.CustomerDAO;
import com.meals.on.wheels.models.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Iterable<CustomerModel> getAllCustomers() {
        return customerDAO.findAll();
    }
}
