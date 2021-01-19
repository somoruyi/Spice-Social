import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';
import { Post } from '../post';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { User } from '../user';
import { UserService } from '../user.service';
import { UploadService } from '../upload.service';


@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {
  post: Post = new Post();
  image:string;
  user: User;
  userId:number;
  postId:number;
  submitted = false;
  selectedFile: File;





  constructor(private postService: PostService, private userService:UserService, 
    private router: Router,private cookieService: CookieService, private uploadService:UploadService) { }

  ngOnInit(): void {

  }

  newPost(): void {
    this.submitted = false;
    this.post = new Post();
    // this.post.userId = Number(this.cookieService.get('cookie'));
    this.post.likeCount = 0;
  }

  check(){
    var cookieExists: boolean = this.cookieService.check('cookie');
    if(cookieExists){
      console.log("cookie exists")
      // this.post.user = Number(this.cookieService.get('cookie'));
      this.save();
    }else{
      console.log("cookie does not exist")
    }
  }

  //get user to save into post.user
  getUser(){
    this.userService.getUser(this.userId).subscribe(data =>{
      console.log(data);
      this.post.user = data;
      this.upload();
    },
    error => console.log(error));
  }
  //insert into the database
  save() {
    this.postService
      .createPost(this.post).subscribe(data => {
        console.log(data);
        this.goToList();
      },
        error => console.log(error));
  }

  onFileSelected(event){
    console.log(event);
    this.selectedFile = event.target.files[0];
    
  }
  //upload to s3 bucket
  upload(){
    this.uploadService.pushFileToStorage(this.selectedFile).subscribe(data => {
      this.post.image = JSON.stringify(data.body);
      console.log("LOOK AT THIS FOR URL: " + this.post.image);//checks for url to image in s3 bucket
      this.save();
    }, error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.userId = Number(this.cookieService.get('cookie'));
    console.log(this.post.user);
    this.getUser();
  }

  goToList() {
    this.router.navigate(['/post']);
  }

}
