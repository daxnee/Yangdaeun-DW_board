package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
