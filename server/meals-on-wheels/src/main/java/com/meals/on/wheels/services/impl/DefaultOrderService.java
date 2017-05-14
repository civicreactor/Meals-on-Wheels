package com.meals.on.wheels.services.impl;

import com.meals.on.wheels.daos.OrderDAO;
import com.meals.on.wheels.enums.OrderStatus;
import com.meals.on.wheels.models.OrderModel;
import com.meals.on.wheels.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class DefaultOrderService implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public OrderModel save(OrderModel order) {
        order.setStatus(OrderStatus.QUEUED);
        order.setOrderedOnDate(new Date(System.currentTimeMillis()));
        return orderDAO.save(order);
    }

}
