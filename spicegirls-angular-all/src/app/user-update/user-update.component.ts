import { Component, OnInit } from '@angular/core';
import { User} from '../user';
import {ActivatedRoute, Router} from '@angular/router';
// import { UserService} from '../user.service';
import {UserUpdateService} from '../user-update.service';
import { CookieService } from 'ngx-cookie-service';
import { UploadService } from '../upload.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {
  id: number;
  user: User = new User();
  selectedFile: File;

  constructor(private route: ActivatedRoute, private router: Router, 
    private userUpdateService: UserUpdateService,
     private CookieService: CookieService, private uploadService: UploadService) { }

  ngOnInit() {

    this.id = Number(this.CookieService.get('cookie'));


    this.userUpdateService.getUserById(this.id)
    .subscribe(data => {
      console.log(data)
      this.user = data;
    }, error => console.log(error));


  }
    
    onSubmit(){
      if(this.selectedFile!=undefined || this.selectedFile!=null){
        console.log("uploading image");
        this.uploadImage();
        } else{
          console.log("Not uploading image");
          this.updateCompletly();
        }

    }

    updateCompletly(){
      console.log("Update Completly Started");



        console.log("User profile image just before data "+this.user.profilePicture);
      this.userUpdateService.updateCompletly(this.user)
      .subscribe(data=>{
          console.log(data)
          this.user=data;

        }, error => console.log(error));


        this.router.navigate(['/user-profile']);
    }

    uploadImage(){
      this.uploadService.pushFileToStorage(this.selectedFile).subscribe(data => {
        this.user.profilePicture = JSON.stringify(data.body);
        console.log("LOOK AT THIS FOR URL: " + this.user.profilePicture);
        this.updateCompletly();
      }, error => console.log(error));
    }

    onFileSelected(event){
      console.log("Selected event "+event);
      this.selectedFile = event.target.files[0];
      
    }

    

    

  }

