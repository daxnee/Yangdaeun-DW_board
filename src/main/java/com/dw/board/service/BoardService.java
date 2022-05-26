package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dw.board.mapper.BoardMapper;
import com.dw.board.vo.BoardVO;

@Service
public class BoardService {

	@Autowired BoardMapper boardMapper;
	
//	@Autowired
//	private PasswordEncoder passwordEndoder;
	
	//게시판 저장
	public int insertBoard(BoardVO vo) {
		return boardMapper.insertBoard(vo);
	}
	
	//게시판 조회
	public List<Map<String, Object>> selectBoard(){
		return boardMapper.selectBoard();
	}
	
	// ------0526
	//게시물 삭제
	@Transactional(rollbackFor = {Exception.class})
	public int getDeleteBoard(int boardId) {
		return boardMapper.deleteBoard(boardId);
	}
	
	//게시물 수정
	@Transactional(rollbackFor = {Exception.class})
	public int getUpdateBoard(int boardId,BoardVO vo) {
		vo.setBoardId(boardId);
		return boardMapper.updateBoard(vo);
	}
	
	//특정학생 게시물 상세 조회
	@Transactional(rollbackFor = {Exception.class})
	public BoardVO getBoard(int boardId) {
		return boardMapper.getBoard(boardId);
	}
	
}
