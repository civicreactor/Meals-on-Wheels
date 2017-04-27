package com.meals.on.wheels.controllers;

import com.meals.on.wheels.facades.CustomerFacade;
import com.meals.on.wheels.models.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
