import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CapitalisePipe } from './capitalise.pipe';

@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [CapitalisePipe],
    exports: [CapitalisePipe, FormsModule, CommonModule]
})
export class SharedModule { }
