package com.meals.on.wheels.facades;


import com.meals.on.wheels.dtos.CustomerDTO;
import com.meals.on.wheels.models.CustomerModel;
import com.meals.on.wheels.services.CustomerService;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
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
public class DefaultCustomerFacadeTest {

    @Autowired
    private CustomerFacade customerFacade;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private Mapper mapper;

    @MockBean
    private CustomerModel customerModel;

    @MockBean
    private CustomerDTO customerDTO;

    @Test
    public void getAllCustomersNoResults(){
        // setup
        when(customerService.getAllCustomers()).thenReturn(Collections.emptyList());
        // call
        Iterable<CustomerDTO> customers = customerFacade.getAllCustomers();
        // tests
        assertNotNull(customers);
        assertEquals(CollectionUtils.size(customers), 0);
        verify(customerService, times(1)).getAllCustomers();
    }

    @Test
    public void getAllCustomersFoundResults(){
        // setup
        when(customerService.getAllCustomers()).thenReturn(Collections.singletonList(customerModel));
        // call
        Iterable<CustomerDTO> customers = customerFacade.getAllCustomers();
        // tests
        assertNotNull(customers);
        assertEquals(CollectionUtils.size(customers), 1);
        verify(customerService, times(1)).getAllCustomers();
    }

    @Test
    public void getCustomerNoMatchFound(){
        // setup
        when(customerService.getCustomerById(isA(Long.class))).thenReturn(null);
        // call
        CustomerDTO customer = customerFacade.getCustomer(1L);
        // tests
        assertNull(customer);
        verify(customerService, times(1)).getCustomerById(isA(Long.class));
    }

    @Test
    public void getCustomerMatchFound(){
        // setup
        when(customerService.getCustomerById(isA(Long.class))).thenReturn(customerModel);
        when(mapper.map(isA(CustomerModel.class), eq(CustomerDTO.class))).thenReturn(customerDTO);
        // call
        CustomerDTO customer = customerFacade.getCustomer(1L);
        // tests
        assertNotNull(customer);
        assertEquals(customer, customerDTO);
        verify(customerService, times(1)).getCustomerById(isA(Long.class));
        verify(mapper).map(isA(CustomerModel.class), eq(CustomerDTO.class));
    }

    @Test
    public void addCustomerSuccess(){
        // setup
        doNothing().when(customerService).save(isA(CustomerModel.class));
        when(mapper.map(isA(CustomerDTO.class), eq(CustomerModel.class))).thenReturn(customerModel);
        // call
        customerFacade.addCustomer(customerDTO);
        // tests
        verify(customerService, times(1)).save(isA(CustomerModel.class));
        verify(mapper).map(isA(CustomerDTO.class), eq(CustomerModel.class));
    }

    @Test(expected = Exception.class)
    public void addCustomerFailure() {
        // setup
        doThrow(new Exception()).when(customerService).save(isA(CustomerModel.class));
        // call
        customerFacade.addCustomer(customerDTO);
        // tests
        verify(customerService, times(1)).save(isA(CustomerModel.class));
    }

}
