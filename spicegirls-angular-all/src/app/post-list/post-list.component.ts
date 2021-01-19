import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { PostService } from '../post.service';
import { Post } from '../post';
import { Router } from '@angular/router';
import { UploadService } from '../upload.service';
import { User } from '../user';
import { UserService } from '../user.service';

import { Like } from "../like";


@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})

export class PostListComponent implements OnInit {
  posts: Observable<Post[]>;
  user: User;
  displayPosts: Observable<Post[]>;
  personLiked: Like = new Like();
  id:string;



  constructor(private postService:PostService, private uploadService:UploadService, private router:Router, private userService: UserService ) { }

  ngOnInit(): void {
    this.reloadData();
    
  }

  reloadData(){
    this.posts = this.postService.getPostList();
    // var viewer = new PhotoViewer();
    // this.posts = this.uploadService.getFiles();
  }

  deletePost(pid:number){
    this.postService.deletePost(pid).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }

  postDetails(pid:number){
    this.router.navigate(['details', pid]);
  }

  createLike(id:string){
    this.postService.createLike(this.personLiked, id).subscribe(
      data => {
        console.log(data);
       this.reloadData()
      },
      error => console.log(error));
  }

  


}
