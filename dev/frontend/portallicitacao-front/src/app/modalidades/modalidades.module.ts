import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ModalidadesRoutingModule } from './modalidades-routing.module';
import { ModalidadesComponent } from './modalidades.component';


@NgModule({
  declarations: [
    ModalidadesComponent
  ],
  imports: [
    CommonModule,
    ModalidadesRoutingModule
  ]
})
export class ModalidadesModule { }
