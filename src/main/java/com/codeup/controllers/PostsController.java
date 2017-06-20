package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
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

    private PostSvc postsDao;

    @Autowired
    public PostsController(PostSvc postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String viewAll(Model model) {

        List<Post> allPosts = postsDao.findAll();
        model.addAttribute("allPosts", allPosts);

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
