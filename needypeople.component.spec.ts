import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeedypeopleComponent } from './needypeople.component';

describe('NeedypeopleComponent', () => {
  let component: NeedypeopleComponent;
  let fixture: ComponentFixture<NeedypeopleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeedypeopleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NeedypeopleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
