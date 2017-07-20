import { AdminCustomerAddComponent } from './admin-customer-add.component';
import { Observable } from "rxjs/Rx";
import { async, TestBed, fakeAsync } from "@angular/core/testing";
import { AdminCustomerService } from "app/admin/admin-customer/admin-customer.service";
import { ToasterService } from "angular2-toaster/src/toaster.service";
import { FormBuilder, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { Injectable } from "@angular/core";
import { ToasterModule } from "angular2-toaster/angular2-toaster";

@Injectable()
class MockService {
  constructor(private validData) { } 
  addCustomer() {
    return Observable.of("") ;
  }
}

describe('ClientMealListComponent', () => {
  let component: AdminCustomerAddComponent;
  let toasterMock;
  let mockService;
  let fixture;

  beforeEach(async(() => {
    toasterMock = jasmine.createSpyObj('Toaster', ['pop']);    
    mockService = new MockService("");
    
    TestBed.configureTestingModule({
      imports: [ReactiveFormsModule],
      declarations: [AdminCustomerAddComponent],
      providers: [   
        { provide: AdminCustomerService, useValue: mockService },
        { provide: ToasterService, useValue: toasterMock },
      ]
    }).compileComponents().then( () => {
        fixture = TestBed.createComponent(AdminCustomerAddComponent); 
        component = fixture.componentInstance;
        component.ngOnInit();
    })    
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have default empty values', fakeAsync(() => {
    expect(component.name.value).toBeNull;
    expect(component.surname.value).toBeNull;
    expect(component.address.value).toBeNull;
    expect(component.telephone.value).toBeNull;
  }));

  it('should handle successful retrieval of data', () => {  
    let success = component.successfulPosts;
    component.submitCustomer('');
    expect(component.successfulPosts).toEqual(success+1);
  });

  it('should handle an error response', () => {    
    mockService.addCustomer = () => Observable.create(observer => new Error("status: 404"));

    let success = component.successfulPosts;
    component.submitCustomer('');
    expect(component.successfulPosts).toEqual(success);
  });

  it('should disable the form while first name is not entered', () => {
    component.name.setValue(null);
    expect(component.customerForm.status).toEqual('INVALID');
  });

  it('should disable the form while last name is not entered', () => {
    component.surname.setValue(null);
    expect(component.customerForm.status).toEqual('INVALID');
  });

  it('should disable the form while address is not entered', () => {
    component.address.setValue(null);
    expect(component.customerForm.status).toEqual('INVALID');
  });

  it('should disable the form while phone number is not entered', () => {
    component.telephone.setValue(null);
    expect(component.customerForm.status).toEqual('INVALID');
  });

  it('should enable the form when all required fields are entered', () => {
    component.name.setValue('a');
    component.surname.setValue('b');
    component.address.setValue('12');
    component.telephone.setValue('123456');
    expect(component.customerForm.status).toEqual('VALID');
  });
});
