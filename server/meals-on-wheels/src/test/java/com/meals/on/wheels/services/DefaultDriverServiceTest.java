package com.meals.on.wheels.services;

import com.meals.on.wheels.daos.DriverDAO;
import com.meals.on.wheels.dtos.DriverDTO;
import com.meals.on.wheels.models.DriverModel;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultDriverServiceTest {

    @Autowired
    private DriverService driverService;

    @MockBean
    private DriverDAO driverDAO;

    @MockBean
    private DriverModel driverModel;

    @Test
    public void getAllDriversNoResults(){
        // setup
        when(driverDAO.findAll()).thenReturn(Collections.emptyList());
        // call
        Iterable<DriverModel> drivers = driverService.getAllDrivers();
        // tests
        assertNotNull(drivers);
        assertEquals(CollectionUtils.size(drivers), 0);
        verify(driverDAO, times(1)).findAll();
    }

    @Test
    public void getAllDriversFoundResults(){
        // setup
        when(driverDAO.findAll()).thenReturn(Collections.singletonList(driverModel));
        // call
        Iterable<DriverModel> drivers = driverService.getAllDrivers();
        // tests
        assertNotNull(drivers);
        assertEquals(CollectionUtils.size(drivers), 1);
        verify(driverDAO, times(1)).findAll();
    }

    @Test
    public void getDriverNoMatchFound(){
        // setup
        when(driverDAO.findOne(isA(Long.class))).thenReturn(null);
        // call
        DriverModel driver = driverService.getDriverById(1L);
        // tests
        assertNull(driver);
        verify(driverDAO, times(1)).findOne(isA(Long.class));
    }

    @Test
    public void getDriverMatchFound(){
        // setup
        when(driverDAO.findOne(isA(Long.class))).thenReturn(driverModel);
        // call
        DriverModel driver = driverService.getDriverById(1L);
        // tests
        assertNotNull(driver);
        assertEquals(driver, driverModel);
        verify(driverDAO, times(1)).findOne(isA(Long.class));
    }

    @Test
    public void addDriverSuccess() {
        // setup
        when(driverDAO.save(isA(DriverModel.class))).thenReturn(driverModel);
        // call
        driverService.save(driverModel);
        // tests
        verify(driverDAO, times(1)).save(isA(DriverModel.class));
    }

    @Test(expected = Exception.class)
    public void addDriverFailure() {
        // setup
        doThrow(new Exception()).when(driverDAO).save(isA(DriverModel.class));
        // call
        driverService.save(driverModel);
        // tests
        verify(driverDAO, times(1)).save(isA(DriverModel.class));
    }



}
