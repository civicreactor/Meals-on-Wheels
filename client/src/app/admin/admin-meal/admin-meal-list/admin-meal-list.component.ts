import { Component, OnInit, OnDestroy } from '@angular/core';

import { AdminMealService } from '../admin-meal.service';

import "rxjs/add/operator/takeWhile";

@Component({
    selector: 'app-admin-meal-list',
    templateUrl: './admin-meal-list.component.html',
    styleUrls: ['./admin-meal-list.component.css']
})
export class AdminMealListComponent implements OnInit, OnDestroy {

    constructor(private mealService: AdminMealService) { }
    alive = true;

    meals;

    ngOnInit() {
        this.mealService.getMeals()
            .takeWhile(() => this.alive)
            .subscribe(meals => {
                this.meals = meals.map(meal => JSON.stringify(meal))
            }, error => {
                console.error('Error:', error)
            });
    }

    ngOnDestroy() {
        this.alive = false;
    }
}
