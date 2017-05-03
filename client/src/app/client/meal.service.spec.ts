import { TestBed, inject } from '@angular/core/testing';

import { MealService } from './meal.service';

describe('MealListService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MealListService]
    });
  });

  it('should ...', inject([MealListService], (service: MealListService) => {
    expect(service).toBeTruthy();
  }));
});
