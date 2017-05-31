package com.meals.on.wheels.services;

import com.meals.on.wheels.daos.OrderDAO;
import com.meals.on.wheels.dtos.OrderDTO;
import com.meals.on.wheels.models.OrderModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultOrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderDAO orderDAO;

    @MockBean
    private OrderModel orderModel;

    @Test
    public void saveOrderSuccess(){
        // setup
        when(orderDAO.save(isA(OrderModel.class))).thenReturn(orderModel);
        // call
        orderService.save(orderModel);
        // tests
        verify(orderDAO, times(1)).save(isA(OrderModel.class));
    }

    @Test(expected = Exception.class)
    public void saveOrderFailure() {
        // setup
        doThrow(new Exception()).when(orderDAO).save(isA(OrderModel.class));
        // call
        orderService.save(orderModel);
        // tests
        verify(orderDAO, times(1)).save(isA(OrderModel.class));
    }
}
