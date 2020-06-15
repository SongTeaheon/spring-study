package com.study.song.controller;

import com.study.song.model.TestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPostPracController {

    //Get방식 배열넘기는 방법
    //http://localhost:8090/getArr?nums=1&nums=2 또는
    //http://localhost:8090/getArr?nums=1,2,3
    @GetMapping("/getArr")
    public TestDto getArrData(String[] nums) {
        TestDto dto = new TestDto();
        dto.setId(0);
        dto.setName("song");
        dto.setNums(nums);
        return dto;
    }

    //Post방식 배열넘기는 방법
    //chrome-extension에서 테스트할 때, json을 text형식으로 보내면, 못 받음. Form형식으로 만들어서 보내야함.
    @PostMapping("/getArr")
    public TestDto getArrDataPost(String[] nums, String name) {
        TestDto dto = new TestDto();
        dto.setId(0);
        dto.setName(name);
        dto.setNums(nums);
        return dto;     
    }
}
