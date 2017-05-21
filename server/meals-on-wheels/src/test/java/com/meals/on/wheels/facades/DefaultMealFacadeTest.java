package com.meals.on.wheels.facades;

import com.meals.on.wheels.dtos.MealDTO;
import com.meals.on.wheels.models.MealModel;
import com.meals.on.wheels.services.MealService;
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
public class DefaultMealFacadeTest {

    @Autowired
    private MealFacade mealFacade;

    @MockBean
    private MealService mealService;

    @MockBean
    private Mapper mapper;

    @MockBean
    private MealModel mealModel;

    @MockBean
    private MealDTO mealDTO;


    @Test
    public void getAllMealsNoResults(){
        // setup
        when(mealService.getAllMeals()).thenReturn(Collections.emptyList());
        // call
        Iterable<MealDTO> meals = mealFacade.getAllMeals();
        // tests
        assertNotNull(meals);
        assertEquals(CollectionUtils.size(meals), 0);
        verify(mealService, times(1)).getAllMeals();
    }

    @Test
    public void getAllMealsFoundResults(){
        // setup
        when(mealService.getAllMeals()).thenReturn(Collections.singletonList(mealModel));
        // call
        Iterable<MealDTO> meals = mealFacade.getAllMeals();
        // tests
        assertNotNull(meals);
        assertEquals(CollectionUtils.size(meals), 1);
        verify(mealService, times(1)).getAllMeals();
    }

    @Test
    public void getMealNoMatchFound(){
        // setup
        when(mealService.getMealById(isA(Long.class))).thenReturn(null);
        // call
        MealDTO meal = mealFacade.getMeal(1L);
        // tests
        assertNull(meal);
        verify(mealService, times(1)).getMealById(isA(Long.class));
    }

    @Test
    public void getMealMatchFound(){
        // setup
        when(mealService.getMealById(isA(Long.class))).thenReturn(mealModel);
        when(mapper.map(isA(MealModel.class), eq(MealDTO.class))).thenReturn(mealDTO);
        // call
        MealDTO meal = mealFacade.getMeal(1L);
        // tests
        assertNotNull(meal);
        assertEquals(meal, mealDTO);
        verify(mealService, times(1)).getMealById(isA(Long.class));
        verify(mapper).map(isA(MealModel.class), eq(MealDTO.class));
    }

    @Test
    public void addMealSuccess() {
        // setup
        doNothing().when(mealService).save(isA(MealModel.class));
        when(mapper.map(isA(MealDTO.class), eq(MealModel.class))).thenReturn(mealModel);
        // call
        mealFacade.addMeal(mealDTO);
        // tests
        verify(mealService, times(1)).save(isA(MealModel.class));
        verify(mapper).map(isA(MealDTO.class), eq(MealModel.class));
    }

    @Test(expected = Exception.class)
    public void addMealFailure() {
        // setup
        doThrow(new Exception()).when(mealService).save(isA(MealModel.class));
        // call
        mealFacade.addMeal(mealDTO);
        // tests
        verify(mealService, times(1)).save(isA(MealModel.class));
    }

}
