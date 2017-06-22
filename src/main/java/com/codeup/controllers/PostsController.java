package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.repositories.PostsRepository;
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

    private PostsRepository postSvc;

    @Autowired
    public PostsController(PostsRepository postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String viewAll(Model model) {

        Iterable<Post> allPosts = postSvc.findAll();
        model.addAttribute("allPosts", allPosts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable Long id, Model model) {

        Post post = postSvc.findOne(id);

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
    public String savePost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model model) {
        Post post = new Post(title, body);
        model.addAttribute("post", post);
        postSvc.save(post);
        return "posts/create";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post, Model model) {
        postSvc.delete(post.getId());
        model.addAttribute("msg", "Your post was deleted correctly");
        return "posts/delete";
    }
}
