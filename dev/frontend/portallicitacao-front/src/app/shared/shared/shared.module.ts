import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BarraPesquisaComponent } from './barra-pesquisa/barra-pesquisa.component';
import { FiltroAvancadoComponent } from './filtro-avancado/filtro-avancado.component';



@NgModule({
  declarations: [
    BarraPesquisaComponent,
    FiltroAvancadoComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    BarraPesquisaComponent,
    FiltroAvancadoComponent
  ]
})
export class SharedModule { }
