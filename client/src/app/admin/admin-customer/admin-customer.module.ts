import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ToasterModule } from 'angular2-toaster';

import { SharedModule } from '../../shared/shared.module';

import { AdminCustomerComponent } from './admin-customer.component';
import { AdminCustomerListComponent } from './admin-customer-list/admin-customer-list.component';
import { AdminCustomerAddComponent } from './admin-customer-add/admin-customer-add.component';

import { AdminCustomerService } from './admin-customer.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

const customerRoutes: Routes = [
    {
        path: 'admin/customer',
        component: AdminCustomerComponent,
        children: [
            {
                path: '',
                component: AdminCustomerListComponent
            },
            {
                path: 'add',
                component: AdminCustomerAddComponent
            }
        ]
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(customerRoutes),
        SharedModule,
        ToasterModule,
        FormsModule,
        ReactiveFormsModule
    ],
    exports: [
        RouterModule
    ],
    declarations: [AdminCustomerComponent, AdminCustomerListComponent, AdminCustomerAddComponent],
    providers: [AdminCustomerService]
})
export class AdminCustomerModule { }
