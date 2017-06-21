package com.codeup.models;

import javax.persistence.*;
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
    private String title;

    @Column(nullable = false, columnDefinition = "Text")
    private String body;

    @Column(nullable = false)
    private long user_id;

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

    public long getUser_id() { return user_id; }

    public void setUser_id(long user_id) { this.user_id = user_id; }

    public Post(long id, String title, String body, long user_id) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user_id = user_id;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, long user_id) {
        this.title = title;
        this.body = body;
        this.user_id = user_id;
    }

    public Post() {
    }
}
