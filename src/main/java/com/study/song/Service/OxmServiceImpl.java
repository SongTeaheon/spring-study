package com.study.song.Service;

import com.study.song.model.BoardDTO;
import com.study.song.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OxmServiceImpl implements OxmService{

    @Autowired
    BoardMapper boardMapper;

    @Override
    public BoardDTO getBoardDTO(int id) {
        return boardMapper.selBoardDTOById(id);
    }

    @Override
    public List<BoardDTO> getListBoardDTO() {
        return null;
    }

    @Override
    public void removeBoardDTO(int id) {

    }

    @Override
    public void addBoardDTO(BoardDTO board) {

    }

    @Override
    public void modifyBoardDTO(int id, BoardDTO board) {

    }
}
