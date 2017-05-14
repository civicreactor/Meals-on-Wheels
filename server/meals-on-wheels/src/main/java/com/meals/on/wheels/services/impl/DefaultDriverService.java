package com.meals.on.wheels.services.impl;

import com.meals.on.wheels.daos.DriverDAO;
import com.meals.on.wheels.models.DriverModel;
import com.meals.on.wheels.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDriverService implements DriverService {

    @Autowired
    private DriverDAO driverDAO;

    public Iterable<DriverModel> getAllMeals() {
        return driverDAO.findAll();
    }

    public void save(DriverModel driver) {
        driverDAO.save(driver);
    }

    public DriverModel getDriverById(Long mealId) {
        return driverDAO.findOne(mealId);
    }


}
