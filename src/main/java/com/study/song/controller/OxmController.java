package com.study.song.controller;

import com.study.song.Service.OxmService;
import com.study.song.model.BoardDTO;
import com.study.song.model.MyResponse;
import com.study.song.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oxm")
public class OxmController {

    private OxmService oxmService;

    @Autowired
    public OxmController(OxmService oxmService) {
        this.oxmService = oxmService;
    }

    @GetMapping("/board/{id}")
    public MyResponse<?> getBoardDetail(@PathVariable int id) {
        return new MyResponse()
                .<BoardDTO>builder()
                .code("200")
                .msg("success")
                .object(oxmService.getBoardDTO(id))
                .build();

    }



}
