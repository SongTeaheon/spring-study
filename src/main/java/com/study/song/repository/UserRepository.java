package com.study.song.repository;

import com.study.song.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    //일단 db없이
    private Map<String, User> users = new HashMap<>();

    public User save(User user){
        user.setId(users.size()+1);
        users.put(user.getEmail(), user);

        return user;
    }

    public User getUserByName(String email) {
        return users.get(email);
    }
}
