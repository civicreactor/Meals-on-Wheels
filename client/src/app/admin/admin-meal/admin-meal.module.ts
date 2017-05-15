import { NgModule } from '@angular/core';

import { SharedModule } from '../../shared/shared.module'

import { RouterModule, Routes } from '@angular/router';
import { AdminMealComponent } from './admin-meal.component';
import { AdminMealListComponent } from './admin-meal-list/admin-meal-list.component';
import { AdminMealAddComponent } from './admin-meal-add/admin-meal-add.component';

import { AdminMealService } from './admin-meal.service'

const mealRoutes: Routes = [
  {
    path: 'admin/meal',
    component: AdminMealComponent,
    children: [
      {
        path: '',
        component: AdminMealListComponent,
      },
      {
        path: 'add',
        component: AdminMealAddComponent,
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(mealRoutes),
    SharedModule
  ],
  exports: [
    RouterModule
  ],
  declarations: [AdminMealComponent, AdminMealListComponent, AdminMealAddComponent],
  providers: [AdminMealService]
})
export class AdminMealModule { }
