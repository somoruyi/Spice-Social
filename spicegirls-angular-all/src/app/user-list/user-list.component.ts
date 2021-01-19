
import { Component, OnInit, Output } from '@angular/core';
import{UserProfileComponent} from '../user-profile/user-profile.component';
import { Observable} from "rxjs";
import {UserService} from "../user.service";
import{ Router, ActivatedRoute } from '@angular/router';
import {User} from "../user";
import { stringify } from '@angular/compiler/src/util';
import { EventEmitter } from 'events';
import { CookieService } from 'ngx-cookie-service';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: Observable<User[]>;
  name: string;
  id: number;
  user: User = new User();
  constructor(private userService: UserService, private router: Router,private route: ActivatedRoute, private cookieService: CookieService) { }

  ngOnInit(): void {
    this.reloadData();

    this.name='';

  }
  reloadData() {
    this.users = this.userService.getUserList();
  }
  deleteUser(id: number) {
    this.userService.deleteUser(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
    }
    userDetails(id: number) {
      this.router.navigate(['details', id])
    }

    searchUser(): void {
      this.userService.findByName(this.name).subscribe(
        user => {
          this.users = user;

          console.log(user); //searched user 
          this.user= user;
          var array = user,  
          object = Object.assign({}, ...array);  
          console.log(object);  
          console.log(this.user); //i think the problem is this is an array that needs to be an object
          console.log(object.userId); //this should get user id of user but its saying undefined why???
          this.cookieService.set('search', `${object.userId}`); //sets cookie as user id but id is undefined
          this.id = Number(this.cookieService.get('search')); //turns cookie into number and id = cookie
          console.log(this.id); //returning NaN
          console.log(this.cookieService.get('cookie')); //returning udefined 
        },
      error => { console.log(error);
      });
    }
    onSubmit() {
      this.searchUser();
    }
    
  }
  
  

