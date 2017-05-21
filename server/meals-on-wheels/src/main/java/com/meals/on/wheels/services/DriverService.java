package com.meals.on.wheels.services;

import com.meals.on.wheels.models.DriverModel;


public interface DriverService {

     Iterable<DriverModel> getAllDrivers();

     void save(DriverModel driver);

     DriverModel getDriverById(Long mealId);
}
