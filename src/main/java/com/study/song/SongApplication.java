package com.study.song;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.study.song.repository"})
public class SongApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongApplication.class, args);
    }

}
