import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl = 'http://localhost:8088/login';

  constructor(private http: HttpClient) { }

  getLogin(username:string, password:string):Observable<any>{
    console.log("in service login" + username + password)
    return this.http.post(`${this.baseUrl}/verify`, {username, password}, {withCredentials:true}) ;
  }


  createLogin(login: Object): Observable<any>{
    return this.http.post(`${this.baseUrl}/add`, login);
  }

  deleteLogin(uid:number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/${uid}`, { responseType: 'text' });
  }

  getLoginList(): Observable<any>{
    return this.http.get(`${this.baseUrl}/list`);
  }
  
}
