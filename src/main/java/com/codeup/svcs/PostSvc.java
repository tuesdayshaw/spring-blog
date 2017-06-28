package com.codeup.svcs;

import com.codeup.models.Post;
import com.codeup.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by canidmars on 6/20/17.
 */

@Service("postSvc")
public class PostSvc {

    private PostsRepository postSvc;


    @Autowired
    public PostSvc(PostsRepository postSvc){
        this.postSvc = postSvc;
    }

    public Iterable<Post> findAll(){
        return postSvc.findAll();
    }

    public Post findOne(long id){
        return postSvc.findOne(id);
    }

    public Post save(Post post){
        postSvc.save(post);
        return post;
    }

    public void delete(long id){
        postSvc.delete(id);
    }
}
