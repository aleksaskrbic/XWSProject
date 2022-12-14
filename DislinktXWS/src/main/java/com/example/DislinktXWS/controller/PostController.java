package com.example.DislinktXWS.controller;

import com.example.DislinktXWS.DTO.NewDislikeDTO;
import com.example.DislinktXWS.DTO.NewLikeDTO;
import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.repository.PostRepository;
import com.example.DislinktXWS.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value="api/post",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> save(@RequestBody Post post){
        Post savedPost=this.postService.save(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @RequestMapping(value="api/post",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<Post>> findAll(){
        List<Post> posts=this.postService.findAll();
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @RequestMapping(value = "api/posts/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id){
        Post post=this.postService.findById(id);
        if(post==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.postService.delete(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value="api/post/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Post> getById(@PathVariable Long id){
        Post post=this.postService.findById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    /*@RequestMapping(value="api/post/likePost",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> likePost(@RequestBody Post post){
        Long numberLikes = post.getNumberOfLikes();
        numberLikes++;
        post.setNumberOfLikes(numberLikes);
        Post likedPost=this.postRepository.save(post);
        return new ResponseEntity<>(likedPost, HttpStatus.CREATED);
    }*/


    @RequestMapping(value="api/post/checkPost",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List> checkIfPostIsDisliked(@RequestBody Post post1){
        List<Long> dislikes = post1.getUserIdWhoDislikes();
        return new ResponseEntity<>(dislikes,HttpStatus.OK);
    }

    @RequestMapping(value="api/post/likePost1",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> likePost1(@RequestBody NewLikeDTO newLikeDTO){
        Post likedPost=this.postService.likePost1(newLikeDTO);
        return new ResponseEntity<>(likedPost, HttpStatus.CREATED);
    }


    @RequestMapping(value="api/post/dislikePost1",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> dislikePost1(@RequestBody NewDislikeDTO newDislikeDTO){
        Post dislikedPost=this.postService.dislikePost1(newDislikeDTO);
        return new ResponseEntity<>(dislikedPost, HttpStatus.CREATED);
    }


    @RequestMapping(value="api/post/profilesYouFollow",method = RequestMethod.GET, params = "idProfile",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<Post>> findAllPostsFromProfilesYouFollow(@RequestParam Long idProfile){
        List<Post> posts=this.postService.findAllPostsFromProfilesYouFollow(idProfile);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }



}
