import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ToasterModule } from 'angular2-toaster';

import { SharedModule } from '../shared/shared.module'

import { AdminComponent } from './admin.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { AdminCustomerComponent } from './admin-customer/admin-customer.component';
import { AdminMealModule } from './admin-meal/admin-meal.module';
import { AdminOrderModule } from './admin-order/admin-order.module';


const adminRoutes: Routes = [
    {
        path: 'admin',
        component: AdminComponent,
        children: [
            {
                path: '',
                component: AdminHomeComponent
            },
            {
                path: 'customer',
                component: AdminCustomerComponent
            }
        ]
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(adminRoutes),
        AdminMealModule,
        AdminOrderModule,
        SharedModule,
        ToasterModule
    ],
    exports: [
        RouterModule
    ],
    declarations: [AdminComponent, AdminHomeComponent, AdminNavbarComponent, AdminCustomerComponent]
})

export class AdminModule { }
