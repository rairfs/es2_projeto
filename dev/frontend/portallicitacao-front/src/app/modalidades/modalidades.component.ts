import { Component } from '@angular/core';
import { Modalidade } from './types/Modalidades';

@Component({
  selector: 'app-modalidades',
  templateUrl: './modalidades.component.html',
  styleUrls: ['./modalidades.component.css']
})
export class ModalidadesComponent {

  modalidades: Modalidade[]

  constructor() {
    this.modalidades = [
      {
        codigo: 1,
        descricao: "Modalidade Exemplo 1"
      },
      {
        codigo: 2,
        descricao: "Modalidade Exemplo 2"
      },
      {
        codigo: 3,
        descricao: "Modalidade Exemplo 3"
      }
    ]
  }
}
