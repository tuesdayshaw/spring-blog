package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        Post post = postsDao.findOne(id);

        model.addAttribute("post", post);
        model.addAttribute("id", id);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(Model model, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post post = new Post(title, body);
        model.addAttribute("post", post);
        return "create a new form";
    }

}
