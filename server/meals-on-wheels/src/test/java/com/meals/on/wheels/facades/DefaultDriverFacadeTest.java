package com.meals.on.wheels.facades;

import com.meals.on.wheels.dtos.DriverDTO;
import com.meals.on.wheels.models.DriverModel;
import com.meals.on.wheels.services.DriverService;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultDriverFacadeTest {

    @Autowired
    private DriverFacade driverFacade;

    @MockBean
    private DriverService driverService;

    @MockBean
    private Mapper mapper;

    @MockBean
    private DriverDTO driverDTO;

    @MockBean
    private DriverModel driverModel;


    @Test
    public void getAllDriversNoResults(){
        // setup
        when(driverService.getAllDrivers()).thenReturn(Collections.emptyList());
        // call
        Iterable<DriverDTO> drivers = driverFacade.getAllDrivers();
        // tests
        assertNotNull(drivers);
        assertEquals(CollectionUtils.size(drivers), 0);
        verify(driverService, times(1)).getAllDrivers();
    }

    @Test
    public void getAllDriversFoundResults(){
        // setup
        when(driverService.getAllDrivers()).thenReturn(Collections.singletonList(driverModel));
        // call
        Iterable<DriverDTO> drivers = driverFacade.getAllDrivers();
        // tests
        assertNotNull(drivers);
        assertEquals(CollectionUtils.size(drivers), 1);
        verify(driverService, times(1)).getAllDrivers();
    }

    @Test
    public void getDriverNoMatchFound(){
        // setup
        when(driverService.getDriverById(isA(Long.class))).thenReturn(null);
        // call
        DriverDTO driver = driverFacade.getDriver(1L);
        // tests
        assertNull(driver);
        verify(driverService, times(1)).getDriverById(isA(Long.class));
    }

    @Test
    public void getDriverMatchFound(){
        // setup
        when(driverService.getDriverById(isA(Long.class))).thenReturn(driverModel);
        when(mapper.map(isA(DriverModel.class), eq(DriverDTO.class))).thenReturn(driverDTO);
        // call
        DriverDTO driver = driverFacade.getDriver(1L);
        // tests
        assertNotNull(driver);
        assertEquals(driver, driverDTO);
        verify(driverService, times(1)).getDriverById(isA(Long.class));
        verify(mapper).map(isA(DriverModel.class), eq(DriverDTO.class));
    }

    @Test
    public void addDriverSuccess() {
        // setup
        doNothing().when(driverService).save(isA(DriverModel.class));
        when(mapper.map(isA(DriverDTO.class), eq(DriverModel.class))).thenReturn(driverModel);
        // call
        driverFacade.addDriver(driverDTO);
        // tests
        verify(driverService, times(1)).save(isA(DriverModel.class));
        verify(mapper).map(isA(DriverDTO.class), eq(DriverModel.class));
    }

    @Test(expected = Exception.class)
    public void addDriverFailure() {
        // setup
        doThrow(new Exception()).when(driverService).save(isA(DriverModel.class));
        // call
        driverFacade.addDriver(driverDTO);
        // tests
        verify(driverService, times(1)).save(isA(DriverModel.class));
    }

}
