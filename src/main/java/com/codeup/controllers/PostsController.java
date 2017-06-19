package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by canidmars on 6/19/17.
 */

@Controller
public class PostsController {

    @GetMapping("/posts/index")
    public String viewAll(Model model) {

        List<Post> allPosts = new ArrayList<>();
        Post postOne = new Post("Post One", "Sample text for post one.");
        Post postTwo = new Post("Post Two", "Sample text for post two.");
        allPosts.add(postOne);
        allPosts.add(postTwo);

        model.addAttribute("allPosts", allPosts);
        model.addAttribute("one", postOne);
        model.addAttribute("two", postTwo);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable Long id, Model model) {

        Post post = new Post("Single Post", "some description");

        model.addAttribute("post", post);
        model.addAttribute("id", id);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showPostForm() {

        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String savePost() {

        return "create a new form";
    }

}
