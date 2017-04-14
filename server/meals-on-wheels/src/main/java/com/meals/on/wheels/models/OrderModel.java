package com.meals.on.wheels.models;

import javax.persistence.*;
import java.io.Serializable;

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

    @Enumerated(EnumType.STRING)
    private OrderStatus status;



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
}
