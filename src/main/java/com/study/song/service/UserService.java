package com.study.song.service;

import com.study.song.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User save(User user);
}
