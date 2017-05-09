package com.meals.on.wheels.facades;

import com.meals.on.wheels.dtos.DriverDTO;
import com.meals.on.wheels.models.DriverModel;
import com.meals.on.wheels.services.DriverService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class DriverFacade {

    @Autowired
    private DriverService driverService;

    @Autowired
    private Mapper mapper;

    public Iterable<DriverDTO> getAllDrivers(){
        Iterable<DriverModel> driverModels = driverService.getAllMeals();
        Iterable<DriverDTO> driverDTOs = StreamSupport.stream(driverModels.spliterator(), false).map(driverModel -> mapper.map(driverModel , DriverDTO.class)).collect(Collectors.toList());
        return driverDTOs;
    }

    public void addDriver(DriverDTO driver) {
        driverService.saveOrUpdate(mapper.map(driver, DriverModel.class));
    }

    public DriverDTO getDriver(Long driverId) {
        return mapper.map(driverService.getDriverById(driverId), DriverDTO.class);
    }


}
