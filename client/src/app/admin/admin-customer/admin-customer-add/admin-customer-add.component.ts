import { Component, OnInit } from '@angular/core';
import { AdminCustomerService } from '../admin-customer.service';
import { ToasterService } from 'angular2-toaster';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-admin-customer-add',
  templateUrl: './admin-customer-add.component.html',
  styleUrls: ['./admin-customer-add.component.css']
})
export class AdminCustomerAddComponent implements OnInit {

    customerForm : FormGroup;
    name: FormControl;
    surname: FormControl;
    address: FormControl;
    telephone: FormControl;
    submitButton: FormControl;
    successfulPosts: number = 0;

    constructor(private customerService: AdminCustomerService, private toaster: ToasterService) { }

    /**
     * Initialise the form controls, so we can reduce boilerplate by referencing them directly rather than
     * using the form control parent to gain a handle in the html.
     * 
     * @memberof AdminCustomerAddComponent
     */
    createFormControls() {
        this.name = new FormControl(null, Validators.required);
        this.surname = new FormControl(null, Validators.required);
        this.address = new FormControl(null, Validators.required);
        this.telephone = new FormControl(null, [Validators.required, 
                                                Validators.pattern("^[+]?[0-9\- ]*$"), 
                                                Validators.minLength(4)]
                                            );
    }

    /**
     * Build the form from the directely referenceable components
     * 
     * @memberof AdminCustomerAddComponent
     */
    createForm() {
        this.customerForm = new FormGroup({
            name: this.name,
            surname: this.surname,
            address: this.address,
            telephone: this.telephone
        })
    }

    /**
     * Execute the form initialisation
     * 
     * @memberof AdminCustomerAddComponent
     */
    ngOnInit() {
        this.createFormControls();
        this.createForm();
    }

    /**
     * Handle the Ajax call and resultant subscribed response
     * 
     * @param {*} value the object returned from the form holding customer values
     * @memberof AdminCustomerAddComponent
     */
    submitCustomer(value: any) {
        console.log(value)
        this.customerService.addCustomer(value)
            .subscribe(res => {
                console.log("Customer added", res);
                this.toaster.pop('success', 'Success adding customer', '');
                this.successfulPosts += 1;
                this.clearForm();
            }, error => {
                console.error('Error adding customer:', error);
                this.toaster.pop('error', 'Error adding customer', error);
            });
    }

    /**
     * Reset the form on successful response
     * 
     * @memberof AdminCustomerAddComponent
     */
    clearForm() {
        this.customerForm.reset();
    }

}
