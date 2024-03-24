import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isMenuHovered: boolean;
  isUnidadesGestorasHovered: boolean;
  isModalidadesHovered: boolean;
  isEstadosHovered: boolean;
  rotaAtual: string;

  constructor(private router: Router) {
    this.isMenuHovered = false;
    this.isUnidadesGestorasHovered = false;
    this.isModalidadesHovered = false;
    this.isEstadosHovered = false;
    this.rotaAtual = "";
  }
  ngOnInit(): void {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.rotaAtual = event.url;
      }
    })
  }

  toggler(event: PointerEvent) {
    if (event.type === "pointerenter") this.isMenuHovered = true;
    if (event.type === "pointerleave") this.isMenuHovered = false;
  }

  hover(event: MouseEvent, element: string) {
    if (event.type === "mouseenter") {

      if (element === 'unidadesGestoras') this.isUnidadesGestorasHovered = true;
      if (element === 'modalidades') this.isModalidadesHovered = true;
      if (element === 'estados') this.isEstadosHovered = true;
    }
    if (event.type === "mouseleave") {
      if (element === 'unidadesGestoras') this.isUnidadesGestorasHovered = false;
      if (element === 'modalidades') this.isModalidadesHovered = false;
      if (element === 'estados') this.isEstadosHovered = false;
    }
  }

}
