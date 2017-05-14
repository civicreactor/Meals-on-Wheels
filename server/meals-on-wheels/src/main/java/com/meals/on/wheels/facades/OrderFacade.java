package com.meals.on.wheels.facades;

import com.meals.on.wheels.dtos.OrderDTO;


public interface OrderFacade {

    OrderDTO saveOrder(OrderDTO order);
}
