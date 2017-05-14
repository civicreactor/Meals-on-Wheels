package com.meals.on.wheels.facades;

import com.meals.on.wheels.dtos.CustomerDTO;

public interface CustomerFacade {

    Iterable<CustomerDTO> getAllCustomers();

    void addCustomer(CustomerDTO customer);


    CustomerDTO getCustomer(Long customerId);

}
