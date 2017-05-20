package com.meals.on.wheels.facades;


import com.meals.on.wheels.dtos.CustomerDTO;
import com.meals.on.wheels.facades.impl.DefaultCustomerFacade;
import com.meals.on.wheels.models.CustomerModel;
import com.meals.on.wheels.services.impl.DefaultCustomerService;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class DefaultCustomerFacadeTest {

    @InjectMocks
    private DefaultCustomerFacade customerFacade;

    @Mock
    private DefaultCustomerService customerService;

    @Mock
    private Mapper mapper;



    @Test
    public void getAllCustomersNoResults(){
        // setup
        when(customerService.getAllCustomers()).thenReturn(Collections.emptyList());
        // call
        Iterable<CustomerDTO> customers = customerFacade.getAllCustomers();
        // tests
        assertNotNull(customers);
        assertEquals(CollectionUtils.size(customers), 0);
        verify(customerService).getAllCustomers();
    }

    @Test
    public void getAllCustomersFoundResults(){
        // setup
        when(customerService.getAllCustomers()).thenReturn(Collections.singletonList(new CustomerModel()));
        // call
        Iterable<CustomerDTO> customers = customerFacade.getAllCustomers();
        // tests
        assertNotNull(customers);
        assertEquals(CollectionUtils.size(customers), 1);
        verify(customerService).getAllCustomers();
    }

    @Test
    public void getCustomerNoMatchFound(){
        // setup
        when(customerService.getCustomerById(isA(Long.class))).thenReturn(null);
        // call
        CustomerDTO customer = customerFacade.getCustomer(anyLong());
        // tests
        assertNull(customer);
        verify(customerService).getCustomerById(isA(Long.class));
    }

    @Test
    public void getCustomerMatchFound(){
        // setup
        when(customerService.getCustomerById(isA(Long.class))).thenReturn(new CustomerModel());
        when(mapper.map(isA(CustomerModel.class), eq(CustomerDTO.class))).thenReturn(new CustomerDTO());
        // call
        CustomerDTO customer = customerFacade.getCustomer(anyLong());
        // tests
        assertNotNull(customer);
        verify(customerService).getCustomerById(isA(Long.class));
        verify(mapper).map(isA(CustomerModel.class), eq(CustomerDTO.class));
    }

    public void addCustomer(){
        // setup

    }
}
