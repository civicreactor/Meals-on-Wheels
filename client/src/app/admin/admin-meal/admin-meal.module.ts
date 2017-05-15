import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AdminMealComponent } from './admin-meal.component';
import { AdminMealListComponent } from './admin-meal-list/admin-meal-list.component';
import { AdminMealAddComponent } from './admin-meal-add/admin-meal-add.component';

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
    CommonModule,
    RouterModule.forChild(mealRoutes),
  ],
  exports: [
    RouterModule
  ],
  declarations: [AdminMealComponent, AdminMealListComponent, AdminMealAddComponent]
})
export class AdminMealModule { }
