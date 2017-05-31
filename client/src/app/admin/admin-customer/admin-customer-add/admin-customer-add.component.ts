import { Component, OnInit } from '@angular/core';

import { AdminCustomerService } from '../admin-customer.service';
import { ToasterService } from 'angular2-toaster';

@Component({
  selector: 'app-admin-customer-add',
  templateUrl: './admin-customer-add.component.html',
  styleUrls: ['./admin-customer-add.component.css']
})
export class AdminCustomerAddComponent implements OnInit {

    customer = {};

    constructor(private customerService: AdminCustomerService, private toaster: ToasterService) { }


    ngOnInit() {}

    submitCustomer = function () {
        console.log(this.customer)
        this.customerService.addCustomer(this.customer)
            .subscribe(res => {
                console.log("Customer added", res);
                this.toaster.pop('success', 'Success adding customer', res);
            }, error => {
                console.error('Error adding customer:', error);
                this.toaster.pop('error', 'Error adding customer', error);
            });
    }

}
