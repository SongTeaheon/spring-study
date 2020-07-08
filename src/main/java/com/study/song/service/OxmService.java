package com.study.song.service;

import com.study.song.model.BoardDTO;
import com.study.song.utils.MyException;

import java.util.List;

public interface OxmService {
    BoardDTO getBoardDTO(int id);
    List<BoardDTO> getListBoardDTO();
    void removeBoardDTO(int id) throws MyException;
    void addBoardDTO(BoardDTO board) throws MyException;
    void modifyBoardDTO(BoardDTO board) throws MyException;

}
