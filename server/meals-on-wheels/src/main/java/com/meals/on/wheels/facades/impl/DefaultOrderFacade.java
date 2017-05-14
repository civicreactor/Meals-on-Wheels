package com.meals.on.wheels.facades.impl;

import com.meals.on.wheels.dtos.OrderDTO;
import com.meals.on.wheels.facades.OrderFacade;
import com.meals.on.wheels.models.OrderModel;
import com.meals.on.wheels.services.OrderService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultOrderFacade extends AbstractFacade implements OrderFacade {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Mapper mapper;


    public OrderDTO saveOrder(OrderDTO order){
        OrderModel savedOrder = orderService.save(mapper.map(order, OrderModel.class));
        return mapper.map(savedOrder, OrderDTO.class);
    }
}
