import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { mealEndpoint } from '../../config/config';

@Injectable()
export class AdminMealService {

    constructor(private http: Http) { }

    getMealList() {
        console.log("Getting list of meals")
        return this.http.get(mealEndpoint + "/list")
            .map(response => response.json());
    }

    getMealTypes() {
        console.log("Getting type of meals")
        return this.http.get(mealEndpoint + "/types")
            .map(response => response.json());
    }

    addMeal(meal) {
        console.log("Adding meal")
        return this.http.post(mealEndpoint, meal)
            .map(response => response.json());
    }

}