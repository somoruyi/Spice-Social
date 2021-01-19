import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { SearchUserComponent } from './search-user/search-user.component';
import { LikePostComponent } from './like-post/like-post.component';
import { HttpClientModule } from '@angular/common/http';
import { PostListComponent } from './post-list/post-list.component';
import { PostDetailsComponent } from './post-details/post-details.component';
import { CookieService } from 'ngx-cookie-service';
import { UserListComponent } from './user-list/user-list.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatButtonModule,MatInputModule,MatCardModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UploadFileComponent } from './upload/upload-file/upload-file.component';
import { FormUploadComponent } from './upload/form-upload/form-upload.component';
import { ListUploadComponent } from './upload/list-upload/list-upload.component';
import { DetailsUploadComponent } from './upload/details-upload/details-upload.component';
import { ReversepipePipe } from './reversepipe.pipe';


@NgModule({
  declarations: [
    AppComponent,
    CreatePostComponent,
    UserProfileComponent,
    UserLoginComponent,
    UserRegisterComponent,
    SearchUserComponent,
    LikePostComponent,
    PostListComponent,
    PostDetailsComponent,
    UserListComponent,
    UserUpdateComponent,
    UploadFileComponent,
    FormUploadComponent,
    ListUploadComponent,
    DetailsUploadComponent,
    ReversepipePipe,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FlexLayoutModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    BrowserAnimationsModule
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
