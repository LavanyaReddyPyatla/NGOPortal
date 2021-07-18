import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterNeedypeopleComponent } from './register-needypeople.component';

describe('RegisterNeedypeopleComponent', () => {
  let component: RegisterNeedypeopleComponent;
  let fixture: ComponentFixture<RegisterNeedypeopleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterNeedypeopleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterNeedypeopleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
