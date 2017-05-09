package com.meals.on.wheels.services;

import com.meals.on.wheels.daos.DriverDAO;
import com.meals.on.wheels.models.DriverModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private DriverDAO driverDAO;

    public Iterable<DriverModel> getAllMeals() {
        return driverDAO.findAll();
    }

    public void saveOrUpdate(DriverModel driver) {
        driverDAO.save(driver);
    }

    public DriverModel getDriverById(Long mealId) {
        return driverDAO.findOne(mealId);
    }


}
