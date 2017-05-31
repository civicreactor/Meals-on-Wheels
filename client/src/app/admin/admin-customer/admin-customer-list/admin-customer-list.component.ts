import { Component, OnInit } from '@angular/core';

import { AdminCustomerService } from '../admin-customer.service';
@Component({
    selector: 'app-admin-customer-list',
    templateUrl: './admin-customer-list.component.html',
    styleUrls: ['./admin-customer-list.component.css']
})
export class AdminCustomerListComponent implements OnInit {

    constructor(private customerService: AdminCustomerService) { }

    customers;

    ngOnInit() {
        this.customerService.getCustomers()
            .subscribe(customers => {
                this.customers = customers.map(meal => JSON.stringify(meal))
            }, error => {
                console.error('Error:', error)
            });
    }

}
