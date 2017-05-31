package com.meals.on.wheels.services;

import com.meals.on.wheels.daos.CustomerDAO;
import com.meals.on.wheels.models.CustomerModel;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultCustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerDAO customerDAO;

    @MockBean
    private CustomerModel customerModel;


    @Test
    public void getAllCustomersNoResults(){
        // setup
        when(customerDAO.findAll()).thenReturn(Collections.emptyList());
        // call
        Iterable<CustomerModel> customers = customerService.getAllCustomers();
        // tests
        assertNotNull(customers);
        assertEquals(CollectionUtils.size(customers), 0);
        verify(customerDAO, times(1)).findAll();
    }

    @Test
    public void getAllCustomersFoundResults(){
        // setup
        when(customerDAO.findAll()).thenReturn(Collections.singletonList(customerModel));
        // call
        Iterable<CustomerModel> customers = customerService.getAllCustomers();
        // tests
        assertNotNull(customers);
        assertEquals(CollectionUtils.size(customers), 1);
        verify(customerDAO, times(1)).findAll();
    }

    @Test
    public void getCustomerNoMatchFound(){
        // setup
        when(customerDAO.findOne(isA(Long.class))).thenReturn(null);
        // call
        CustomerModel customer = customerService.getCustomerById(1L);
        // tests
        assertNull(customer);
        verify(customerDAO, times(1)).findOne(isA(Long.class));
    }

    @Test
    public void getCustomerMatchFound(){
        // setup
        when(customerDAO.findOne(isA(Long.class))).thenReturn(customerModel);
        // call
        CustomerModel customer = customerService.getCustomerById(1L);
        // tests
        assertNotNull(customer);
        assertEquals(customer, customerModel);
        verify(customerDAO, times(1)).findOne(isA(Long.class));
    }

    @Test
    public void addCustomerSuccess(){
        // setup
        when(customerDAO.save(isA(CustomerModel.class))).thenReturn(customerModel);
        // call
        customerService.save(customerModel);
        // tests
        verify(customerDAO, times(1)).save(isA(CustomerModel.class));
    }

    @Test(expected = Exception.class)
    public void addCustomerFailure() {
        // setup
        doThrow(new Exception()).when(customerDAO).save(isA(CustomerModel.class));
        // call
        customerService.save(customerModel);
        // tests
        verify(customerDAO, times(1)).save(isA(CustomerModel.class));
    }
}
