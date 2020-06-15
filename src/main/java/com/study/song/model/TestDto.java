package com.study.song.model;

import lombok.Data;

@Data
public class TestDto {

    int id;
    String name;
    String[] nums = new String[5];
}
