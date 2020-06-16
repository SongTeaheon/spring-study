package com.study.song.controller;

import com.study.song.Service.OxmService;
import com.study.song.model.BoardDTO;
import com.study.song.model.MyResponse;
import com.study.song.repository.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/oxm")
public class OxmController {

    private OxmService oxmService;

    @Autowired
    public OxmController(OxmService oxmService) {
        this.oxmService = oxmService;
    }

    @GetMapping("/board/{id}")
    public MyResponse<?> getBoardDetail(@PathVariable int id) {
        return MyResponse
                .<BoardDTO>builder()
                .code("200")
                .msg("success")
                .object(oxmService.getBoardDTO(id))
                .build();
    }

    @GetMapping("/board/list")
    public MyResponse<?> getBoardAll() {
        return MyResponse
                .<List<BoardDTO>>builder()
                .code("200")
                .msg("success")
                .object(oxmService.getListBoardDTO())
                .build();
    }

    @PostMapping(value = "/board/new")
    public MyResponse<?> insBoard(@RequestBody BoardDTO boardDTO) {
        oxmService.addBoardDTO(boardDTO);
        return MyResponse
                .builder()
                .code("200")
                .msg("success")
                .object(null)
                .build();
    }

    @PutMapping("/board")
    public MyResponse<?> modBoard(@RequestBody BoardDTO boardDTO) {
        log.info(boardDTO.toString());
        oxmService.modifyBoardDTO(boardDTO);
        return MyResponse
                .builder()
                .code("200")
                .msg("success")
                .object(null)
                .build();
    }

    @DeleteMapping("/board/{id}")
    public MyResponse<?> removeBoard(@PathVariable int id) {
        oxmService.removeBoardDTO(id);
        return MyResponse
                .builder()
                .code("200")
                .msg("success")
                .object(null)
                .build();
    }




}
