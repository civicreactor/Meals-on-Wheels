package com.meals.on.wheels.services;

import com.meals.on.wheels.models.CustomerModel;


public interface CustomerService {

    Iterable<CustomerModel> getAllCustomers();

    CustomerModel getCustomerById(Long customerId);

    void save(CustomerModel customer);

}
