import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNeedyPeopleComponent } from './add-needy-people.component';

describe('AddNeedyPeopleComponent', () => {
  let component: AddNeedyPeopleComponent;
  let fixture: ComponentFixture<AddNeedyPeopleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNeedyPeopleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNeedyPeopleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
