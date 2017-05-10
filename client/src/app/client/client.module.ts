import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { ClientHomeComponent } from './client-home/client-home.component';
import { ClientMealListComponent } from './client-meal-list/client-meal-list.component';

import { MealService } from './meal.service'

const clientRoutes: Routes = [
  {
    path: 'client',
    component: ClientMealListComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(clientRoutes)
  ],
  declarations: [ClientHomeComponent, ClientMealListComponent],
  exports: [
    RouterModule
  ],
  providers: [MealService]
})
export class ClientModule { }
