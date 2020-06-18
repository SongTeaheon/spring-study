package com.study.song.Service;

import com.study.song.model.BoardDTO;
import com.study.song.repository.BoardMapper;
import com.study.song.utils.MyException;
import com.study.song.utils.MyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
    public void removeBoardDTO(int id) throws MyException {
        int delCnt = boardMapper.delBoardDTO(id);
        if(delCnt <= 0) {
            throw new MyException("데이터 삭제에 실패했습니다.");
        }
    }

    @Override
    public void addBoardDTO(BoardDTO board) throws MyException {
        if(MyUtil.isEmptyStr(board.getTitle())
                || MyUtil.isEmptyStr(board.getContent())
                || MyUtil.isEmptyStr(board.getWriter())){
            throw new MyException("필수입력값이 누락되었습니다.");
        }

        int insCnt = boardMapper.insBoardDTO(board);
        log.info("add " + insCnt);

        if(insCnt <= 0) {
            throw new MyException("데이터 추가에 실패했습니다.");
        }
    }

    @Override
    public void modifyBoardDTO(BoardDTO board) throws MyException {
        if(MyUtil.isEmptyStr(board.getTitle())
                || MyUtil.isEmptyStr(board.getContent())) {
            throw new MyException("필수입력값이 누락되었습니다.");
        }

        int modCnt = boardMapper.modBoardDTO(board);
        log.info("mod " + modCnt);
        if(modCnt <= 0) {
            throw new MyException("수정된 데이터가 없습니다.");
        }
    }
}
