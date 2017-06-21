package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by canidmars on 6/21/17.
 */
public interface PostsRepository extends CrudRepository <Post, Long> {

}
