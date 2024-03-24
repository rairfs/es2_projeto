import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  isMenuHovered: boolean;

  constructor() {
    this.isMenuHovered = false;
  }

  toggler(event: PointerEvent) {
    if (event.type === "pointerenter") this.isMenuHovered = true;
    if (event.type === "pointerleave") this.isMenuHovered = false;
  }
}
