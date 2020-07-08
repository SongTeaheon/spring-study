package com.study.song.controller;

import com.study.song.model.User;
import com.study.song.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //post로 바꿔
    @GetMapping("/new")
    public User createUser(){
        User user = new User();
        user.setEmail("email");
        user.setPassword("pw");

        return userService.save(user);
    }
}
