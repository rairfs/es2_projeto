import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ModalidadesRoutingModule } from './modalidades-routing.module';
import { ModalidadesComponent } from './modalidades.component';
import { SharedModule } from '../shared/shared/shared.module';


@NgModule({
  declarations: [
    ModalidadesComponent
  ],
  imports: [
    CommonModule,
    ModalidadesRoutingModule,
    SharedModule
  ]
})
export class ModalidadesModule { }
