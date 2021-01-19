import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFriendProfileComponent } from './user-friend-profile.component';

describe('UserFriendProfileComponent', () => {
  let component: UserFriendProfileComponent;
  let fixture: ComponentFixture<UserFriendProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserFriendProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserFriendProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
