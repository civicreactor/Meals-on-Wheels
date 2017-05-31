import { Component, OnInit, OnDestroy } from '@angular/core';
import { MealService } from '../meal.service';

import "rxjs/add/operator/takeWhile";

@Component({
    selector: 'app-client-meal-list',
    templateUrl: './client-meal-list.component.html',
    styleUrls: ['./client-meal-list.component.css']
})
export class ClientMealListComponent implements OnInit, OnDestroy {

    constructor(private mealService: MealService) { }

    alive = true;
    meals;

    ngOnInit() {
        this.mealService.getMealList()
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
