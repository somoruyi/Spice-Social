import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { PostDetailsComponent } from './post-details/post-details.component';
import { PostListComponent } from './post-list/post-list.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { LikePostComponent } from './like-post/like-post.component';
import { UserFriendProfileComponent } from './user-friend-profile/user-friend-profile.component';
import { AppComponent } from './app.component';
import { NONE_TYPE } from '@angular/compiler';

const routes: Routes = [
  {path: 'user-register', component: UserRegisterComponent},
  {path: 'login', component: UserLoginComponent},

  {path: 'user-profile', component: UserProfileComponent},
  {path: 'post', component: PostListComponent},
  {path: 'add', component: CreatePostComponent},
  {path: 'details/:pid', component: PostDetailsComponent},

  {path: 'profile/:id', component: UserProfileComponent},
  // {path: 'update/:id', component: UserUpdateComponent},
  {path: 'update', component: UserUpdateComponent},
  {path: 'register' , component: UserRegisterComponent},
  {path: 'list', component: UserListComponent},
  {path: 'user-friend-profile', component: UserFriendProfileComponent},


  // {path: 'upload', component: UploadFileComponent},
  // {path: 'form-upload', component: FormUploadComponent},
  // {path: 'details-upload', component: DetailsUploadComponent},
  // {path: 'list-upload', component: ListUploadComponent},

  {path: 'details/:id', component: UserListComponent},
  // Added Like url for development
  {path: 'like', component: LikePostComponent},

  {path: '', redirectTo:'/login', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
