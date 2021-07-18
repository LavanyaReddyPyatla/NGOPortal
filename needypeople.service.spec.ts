import { TestBed } from '@angular/core/testing';

import { NeedypeopleService } from './needypeople.service';

describe('NeedypeopleService', () => {
  let service: NeedypeopleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NeedypeopleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
