package com.codeup.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by canidmars on 6/19/17.
 */

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Ads must have a title")
    @Size(min = 3, message = "A title must be at least 3 characters.")
    private String title;

    @Column(nullable = false, columnDefinition = "Text")
    @NotBlank(message = "Ads must have a description")
    private String body;

    @OneToOne
    private User owner;



    public User getOwner() { return owner; }

    public void setOwner(User owner) { this.owner = owner; }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }



    public Post(long id, String title, String body, User owner) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public Post() {
    }
}
