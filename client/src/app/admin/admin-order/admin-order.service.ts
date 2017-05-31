import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { orderEndpoint } from '../../config/config';


@Injectable()
export class AdminOrderService {

    constructor(private http: Http) { }


    getOrders() {
        console.log("Getting list of orders")
        return this.http.get(orderEndpoint + "/list")
            .map(response => response.json());
    }

    addOrder(order) {
        console.log("Adding order")
        return this.http.post(orderEndpoint + "/", order)
        //.map(response => response.json());
    }
}
