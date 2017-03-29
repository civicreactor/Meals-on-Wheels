import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AdminComponent } from './admin.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminRegistrationComponent } from './admin-registration/admin-registration.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';

const adminRoutes: Routes = [
  {
    path: 'drivers',
    component: AdminComponent,
    children: [
      {
        path: '',
        component: AdminHomeComponent,
      },
      {
        path: 'register',
        component: AdminRegistrationComponent,
      },
      {
        path: 'login',
        component: AdminLoginComponent,
      }
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
  declarations: [AdminComponent, AdminLoginComponent, AdminRegistrationComponent, AdminHomeComponent]
})

export class AdminModule { }
