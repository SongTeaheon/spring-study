package com.study.song.repository;

import com.study.song.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByEmail(String email);
}
