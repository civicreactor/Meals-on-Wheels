package com.meals.on.wheels.facades;

import com.meals.on.wheels.dtos.OrderDTO;
import com.meals.on.wheels.models.OrderModel;
import com.meals.on.wheels.services.OrderService;
import org.dozer.Mapper;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultOrderFacadeTest {

    @Autowired
    private OrderFacade orderFacade;

    @MockBean
    private OrderService orderService;

    @MockBean
    private Mapper mapper;

    @MockBean
    private OrderDTO orderDTO;

    @MockBean
    private OrderModel orderModel;

    @Test
    public void saveOrderSuccess(){
        // setup
        when(orderService.save(isA(OrderModel.class))).thenReturn(orderModel);
        when(mapper.map(isA(OrderDTO.class), eq(OrderModel.class))).thenReturn(orderModel);
        // call
        orderFacade.saveOrder(orderDTO);
        // tests
        InOrder inOrder = inOrder(orderService, mapper);
        inOrder.verify(mapper).map(isA(OrderDTO.class), eq(OrderModel.class));
        inOrder.verify(orderService, times(1)).save(isA(OrderModel.class));
    }

    @Test(expected = Exception.class)
    public void saveOrderFailure() {
        // setup
        doThrow(new Exception()).when(orderService).save(isA(OrderModel.class));
        // call
        orderFacade.saveOrder(orderDTO);
        // tests
        verify(orderService, times(1)).save(isA(OrderModel.class));
    }
}
