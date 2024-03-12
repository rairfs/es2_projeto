import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LicitacoesComponent } from './licitacoes.component';

const routes: Routes = [{ path: '', component: LicitacoesComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LicitacoesRoutingModule { }
