package com.study.song.service;

import com.study.song.model.User;
import com.study.song.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InitDb implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Delete all
        this.userRepository.deleteAll();

        // create users
        User minho = new User("minho@naver.com", passwordEncoder.encode("minho123"),"USER","");
        User admin = new User("admin@naver.com", passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager@naver.com", passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(minho, admin, manager);

        // save to db
        this.userRepository.saveAll(users);
    }
}
