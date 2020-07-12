package com.study.song.service;

import com.study.song.model.User;
import com.study.song.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder ){
        this.passwordEncoder = passwordEncoder;
        this.userRepository =userRepository;

    }

    @Override
    public User save(User user) {
        log.info(user.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info(user.toString());
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> authorityList = new ArrayList<>();
                // Extract list of permissions (name)
                user.getPermissionList().forEach(p -> {
                    GrantedAuthority authority = new SimpleGrantedAuthority(p);
                    authorityList.add(authority);
                });

                // Extract list of roles (ROLE_name)
                user.getRoleList().forEach(p -> {
                    GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + p);
                    authorityList.add(authority);
                });

                return authorityList;
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getEmail();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
