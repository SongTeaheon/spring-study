package com.study.song.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home-login").setViewName("home-login");
        registry.addViewController("/").setViewName("home-login");
        registry.addViewController("/hello-login").setViewName("hello-login");
        registry.addViewController("/login").setViewName("login");
    }
}
