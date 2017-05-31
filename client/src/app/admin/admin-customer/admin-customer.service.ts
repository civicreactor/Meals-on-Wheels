import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { customerEndpoint } from '../../config/config';

@Injectable()
export class AdminCustomerService {

    constructor(private http: Http) { }

    getCustomers() {
        console.log("Getting list of customers")
        return this.http.get(customerEndpoint + "/list")
            .map(response => response.json());
    }


    addCustomer(customer) {
        console.log("Adding customer")
        return this.http.post(customerEndpoint + "/", customer)
            //.map(response => response.json());
    }

}