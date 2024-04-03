import { Component } from '@angular/core';
import { UnidadeGestora } from './types/UnidadesGestoras';

@Component({
  selector: 'app-unidades-gestoras',
  templateUrl: './unidades-gestoras.component.html',
  styleUrls: ['./unidades-gestoras.component.css']
})
export class UnidadesGestorasComponent {

  unidadesGestoras: UnidadeGestora[];

  constructor() {
    this.unidadesGestoras = [
      {
        codigo: 1,
        nome: "Prefeitura de Aracaju",
        orgaoMaximo: "Governo Federal",
        orgaoVinculado: "Governo do Estado de Sergipe",
        poder: "Executivo"
      },
      {
        codigo: 2,
        nome: "Prefeitura de Itabaianinha",
        orgaoMaximo: "Governo Federal",
        orgaoVinculado: "Governo do Estado de Sergipe",
        poder: "Executivo"
      },
      {
        codigo: 3,
        nome: "Prefeitura de São Cristóvão",
        orgaoMaximo: "Governo Federal",
        orgaoVinculado: "Governo do Estado de Sergipe",
        poder: "Executivo"
      }
    ]
  }

}
