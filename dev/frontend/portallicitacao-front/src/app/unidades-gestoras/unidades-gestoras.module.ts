import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UnidadesGestorasRoutingModule } from './unidades-gestoras-routing.module';
import { UnidadesGestorasComponent } from './unidades-gestoras.component';
import { SharedModule } from '../shared/shared/shared.module';

@NgModule({
  declarations: [
    UnidadesGestorasComponent
  ],
  imports: [
    CommonModule,
    UnidadesGestorasRoutingModule,
    SharedModule
  ]
})
export class UnidadesGestorasModule { }
