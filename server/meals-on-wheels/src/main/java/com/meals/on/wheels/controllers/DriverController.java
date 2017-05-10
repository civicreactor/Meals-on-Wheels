package com.meals.on.wheels.controllers;

import com.meals.on.wheels.dtos.DriverDTO;
import com.meals.on.wheels.facades.DriverFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverFacade driverFacade;

    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<DriverDTO>> getDrivers() {
        return ResponseEntity.ok(driverFacade.getAllDrivers());
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addDriver(@RequestBody DriverDTO driver) {
        driverFacade.addDriver(driver);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(
            value = "/{driverId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DriverDTO> getDriver(@PathVariable(value="driverId") Long driverId) {
        DriverDTO driver = driverFacade.getDriver(driverId);
        return ResponseEntity.ok(driver);
    }


}
