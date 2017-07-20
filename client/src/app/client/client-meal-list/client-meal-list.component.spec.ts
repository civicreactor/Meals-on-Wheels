
import { ClientMealListComponent } from './client-meal-list.component';
import { MealService } from '../meal.service';
import {Observable} from "rxjs/Rx";
import { async } from "@angular/core/testing";

class MockMealService {
  constructor(private validData) { } 
  getMealList() {
    return Observable.of(this.validData) ;
  }
}

describe('ClientMealListComponent', () => {
  let component: ClientMealListComponent;
  let service: MealService
  let validResponse = [
    {
        "id": 20,
        "type": "BREAKFAST",
        "description": "Pancakes",
        "available": true
    },
    {
        "id": 21,
        "type": "LUNCH",
        "description": "Burger & Chips",
        "available": true
    }
  ];

  let mockMealService

  beforeEach(async(() => {
    mockMealService = new MockMealService(validResponse)
    component = new ClientMealListComponent(mockMealService);
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should handle successful retrieval of data', async( () => {  
    expect(component.meals).toBeUndefined();
    component.loadMeals();
    expect(component.meals).toEqual(validResponse);
  }));

  it('should handle an error response', async( () => {    
    mockMealService.getMealList = () => Observable.create(observer => new Error("status: 404"));

    expect(component.meals).toBeUndefined();
    component.loadMeals();
    expect(component.meals).toBeUndefined();
  }));

});
