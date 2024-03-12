import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EstadosRoutingModule } from './estados-routing.module';
import { EstadosComponent } from './estados.component';


@NgModule({
  declarations: [
    EstadosComponent
  ],
  imports: [
    CommonModule,
    EstadosRoutingModule
  ]
})
export class EstadosModule { }
