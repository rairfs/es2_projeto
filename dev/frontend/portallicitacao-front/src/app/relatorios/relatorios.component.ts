import { Component } from '@angular/core';
import { Licitacao } from '../licitacoes/types/Licitacoes';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-relatorios',
  templateUrl: './relatorios.component.html',
  styleUrls: ['./relatorios.component.css']
})
export class RelatoriosComponent {

  licitacaoObservada: Licitacao[];
  licitacao: Licitacao[];



  estados$: Observable<string[]>;
  municipios$: Observable<string[]>;
  unidadesGestoras$: Observable<string[]>;
  modalidades$: Observable<string[]>;

  constructor() {
    this.licitacaoObservada = [
      {
        numero: 1,
        unidadeGestora: "INSTITUTO FEDERAL DE SAO PAULO",
        modalidade: "Pregão",
        objetoLicitacao: "Licitação de teste para protótipo da aplicação",
        valor: 100000,
        data: "10/12/2023",
        estado: "Bahia",
        municipio: "Tucano"
      },
      {
        numero: 2,
        unidadeGestora: "INSTITUTO FEDERAL DE SAO PAULO",
        modalidade: "Pregão",
        objetoLicitacao: "Licitação de teste para protótipo da aplicação",
        valor: 100000,
        data: "10/12/2023",
        estado: "Bahia",
        municipio: "Feira de Santana"
      },
      {
        numero: 3,
        unidadeGestora: "INSTITUTO FEDERAL DE SAO PAULO",
        modalidade: "Pregão",
        objetoLicitacao: "Licitação de teste para protótipo da aplicação",
        valor: 100000,
        data: "10/12/2023",
        estado: "Sergipe",
        municipio: "Aracaju"
      },
      {
        numero: 3,
        unidadeGestora: "INSTITUTO FEDERAL DE SAO PAULO",
        modalidade: "Pregão",
        objetoLicitacao: "Licitação de teste para protótipo da aplicação",
        valor: 100000,
        data: "10/12/2023",
        estado: "Sergipe",
        municipio: "Capela"
      }
    ];

    this.licitacao = [];

    this.estados$ = of(this.licitacaoObservada).pipe(
      map(licitacaoObservada => Array.from(new Set(licitacaoObservada.map(l => l.estado))))
    );

    this.municipios$ = of(this.licitacaoObservada).pipe(
      map(licitacaoObservada => Array.from(new Set(licitacaoObservada.map(l => l.municipio))))
    );

    this.unidadesGestoras$ = of(this.licitacaoObservada).pipe(
      map(licitacaoObservada => Array.from(new Set(licitacaoObservada.map(l => l.unidadeGestora))))
    );

    this.modalidades$ = of(this.licitacaoObservada).pipe(
      map(licitacaoObservada => Array.from(new Set(licitacaoObservada.map(l => l.modalidade))))
    );
  }
}
