package com.meals.on.wheels.facades.impl;

import com.meals.on.wheels.dtos.DriverDTO;
import com.meals.on.wheels.facades.DriverFacade;
import com.meals.on.wheels.models.DriverModel;
import com.meals.on.wheels.services.DriverService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class DefaultDriverFacade extends AbstractFacade implements DriverFacade {

    @Autowired
    private DriverService driverService;


    @Override
    public Iterable<DriverDTO> getAllDrivers(){
        Iterable<DriverModel> driverModels = driverService.getAllDrivers();
        Iterable<DriverDTO> driverDTOs = StreamSupport.stream(driverModels.spliterator(), false).map(driverModel -> mapper.map(driverModel , DriverDTO.class)).collect(Collectors.toList());
        return driverDTOs;
    }

    @Override
    public void addDriver(DriverDTO driver) {
        driverService.save(mapper.map(driver, DriverModel.class));
    }

    @Override
    public DriverDTO getDriver(Long driverId) {
        return mapper.map(driverService.getDriverById(driverId), DriverDTO.class);
    }


}
