package com.meals.on.wheels.enums;


public enum OrderStatus {

    DELIVERED,
    ABORTED,
    ON_THE_WAY, /* When the order has been assigned to a driver */
    QUEUED; /* When the order as been recorded by the charity */
}
