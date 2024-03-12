import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UnidadesGestorasComponent } from './unidades-gestoras.component';

const routes: Routes = [{ path: '', component: UnidadesGestorasComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UnidadesGestorasRoutingModule { }
