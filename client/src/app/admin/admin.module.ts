import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AdminComponent } from './admin.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { AdminMealComponent } from './admin-meal/admin-meal.component';
import { AdminCustomerComponent } from './admin-customer/admin-customer.component';
import { AdminOrderComponent } from './admin-order/admin-order.component';


const adminRoutes: Routes = [
  {
    path: 'admin',
    component: AdminComponent,
    children: [
      {
        path: '',
        component: AdminHomeComponent,
      },
      {
        path: 'meal',
        component: AdminMealComponent,
      },
      {
        path: 'customer',
        component: AdminCustomerComponent,
      },
      {
        path: 'order',
        component: AdminOrderComponent,
      },
    ]
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(adminRoutes),
    NgbModule.forRoot()
  ],
  exports: [
    RouterModule
  ],
  declarations: [AdminComponent, AdminHomeComponent, AdminNavbarComponent, AdminMealComponent, AdminCustomerComponent, AdminOrderComponent]
})

export class AdminModule { }
