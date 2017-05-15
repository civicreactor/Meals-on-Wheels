import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { AdminComponent } from './admin.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { AdminCustomerComponent } from './admin-customer/admin-customer.component';
import { AdminOrderComponent } from './admin-order/admin-order.component';
import { AdminMealModule } from './admin-meal/admin-meal.module';


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
    AdminMealModule
  ],
  exports: [
    RouterModule
  ],
  declarations: [AdminComponent, AdminHomeComponent, AdminNavbarComponent, AdminCustomerComponent, AdminOrderComponent]
})

export class AdminModule { }
