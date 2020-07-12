package com.study.song.controller;

import com.study.song.model.User;
import com.study.song.repository.UserRepository;
import com.study.song.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* JPA 연결한 login테스트
* */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }

    @GetMapping("/all")
    public List<User> allUsers(){
        return this.userRepository.findAll();
    }

    @GetMapping("/new")
    public User createHardcodingUser(){
        User user = new User("song@naver.com", "1234", "", "");
        return userService.save(user);
    }

    @PostMapping("/new")
    public User createUser(User user){
        return userService.save(user);
    }

}
