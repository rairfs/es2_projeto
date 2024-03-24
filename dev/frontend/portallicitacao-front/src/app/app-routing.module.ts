import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'estados', loadChildren: () => import('./estados/estados.module').then(m => m.EstadosModule) },
  { path: 'modalidades', loadChildren: () => import('./modalidades/modalidades.module').then(m => m.ModalidadesModule) },
  { path: 'unidades-gestoras', loadChildren: () => import('./unidades-gestoras/unidades-gestoras.module').then(m => m.UnidadesGestorasModule) },
  { path: '', loadChildren: () => import('./licitacoes/licitacoes.module').then(m => m.LicitacoesModule) },
  { path: 'relatorios', loadChildren: () => import('./relatorios/relatorios.module').then(m => m.RelatoriosModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
