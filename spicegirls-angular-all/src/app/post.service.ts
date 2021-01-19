import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Post } from './post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private baseUrl = 'http://localhost:8088/spice';

  constructor(private http: HttpClient) { }

  getPost(pid: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/${pid}`);
  }  

  createPost(post: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl}/newpost`, post);
  }

  deletePost(pid:number): Observable<Object>{
    return this.http.delete(`${this.baseUrl}/${pid}`, { responseType: 'text' });
  }

  getPostList(): Observable<any>{
    return this.http.get(`${this.baseUrl}/post`);
  }

  createLike(like:Object, id:string):Observable<Object>{
    console.log(like);
    console.log("in create like");
    return this.http.post(`${this.baseUrl}/like/${id}`, like);
  }

  getLikes(id:string):Observable<any>{
    return this.http.get(`${this.baseUrl}/like/${id}`);
  }
  
}
