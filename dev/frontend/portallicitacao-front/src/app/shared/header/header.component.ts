import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isMenuHovered: boolean;
  rotaAtual: string;

  constructor(private router: Router) {
    this.isMenuHovered = false;
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

}
