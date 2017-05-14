package com.meals.on.wheels.facades;

import com.meals.on.wheels.dtos.DriverDTO;

public interface DriverFacade {

    Iterable<DriverDTO> getAllDrivers();

    void addDriver(DriverDTO driver);

    DriverDTO getDriver(Long driverId);
}
