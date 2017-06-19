package com.codeup.controllers;

import org.springframework.stereotype.Controller;

/**
 * Created by canidmars on 6/19/17.
 */

@Controller
public class Post {

    private String title;
    private String body;

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

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {
    }
}
