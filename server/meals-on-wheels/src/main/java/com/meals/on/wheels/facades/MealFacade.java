package com.meals.on.wheels.facades;

import com.meals.on.wheels.dtos.MealDTO;
import com.meals.on.wheels.enums.MealType;

public interface MealFacade {

    Iterable<MealDTO> getAllMeals();

    void addMeal(MealDTO meal);

    MealDTO getMeal(Long mealId);

    Iterable<MealType> getAllMealTypes();
}
