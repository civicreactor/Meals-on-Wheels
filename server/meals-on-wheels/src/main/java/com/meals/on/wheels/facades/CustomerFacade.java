package com.meals.on.wheels.facades;

import com.meals.on.wheels.services.CustomerService;
import com.meals.on.wheels.models.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerFacade {

    @Autowired
    private CustomerService customerService;

    public Iterable<CustomerModel> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    public void addCustomer(CustomerModel customer) {
        customerService.saveOrUpdate(customer);
    }

    public CustomerModel getCustomer(Long customerId) {
        return customerService.getCustomerById(customerId);
    }
}
