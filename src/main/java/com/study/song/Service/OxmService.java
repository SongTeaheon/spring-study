package com.study.song.Service;

import com.study.song.model.BoardDTO;

import java.util.List;

public interface OxmService {
    BoardDTO getBoardDTO(int id);
    List<BoardDTO> getListBoardDTO();
    void removeBoardDTO(int id);
    void addBoardDTO(BoardDTO board);
    void modifyBoardDTO(int id, BoardDTO board);

}
