package com.codeup.svcs;

import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by canidmars on 6/22/17.
 */

@Service("userSvc")
public class UserSvc {

    private UsersRepository usersSvc;

    @Autowired
    public UserSvc(UsersRepository usersSvc){
        this.usersSvc = usersSvc;
    }

    public Iterable<User> findAll(){
        return usersSvc.findAll();
    }

    public User findOne(long id){
        return usersSvc.findOne(id);
    }

    public User save(User post){
        usersSvc.save(post);
        return post;
    }

    public void deleteUser(long id){
        usersSvc.delete(id);
    }

}
