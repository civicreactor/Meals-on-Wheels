package com.meals.on.wheels.services;


import com.meals.on.wheels.daos.MealDAO;
import com.meals.on.wheels.models.MealModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

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
