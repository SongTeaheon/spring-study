package com.study.song.dto;

import lombok.Data;

@Data
public class TestDto {

    int id;
    String name;
    String[] nums = new String[5];
}
