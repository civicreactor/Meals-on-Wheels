package com.meals.on.wheels.controllers;

import com.meals.on.wheels.facades.CustomerFacade;
import com.meals.on.wheels.models.CustomerModel;
import com.meals.on.wheels.models.MealModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;

    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<CustomerModel>> getCustomers() {
       return ResponseEntity.ok(customerFacade.getAllCustomers());
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addCustomer(@RequestBody CustomerModel customer) {
        customerFacade.addCustomer(customer);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(
            value = "/{customerId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerModel> getCustomer(@PathVariable(value="customerId") Long customerId) {
        CustomerModel customerModel = customerFacade.getCustomer(customerId);
        return ResponseEntity.ok(customerModel);
    }
}
