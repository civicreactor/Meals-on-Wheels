import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { mealEndpoint } from '../config/config';

@Injectable()
export class MealService {

    constructor(private http: Http) { }

    getMealList() {
        return this.http.get(mealEndpoint + "/list")
            .map(response => response.json());
    }

}
