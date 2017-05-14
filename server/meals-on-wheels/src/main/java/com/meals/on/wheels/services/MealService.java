package com.meals.on.wheels.services;

import com.meals.on.wheels.models.MealModel;


public interface MealService {

     Iterable<MealModel> getAllMeals();

     void save(MealModel meal);

     MealModel getMealById(Long mealId);
}
