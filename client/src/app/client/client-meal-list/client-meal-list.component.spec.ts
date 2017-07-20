import { async, ComponentFixture, TestBed, fakeAsync, flushMicrotasks, tick } from '@angular/core/testing';
import { MockBackend, MockConnection } from '@angular/http/testing';
import { Headers } from '@angular/http';
import { ClientMealListComponent } from './client-meal-list.component';
import { JsonpModule, Jsonp, BaseRequestOptions, ResponseOptions, Response, Http } from "@angular/http";
import { MealService } from '../meal.service';

describe('ClientMealListComponent', () => {
  let component: ClientMealListComponent;
  let fixture: ComponentFixture<ClientMealListComponent>;
  let service: MealService
  let server: MockBackend

  let validResponse = [
    {
        "id": 20,
        "type": "BREAKFAST",
        "description": "Pancakes",
        "available": true
    },
    {
        "id": 21,
        "type": "LUNCH",
        "description": "Burger & Chips",
        "available": true
    }
]

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientMealListComponent ],
      providers: [
            MealService,
            MockBackend,
            BaseRequestOptions,
            ClientMealListComponent,
            {
            provide: Http,
            useFactory: (server, options) => new Http(server, options),
            deps: [MockBackend, BaseRequestOptions]
            }
        ]
    }).compileComponents().then(() => {

        fixture = TestBed.createComponent(ClientMealListComponent);
        component = fixture.componentInstance;

        service = TestBed.get(MealService);
        server = TestBed.get(MockBackend);     

  })
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
