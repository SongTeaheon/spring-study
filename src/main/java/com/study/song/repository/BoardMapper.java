package com.study.song.repository;

import com.study.song.model.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {

    BoardDTO selBoardDTOById(int id);
    List<BoardDTO> selListBoardDTO();
    int modBoardDTO(BoardDTO boardDTO);
    int delBoardDTO(int id);
    int insBoardDTO(BoardDTO boardDTO);
}
