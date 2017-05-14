package com.meals.on.wheels.dtos;

import com.meals.on.wheels.enums.OrderStatus;
import com.meals.on.wheels.models.CustomerModel;
import com.meals.on.wheels.models.DriverModel;
import com.meals.on.wheels.models.MealModel;

import java.sql.Date;

public class OrderDTO {

    private Long id;
    private MealModel meal;
    private CustomerModel customer;
    private DriverModel driver;
    private OrderStatus status;
    private Date deliveredDate;
    private Date assignationDate;
    private Date orderedOnDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MealModel getMeal() {
        return meal;
    }

    public void setMeal(MealModel meal) {
        this.meal = meal;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public DriverModel getDriver() {
        return driver;
    }

    public void setDriver(DriverModel driver) {
        this.driver = driver;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public Date getAssignationDate() {
        return assignationDate;
    }

    public void setAssignationDate(Date assignationDate) {
        this.assignationDate = assignationDate;
    }

    public Date getOrderedOnDate() {
        return orderedOnDate;
    }

    public void setOrderedOnDate(Date orderedOnDate) {
        this.orderedOnDate = orderedOnDate;
    }
}
