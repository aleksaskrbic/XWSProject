package com.example.DislinktXWS.controller;

import com.example.DislinktXWS.model.Comment;
import com.example.DislinktXWS.model.Post;
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
        Post itemOption=this.postService.findById(id);
        if(itemOption==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.postService.delete(itemOption);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value="api/post/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Post> getById(@PathVariable Long id){
        Post post=this.postService.findById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }


}