import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { Observable, forkJoin } from "rxjs";
import { LikeService } from "../like.service";
import { Like } from "../like";
import { PostService } from "../post.service";
import { Post } from "../post";
import { User } from '../user';
import { UserService} from '../user.service';
import { CookieService } from 'ngx-cookie-service';
 /* Steps:  
  * [1] Grab Post Table & Read to screen
  * [2] Grab Likes Table & Read to screen
  * [3] Create and eventhandler that just populates the Like count
  * [4] Use (2) Users to change the Like count when button is pressed
  */

@Component({
  selector: 'app-like-post',
  templateUrl: './like-post.component.html',
  styleUrls: ['./like-post.component.css']
})

export class LikePostComponent implements OnInit {
  // imgSrc: string = '../../assets/P2Icons/chilli001.png'
  // user: User;
  // //post: Post;
  // post: Post = new Post();
  // postId: number;
  // userId: number;
  // key: string;
  // id:string;
  
  //likes: Observable<Like[]>;
  // posts: Observable<Post[]>;  
  // personLiked: Like = new Like();
  
  constructor(private likeService:LikeService, private postService:PostService, private route: ActivatedRoute, private router: Router, private userService: UserService, private cookieService: CookieService ) {}

  ngOnInit(): void {
    
    //this.cookieService.get('cookie');
    //this.id = this.cookieService.get('cookie');

    this.reloadData();

  }
  reloadData() {

    //this.posts = this.postService.getPostList();
    // this.uploadService.getAllImages(this.key).subscribe(data => {
    //   console.log(data);

    // })
   // console.log(this.posts);
    //console.log("in reload data");


  }
 
   createLike(id:string){
    // this.postService.createLike(this.personLiked, id).subscribe(
    //   data => {
    //     console.log(data);
    //    this.reloadData()
    //   },
    //   error => console.log(error));
  }

  gotoList(){
    this.router.navigate(['/like']);
  }



  

}
