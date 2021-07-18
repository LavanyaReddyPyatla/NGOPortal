import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewNeedypeopleComponent } from './view-needypeople.component';

describe('ViewNeedypeopleComponent', () => {
  let component: ViewNeedypeopleComponent;
  let fixture: ComponentFixture<ViewNeedypeopleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewNeedypeopleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewNeedypeopleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
