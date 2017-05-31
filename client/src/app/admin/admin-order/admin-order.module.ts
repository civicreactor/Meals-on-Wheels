import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ToasterModule } from 'angular2-toaster';

import { SharedModule } from '../../shared/shared.module'

import { AdminOrderComponent } from './admin-order.component';
import { AdminOrderListComponent } from './admin-order-list/admin-order-list.component';
import { AdminOrderAddComponent } from './admin-order-add/admin-order-add.component';

import { AdminOrderService } from './admin-order.service'


const orderRoutes: Routes = [
    {
        path: 'admin/order',
        component: AdminOrderComponent,
        children: [
            {
                path: '',
                component: AdminOrderListComponent
            },
            {
                path: 'add',
                component: AdminOrderAddComponent
            }
        ]
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(orderRoutes),
        SharedModule,
        ToasterModule
    ],
    declarations: [
        AdminOrderComponent,
        AdminOrderAddComponent,
        AdminOrderListComponent
    ],
    providers: [
        AdminOrderService
    ]
})
export class AdminOrderModule { }
