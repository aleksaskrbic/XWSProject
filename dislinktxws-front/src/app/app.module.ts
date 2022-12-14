import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatToolbarModule} from '@angular/material/toolbar';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { CommentComponent } from './comment/comment.component';
import { PostComponent } from './post/post.component';
import { OnePostComponent } from './one-post/one-post.component';
import { ProfileComponent } from './profile/profile.component';

import { LoginPageComponent } from './login-page/login-page.component';

import { RegistrationComponent } from './registration/registration.component';
import { SearchComponent } from './search/search.component';
import { AllUsersComponent } from './all-users/all-users.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AllProfilesComponent } from './all-profiles/all-profiles.component';
import { ProfileSearchComponent } from './profile-search/profile-search.component';
import { FindProfileForUpdatedComponent } from './find-profile-for-updated/find-profile-for-updated.component';
import { AllJobsComponent } from './all-jobs/all-jobs.component';
import { JobSearchComponent } from './job-search/job-search.component';
import { CreateJobOfferComponent } from './create-job-offer/create-job-offer.component';
import { ProfilesIFollowPostsComponent } from './profiles-ifollow-posts/profiles-ifollow-posts.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CommentComponent,
    PostComponent,
    OnePostComponent,
    ProfileComponent,

    LoginPageComponent,

    RegistrationComponent,
    SearchComponent,
    AllUsersComponent,
    UserProfileComponent,
    AllProfilesComponent,
    ProfileSearchComponent,
    FindProfileForUpdatedComponent,
    AllJobsComponent,
    JobSearchComponent,
    CreateJobOfferComponent,
    ProfilesIFollowPostsComponent

   


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    FormsModule,
    HttpClientModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
