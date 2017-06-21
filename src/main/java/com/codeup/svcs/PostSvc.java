package com.codeup.svcs;

import com.codeup.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by canidmars on 6/20/17.
 */

@Service("postSvc")
public class PostSvc {

    private List<Post> posts;

    public PostSvc() {
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setId((long)posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int)(id - 1));
    }

    private void createPosts() {
        posts = new ArrayList<>();
        save(new Post("Post One", "some text"));
        save(new Post("Post Two", "some more text"));
        save(new Post("Post Three", "some more more text"));
        save(new Post("Post Four", "some more more more text"));
    }
}
