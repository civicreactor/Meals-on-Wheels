package com.meals.on.wheels.services.impl;

import com.meals.on.wheels.daos.MealDAO;
import com.meals.on.wheels.models.MealModel;
import com.meals.on.wheels.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultMealService implements MealService {

    @Autowired
    private MealDAO mealDAO;

    public Iterable<MealModel> getAllMeals() {
        return mealDAO.findAll();
    }

    public void save(MealModel meal) {
        mealDAO.save(meal);
    }

    public MealModel getMealById(Long mealId) {
        return mealDAO.findOne(mealId);
    }
}
