package com.example.DislinktXWS.controller;


import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.model.Profile;

import com.example.DislinktXWS.service.PostService;

import com.example.DislinktXWS.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private PostService postService;

    @RequestMapping(value="api/profile",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profile> save(@RequestBody Profile profile){
        Profile savedProfile=this.profileService.save(profile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }

    @RequestMapping(value="api/profile",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<Profile>> findAll(){
        List<Profile> profiles=this.profileService.findAll();
        return new ResponseEntity<>(profiles,HttpStatus.OK);
    }

    @RequestMapping(value = "api/profile/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id){
        Profile profileOption=this.profileService.findById(id);
        if(profileOption==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.profileService.delete(profileOption);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value="api/profile/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Profile> getById(@PathVariable Long id){
        Profile profile=this.profileService.findById(id);
        return new ResponseEntity<>(profile,HttpStatus.OK);
    }


    //Pronalazenje Profila po korisnickom imenu iz Profila
    @RequestMapping(value="api/find/{username}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Profile> getByUsername(@PathVariable String username)
    {
        Profile profile=this.profileService.getByUsername(username);
        return new ResponseEntity<>(profile,HttpStatus.OK);
    }

    @RequestMapping(value="api/profile/posts/{id}",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<Post>> findAllPostsByOwnerId(@PathVariable Long id){
        List<Post> posts=this.postService.findAllPostsByOwnerId(id);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @PutMapping("api/edit")
    public ResponseEntity<Profile> UpdateProfile(@RequestBody Profile p)
    {
        Profile profile = this.profileService.UpdateProfile(p);
        return  new ResponseEntity<>(profile,HttpStatus.OK);
    }

    //Pronalazenje ID-ja Profila
    @RequestMapping(value="api/id/{username}",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Long FindNumber(@PathVariable String username)
    {
        Long number = this.profileService.FindNumber(username);
        return number;
    }


}
