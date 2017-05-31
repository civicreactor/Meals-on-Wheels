import { Component, OnInit, OnDestroy } from '@angular/core';

import { ToasterService } from 'angular2-toaster';

import { AdminMealService } from '../../admin-meal/admin-meal.service';
import { AdminOrderService } from '../../admin-order/admin-order.service';

import "rxjs/add/operator/takeWhile";

@Component({
    selector: 'app-admin-order-add',
    templateUrl: './admin-order-add.component.html',
    styleUrls: ['./admin-order-add.component.css']
})
export class AdminOrderAddComponent implements OnInit, OnDestroy {

    constructor(private mealService: AdminMealService, private orderService: AdminOrderService, private toaster: ToasterService) { }

    alive = true;

    order = {};
    meals;

    ngOnInit() {
        this.mealService.getMeals()
            .takeWhile(() => this.alive)
            .subscribe(meals => {
                this.meals = meals;
            }, error => {
                console.error('Error:', error)
            })
    }

    submitOrder = function () {
        console.log(this.order)
        this.orderService.addOrder(this.meal)
            .takeWhile(() => this.alive)
            .subscribe(res => {
                console.log("Order added", res);
                this.toaster.pop('success', 'Success adding order', res);
            }, error => {
                console.error('Error adding order:', error);
                this.toaster.pop('error', 'Error adding order', error);
            });
    }

    ngOnDestroy() {
        this.alive = false;
    }

}
