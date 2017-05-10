import { Component, OnInit } from '@angular/core';
import { MealService } from '../meal.service';

@Component({
  selector: 'app-client-meal-list',
  templateUrl: './client-meal-list.component.html',
  styleUrls: ['./client-meal-list.component.css']
})
export class ClientMealListComponent implements OnInit {

  constructor(private mealService : MealService) { }

  meals;

  ngOnInit() {
    this.mealService.getMealList().subscribe(
        meals => this.meals = meals.map(meal=>JSON.stringify(meal)),
        error => console.error('Error:', error),
        () => {}
);
  }

}
