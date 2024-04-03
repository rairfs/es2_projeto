import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LicitacoesRoutingModule } from './licitacoes-routing.module';
import { LicitacoesComponent } from './licitacoes.component';
import { SharedModule } from '../shared/shared/shared.module';

@NgModule({
  declarations: [
    LicitacoesComponent
  ],
  imports: [
    CommonModule,
    LicitacoesRoutingModule,
    SharedModule
  ]
})
export class LicitacoesModule { }
