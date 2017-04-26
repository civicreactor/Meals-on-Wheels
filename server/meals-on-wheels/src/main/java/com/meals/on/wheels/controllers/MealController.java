package com.meals.on.wheels.controllers;

import com.meals.on.wheels.facades.MealFacade;
import com.meals.on.wheels.models.CustomerModel;
import com.meals.on.wheels.models.MealModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealFacade mealFacade;

    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<MealModel>> getMeals() {
        return ResponseEntity.ok(mealFacade.getAllMeals());
    }
}
