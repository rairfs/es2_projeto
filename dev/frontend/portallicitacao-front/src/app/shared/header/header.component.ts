import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  isMenuHovered: boolean;
  isUnidadesGestorasHovered: boolean;
  isModalidadesHovered: boolean;
  isEstadosHovered: boolean;

  constructor() {
    this.isMenuHovered = false;
    this.isUnidadesGestorasHovered = false;
    this.isModalidadesHovered = false;
    this.isEstadosHovered = false;
  }

  toggler(event: PointerEvent) {
    if (event.type === "pointerenter") this.isMenuHovered = true;
    if (event.type === "pointerleave") this.isMenuHovered = false;
  }

  hover(event: MouseEvent, element: string) {
    if (event.type === "mouseenter") {
      console.log(element)
      
      if (element === 'unidadesGestoras') this.isUnidadesGestorasHovered = true;
      if (element === 'modalidades') this.isModalidadesHovered = true;
      if (element === 'estados') this.isEstadosHovered = true;
      console.log(this.isModalidadesHovered)
    }
    if (event.type === "mouseleave") {
      if (element === 'unidadesGestoras') this.isUnidadesGestorasHovered = false;
      if (element === 'modalidades') this.isModalidadesHovered = false;
      if (element === 'estados') this.isEstadosHovered = false;
    }
  }
  
}
