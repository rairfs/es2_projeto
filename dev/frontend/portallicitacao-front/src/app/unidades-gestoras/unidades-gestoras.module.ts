import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UnidadesGestorasRoutingModule } from './unidades-gestoras-routing.module';
import { UnidadesGestorasComponent } from './unidades-gestoras.component';


@NgModule({
  declarations: [
    UnidadesGestorasComponent
  ],
  imports: [
    CommonModule,
    UnidadesGestorasRoutingModule
  ]
})
export class UnidadesGestorasModule { }
