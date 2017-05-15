import { Component, OnInit } from '@angular/core';

import { AdminMealService } from '../admin-meal.service';

@Component({
    selector: 'app-admin-meal-list',
    templateUrl: './admin-meal-list.component.html',
    styleUrls: ['./admin-meal-list.component.css']
})
export class AdminMealListComponent implements OnInit {

    constructor(private mealService: AdminMealService) { }

    meals;
    
    ngOnInit() {
        this.mealService.getMealList().subscribe(
            meals => this.meals = meals.map(meal => JSON.stringify(meal)),
            error => console.error('Error:', error),
            () => { }
        );
    }

}
