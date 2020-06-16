package com.study.song.Service;

import com.study.song.model.BoardDTO;
import com.study.song.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OxmServiceImpl implements OxmService{

    BoardMapper boardMapper;

    @Autowired
    public OxmServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public BoardDTO getBoardDTO(int id) {
        return boardMapper.selBoardDTOById(id);
    }

    @Override
    public List<BoardDTO> getListBoardDTO() {
        return boardMapper.selListBoardDTO();
    }

    @Override
    public void removeBoardDTO(int id) {
        boardMapper.delBoardDTO(id);
    }

    @Override
    public void addBoardDTO(BoardDTO board) {
        boardMapper.insBoardDTO(board);
    }

    @Override
    public void modifyBoardDTO(BoardDTO board) {
        boardMapper.modBoardDTO(board);
    }
}
