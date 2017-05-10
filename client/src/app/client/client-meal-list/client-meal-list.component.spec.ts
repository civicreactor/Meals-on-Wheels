import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientMealListComponent } from './client-meal-list.component';

describe('ClientMealListComponent', () => {
  let component: ClientMealListComponent;
  let fixture: ComponentFixture<ClientMealListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientMealListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientMealListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
