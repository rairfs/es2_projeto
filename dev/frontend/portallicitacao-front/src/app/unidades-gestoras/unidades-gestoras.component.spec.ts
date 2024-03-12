import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnidadesGestorasComponent } from './unidades-gestoras.component';

describe('UnidadesGestorasComponent', () => {
  let component: UnidadesGestorasComponent;
  let fixture: ComponentFixture<UnidadesGestorasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnidadesGestorasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnidadesGestorasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
