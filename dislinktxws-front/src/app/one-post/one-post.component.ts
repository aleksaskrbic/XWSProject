import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from '../model/post.model';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-one-post',
  templateUrl: './one-post.component.html',
  styleUrls: ['./one-post.component.css']
})
export class OnePostComponent implements OnInit {
  id:number;
  post:Post;
  constructor(private route: ActivatedRoute, private postService:PostService,  private router: Router) { 
    
  }

  ngOnInit(): void {
    this.loadPost();
  }

  loadPost(){
    this.id = this.route.snapshot.params['id'];
    this.postService.findPostById(this.id)
    .subscribe(res=>this.post=res)
  }

  backToProfile()
  {
    this.router.navigate(['/profile', this.post.ownerId]);
  }

  backToPosts()
{
  this.router.navigate(['/posts/profileIFollowed']);
}
}
