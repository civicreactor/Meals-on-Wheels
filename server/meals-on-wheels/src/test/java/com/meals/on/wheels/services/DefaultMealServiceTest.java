package com.meals.on.wheels.services;

import com.meals.on.wheels.daos.MealDAO;
import com.meals.on.wheels.models.MealModel;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultMealServiceTest {

    @Autowired
    private MealService mealService;

    @MockBean
    private MealDAO mealDAO;

    @MockBean
    private MealModel mealModel;

    @Test
    public void getAllMealsNoResults(){
        // setup
        when(mealDAO.findAll()).thenReturn(Collections.emptyList());
        // call
        Iterable<MealModel> meals = mealService.getAllMeals();
        // tests
        assertNotNull(meals);
        assertEquals(CollectionUtils.size(meals), 0);
        verify(mealDAO, times(1)).findAll();
    }

    @Test
    public void getAllMealsFoundResults(){
        // setup
        when(mealDAO.findAll()).thenReturn(Collections.singletonList(mealModel));
        // call
        Iterable<MealModel> meals = mealService.getAllMeals();
        // tests
        assertNotNull(meals);
        assertEquals(CollectionUtils.size(meals), 1);
        verify(mealDAO, times(1)).findAll();
    }

    @Test
    public void getMealNoMatchFound(){
        // setup
        when(mealDAO.findOne(isA(Long.class))).thenReturn(null);
        // call
        MealModel meal = mealService.getMealById(1L);
        // tests
        assertNull(meal);
        verify(mealDAO, times(1)).findOne(isA(Long.class));
    }

    @Test
    public void getMealMatchFound(){
        // setup
        when(mealDAO.findOne(isA(Long.class))).thenReturn(mealModel);
        // call
        MealModel meal = mealService.getMealById(1L);
        // tests
        assertNotNull(meal);
        assertEquals(meal, mealModel);
        verify(mealDAO, times(1)).findOne(isA(Long.class));
    }

    @Test
    public void addMealSuccess() {
        // setup
        when(mealDAO.save(isA(MealModel.class))).thenReturn(mealModel);
        // call
        mealService.save(mealModel);
        // tests
        verify(mealDAO, times(1)).save(isA(MealModel.class));
    }

    @Test(expected = Exception.class)
    public void addMealFailure() {
        // setup
        doThrow(new Exception()).when(mealDAO).save(isA(MealModel.class));
        // call
        mealService.save(mealModel);
        // tests
        verify(mealDAO, times(1)).save(isA(MealModel.class));
    }
}
