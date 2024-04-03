import { Component, OnInit } from '@angular/core';
import { Licitacao } from './types/Licitacoes';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-licitacoes',
  templateUrl: './licitacoes.component.html',
  styleUrls: ['./licitacoes.component.css']
})
export class LicitacoesComponent implements OnInit {

  licitacaoObservada: Licitacao[];
  licitacao: Licitacao[];

  showModal: boolean;

  sinalEmpenho: string;
  sinalItem: string;
  sinalParticipante: string;

  estados$: Observable<string[]>;
  municipios$: Observable<string[]>;
  unidadesGestoras$: Observable<string[]>;
  modalidades$: Observable<string[]>;

  constructor(private route: ActivatedRoute, private router: Router) {
    this.showModal = false;

    this.sinalEmpenho = "+";
    this.sinalItem = "+";
    this.sinalParticipante = "+";

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


    /*this.estados$.subscribe(console.log);
    this.municipios$.subscribe(console.log);
    this.unidadesGestoras$.subscribe(console.log);
    this.modalidades$.subscribe(console.log);*/
  }
  ngOnInit(): void {
  }

  modalToggler(acao: string){
    if (acao === "abrir") this.showModal = true;
    if (acao === "fechar") this.showModal = false;
  }

  alternaSessaoItem() {
    if (this.sinalItem == "+") this.sinalItem = "-";
    else if (this.sinalItem == "-") this.sinalItem = "+";
  }

  alteraSessaoParticipante(){
    if (this.sinalParticipante == "+") this.sinalParticipante = "-";
    else if (this.sinalParticipante == "-") this.sinalParticipante = "+";
  }

  alternaSessaoEmpenho() {
    if (this.sinalEmpenho == "+") this.sinalEmpenho = "-";
    else if (this.sinalEmpenho == "-") this.sinalEmpenho = "+";
  }

}
