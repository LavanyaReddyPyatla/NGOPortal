import { TestBed } from '@angular/core/testing';

import { NeedyPeopleService } from './needy-people.service';

describe('NeedyPeopleService', () => {
  let service: NeedyPeopleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NeedyPeopleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
