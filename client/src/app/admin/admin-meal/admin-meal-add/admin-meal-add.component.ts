import { Component, OnInit, OnDestroy } from '@angular/core';
import { AdminMealService } from '../admin-meal.service';
import { ToasterService } from 'angular2-toaster';

import "rxjs/add/operator/takeWhile";

@Component({
    selector: 'app-admin-meal-add',
    templateUrl: './admin-meal-add.component.html',
    styleUrls: ['./admin-meal-add.component.css']
})
export class AdminMealAddComponent implements OnInit, OnDestroy {

    constructor(private mealService: AdminMealService, private toaster: ToasterService) { }

    alive = true;
    meal = {};
    mealTypes;
    subscriptions = [];

    ngOnInit() {
        this.mealService.getMealTypes()
            .takeWhile(() => this.alive)
            .subscribe(mealTypes => {
                this.mealTypes = mealTypes;
            }, error => console.error('Error:', error))
    }

    submitMeal = function () {
        console.log(this.meal)
        this.mealService.addMeal(this.meal)
            .takeWhile(() => this.alive)
            .subscribe(res => {
                console.log("Meal added", res);
                this.toaster.pop('success', 'Success adding meal', res);
            }, error => {
                console.error('Error adding meal:', error);
                this.toaster.pop('error', 'Error adding meal', error);
            });
    }

    ngOnDestroy() {
        this.alive = false;
    }
}
