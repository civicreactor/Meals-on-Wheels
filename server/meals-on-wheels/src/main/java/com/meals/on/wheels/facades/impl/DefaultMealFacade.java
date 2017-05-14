package com.meals.on.wheels.facades.impl;

import com.meals.on.wheels.dtos.MealDTO;
import com.meals.on.wheels.enums.MealType;
import com.meals.on.wheels.facades.MealFacade;
import com.meals.on.wheels.models.MealModel;
import com.meals.on.wheels.services.MealService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class DefaultMealFacade extends AbstractFacade implements MealFacade {

    @Autowired
    private MealService mealService;

    @Autowired
    private Mapper mapper;

    public Iterable<MealDTO> getAllMeals(){
        Iterable<MealModel> mealModels = mealService.getAllMeals();
        Iterable<MealDTO> mealDTOs = StreamSupport.stream(mealModels.spliterator(), false).map(mealModel -> mapper.map(mealModel , MealDTO.class)).collect(Collectors.toList());
        return mealDTOs;
    }

    public void addMeal(MealDTO meal) {
        mealService.save(mapper.map(meal, MealModel.class));
    }

    public MealDTO getMeal(Long mealId) {
        return mapper.map(mealService.getMealById(mealId), MealDTO.class);
    }

    public Iterable<MealType> getAllMealTypes() {
       return Arrays.asList(MealType.values());
    }
}
