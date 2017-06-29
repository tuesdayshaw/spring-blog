package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.PostsRepository;
import com.codeup.repositories.UsersRepository;
import com.codeup.svcs.PostSvc;
import com.codeup.svcs.UserDetailsLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by canidmars on 6/19/17.
 */

@Controller
public class PostsController {

    private PostSvc postSvc;
    private UsersRepository userSvc;

    @Value("${file-upload-path}")
    private String uploadPath;

    @Autowired
    public PostsController(UsersRepository userSvc, PostSvc postSvc) {
        this.userSvc = userSvc;
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String viewAll(Model model) {
        Iterable<Post> allPosts = postSvc.findAll();
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }

    @GetMapping("/posts.json")
    public @ResponseBody Iterable<Post> viewAllPostsInJSONFormat() {
        return postSvc.findAll();
    }

    @GetMapping("/posts/ajax")
    public String viewPostsAjax(){
        return "posts/json";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@ModelAttribute Post post, Model model) {
        post = postSvc.findOne(post.getId());
        model.addAttribute("post", post);
//        model.addAttribute("id", id);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@Valid Post post, Errors validation, @RequestParam(name = "file") MultipartFile uploadedFile, Model model) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }

        if (!uploadedFile.isEmpty()) {

            String filename = uploadedFile.getOriginalFilename();
            String filepath = Paths.get(uploadPath, filename).toString();
            File destinationFile = new File(filepath);
            try {
                uploadedFile.transferTo(destinationFile);
//            model.addAttribute("message", "File successfully uploaded!");
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Oops! Something went wrong! " + e);
            }
            post.setImageUrl(filename);
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(user);
        model.addAttribute("post", post);
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@ModelAttribute Post post, Model model) {
        post = postSvc.findOne(post.getId());
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(user);
        postSvc.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@ModelAttribute Post post, Model model) {
        postSvc.delete(post.getId());
        model.addAttribute("msg", "Your post was deleted correctly");
        return "redirect:/posts/";
    }
}
