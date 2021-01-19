
import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../user';
import { UserService} from '../user.service';
import {UserListComponent}from  '../user-list/user-list.component';
import { Router, ActivatedRoute} from '@angular/router';
import { CookieService } from 'ngx-cookie-service';


@Component({
  selector: 'app-user-friend-profile',
  templateUrl: './user-friend-profile.component.html',
  styleUrls: ['./user-friend-profile.component.css']
})
export class UserFriendProfileComponent implements OnInit {
 
  id: number;
  user: User;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService, private cookieService: CookieService) { }

  ngOnInit() {
    console.log(this.cookieService.get('cookie')); //prints out cookie (user id)
    
    this.user = new User();
    this.id = this.route.snapshot.params['id'];
    this.id = Number(this.cookieService.get('search')); //turns cookie into number and id = cookie
    console.log(this.id);
    this.userService.getUser(this.id).subscribe(data => { //id is 1 when it gets here and prints all data
      console.log(this.id) //prints correct id number
      console.log(data) //prints whole user table
      
      this.user = data; 
      console.log(this.user) //prints all users
    }, error => console.log(error));
  }
  list() {
    this.router.navigate(['list'])
  }


}
