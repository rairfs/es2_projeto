import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LicitacoesRoutingModule } from './licitacoes-routing.module';
import { LicitacoesComponent } from './licitacoes.component';


@NgModule({
  declarations: [
    LicitacoesComponent
  ],
  imports: [
    CommonModule,
    LicitacoesRoutingModule
  ]
})
export class LicitacoesModule { }
