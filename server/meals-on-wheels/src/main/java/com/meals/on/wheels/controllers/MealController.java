package com.meals.on.wheels.controllers;

import com.meals.on.wheels.dtos.MealDTO;
import com.meals.on.wheels.facades.MealFacade;
import com.meals.on.wheels.models.CustomerModel;
import com.meals.on.wheels.models.MealModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealFacade mealFacade;

    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<MealDTO>> getMeals() {
        return ResponseEntity.ok(mealFacade.getAllMeals());
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addMeal(@RequestBody MealDTO meal) {
        mealFacade.addMeal(meal);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(
            value = "/{mealId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MealDTO> getMeal(@PathVariable(value="mealId") Long mealId) {
        MealDTO meal = mealFacade.getMeal(mealId);
        return ResponseEntity.ok(meal);
    }
}
