package com.meals.on.wheels.services.impl;

import com.meals.on.wheels.daos.MealDAO;
import com.meals.on.wheels.enums.MealType;
import com.meals.on.wheels.models.MealModel;
import com.meals.on.wheels.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DefaultMealService implements MealService {

    @Autowired
    private MealDAO mealDAO;

    @Override
    public Iterable<MealModel> getAllMeals() {
        return mealDAO.findAll();
    }

    @Override
    public void save(MealModel meal) {
        mealDAO.save(meal);
    }

    @Override
    public MealModel getMealById(Long mealId) {
        return mealDAO.findOne(mealId);
    }

    @Override
    public Iterable<MealType> getAllMealTypes() {
        return Arrays.asList(MealType.values());
    }
}
