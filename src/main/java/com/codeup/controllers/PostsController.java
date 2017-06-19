package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by canidmars on 6/19/17.
 */

@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex() {
        return "/posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsId(@PathVariable int id) {
        return "/posts/" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreateView() {
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postsCreate() {
        return "/posts/create";
    }

}
