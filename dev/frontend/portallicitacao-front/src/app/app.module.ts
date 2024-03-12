import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BarraPesquisaComponent } from './shared/barra-pesquisa/barra-pesquisa.component';
import { HeaderComponent } from './shared/header/header.component';
import { FiltroAvancadoComponent } from './shared/filtro-avancado/filtro-avancado.component';
import { MenuComponent } from './shared/menu/menu.component';

@NgModule({
  declarations: [
    AppComponent,
    BarraPesquisaComponent,
    HeaderComponent,
    FiltroAvancadoComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
