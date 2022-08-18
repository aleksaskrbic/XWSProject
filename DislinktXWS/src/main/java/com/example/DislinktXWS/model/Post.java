package com.example.DislinktXWS.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Document(collection = "posts")
public class Post {
    @Id
    private Long id;
    private String ownerId;
    private String text;
    private List<Long> userIdWholikes;
    private List<Long> userIdWhoDislikes;
    private List<Comment> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Long> getUserIdWholikes() {
        return userIdWholikes;
    }

    public void setUserIdWholikes(List<Long> userIdWholikes) {
        this.userIdWholikes = userIdWholikes;
    }

    public List<Long> getUserIdWhoDislikes() {
        return userIdWhoDislikes;
    }

    public void setUserIdWhoDislikes(List<Long> userIdWhoDislikes) {
        this.userIdWhoDislikes = userIdWhoDislikes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Post(Long id, String ownerId, String text, List<Long> userIdWholikes, List<Long> userIdWhoDislikes, List<Comment> comments) {
        this.id = id;
        this.ownerId = ownerId;
        this.text = text;
        this.userIdWholikes = userIdWholikes;
        this.userIdWhoDislikes = userIdWhoDislikes;
        this.comments = comments;
    }
    public Post(String ownerId, String text) {
        this.ownerId = ownerId;
        this.text = text;
        this.userIdWholikes = new ArrayList<>();
        this.userIdWhoDislikes = new ArrayList<>();
        this.comments =new ArrayList<>();
    }


    public Post() {
    }
}