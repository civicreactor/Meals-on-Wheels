package com.meals.on.wheels.models;

import com.meals.on.wheels.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "ORDERS")
public class OrderModel implements Serializable {

    @Id
    @Column( name= "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEAL_ID")
    private MealModel meal;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerModel customer;

    @ManyToOne
    @JoinColumn(name = "DRIVER_ID")
    private DriverModel driver;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Date deliveredDate;
    private Date assignationDate;



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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public DriverModel getDriver() {
        return driver;
    }

    public void setDriver(DriverModel driver) {
        this.driver = driver;
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
}
