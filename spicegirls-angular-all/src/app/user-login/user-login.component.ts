import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../user';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit { 
  username: string;
  password: string;

  user: User = new User();
  public loginInvalid: boolean;

  constructor(private myUser:UserService, private _route: ActivatedRoute, private _router: Router, private cookieService: CookieService) { }


ngOnInit(): void {
}
onSubmit() {

  this.loginInvalid = false;
  try {
    this.myUser.getLogin(this.user.username, this.user.password).subscribe(
      data => {
        console.log(data);
        this.user = data;
        console.log(this.user.userId);
        this.cookieService.set('cookie', `${this.user.userId}`);
        console.log(this.cookieService.get('cookie'));
        this._router.navigate(['post']);
      } 
  
    )

  } catch (err) {
    this.loginInvalid = true;
  }
}

/* post() {
  
this._router.navigate(['post']);
} */

}
