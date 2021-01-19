import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';
import { User} from '../user';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {


  user: User = new User();
  submitted = false;

  constructor(private userService: UserService, private router: Router) { }


  ngOnInit(): void {
  }
  newLogin(): void {
    this.submitted = false;

  }
  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }
  save() {

    this.userService.registerUser(this.user).subscribe(data => {
      console.log(data)
      this.user = new User();
      this.goToList();
    },
    error => console.log(error));
    }
    onSubmit() {
      this.submitted = true;
      this.save();
    }
    goToList() {

      this.router.navigate(['/login']);
    }
    
  }
