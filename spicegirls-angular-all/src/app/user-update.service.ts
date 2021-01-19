import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserUpdateService {
  private baseUrl= 'http://localhost:8088/users/update'

  constructor(private http: HttpClient) { }

  getUserById(id:number):Observable<any>{
    return this.http.post(`${this.baseUrl}/retrieve_user`,id);

  }

  updateCompletly(user:Object): Observable<any>{
    
    return this.http.post(`${this.baseUrl}/complete`, user);
  }

}
