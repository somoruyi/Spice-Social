import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AjaxServiceService {


  /*
  If you want your server to remember who you are.. you'll have to send your cookes so it can verify your identity. 
  We do this using the {withCredentials: true} portion of the HttpRequest.
  */
  constructor(private myHttpClient: HttpClient) { }


  /* loginRequest(): Observable<string>{

    return this.myHttpClient.get<string>('http://localhost:8088/login',
    {withCredentials: true}
    );
    
  }
 */
  logoutRequest(): Observable<string>{

    return this.myHttpClient.get<string>('http://localhost:8088/logout',
    {withCredentials: true}
    );

  }

  infoRequest():  Observable<string>{
    return this.myHttpClient.get<string>('http://localhost:8088/user',
    {withCredentials: true}
    );
  }
}