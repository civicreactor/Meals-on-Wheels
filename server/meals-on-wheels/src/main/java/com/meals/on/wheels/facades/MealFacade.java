package com.meals.on.wheels.facades;

import com.meals.on.wheels.models.MealModel;
import com.meals.on.wheels.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MealFacade {

    @Autowired
    private MealService mealService;

    public Iterable<MealModel> getAllMeals(){
        return mealService.getAllMeals();
    }

    public void addMeal(MealModel meal) {
        mealService.saveOrUpdate(meal);
    }

    public MealModel getMeal(Long mealId) {
        return mealService.getMealById(mealId);
    }
}
