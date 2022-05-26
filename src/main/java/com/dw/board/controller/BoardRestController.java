package com.dw.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw.board.service.BoardService;
import com.dw.board.vo.BoardVO;

@RestController
@RequestMapping("/api/v1")
public class BoardRestController {
	
	
	@Autowired
	private BoardService boardService;
	
		//게시판 저장(C)
		@CrossOrigin
		@PostMapping("/board")
		public int callSaveBoard(@RequestBody BoardVO vo) {
			return boardService.insertBoard(vo);
		}
		
		//게시판 전체조회(R)
		@CrossOrigin
		@GetMapping("/board")
		public List<Map<String, Object>> callBoardList(){
			return boardService.selectBoard();
		}
		
		//----0526
		//게시물 삭제(D)
		@CrossOrigin
		@DeleteMapping("/board/boardId/{id}")
		public int callRemoveBoard(@PathVariable("id") int boardId) {
			return boardService.getDeleteBoard(boardId);
		}
		
		
		//게시물 수정(U)
		@CrossOrigin
		@PatchMapping("/board/boardId/{id}")
		public int callUpdateBoard(@PathVariable("id") int boardId, @RequestBody BoardVO vo) {
			// url에 입력한 boardId는 int boardId에, postman으로 입력한 데이터는  BoardVO vo에 들어가있음
			return boardService.getUpdateBoard(boardId,vo);
		}
		
		
		//게시물 상세보기
		@CrossOrigin
		@GetMapping("/board/boardId/{id}")
		public BoardVO callBoard(@PathVariable("id") int boardId) { //사용자의 요구사항이 매번 달라지니까 데이터 타입을 포괄적으로 (BoardVO로) 받아준다.
			return boardService.getBoard(boardId);
		}
		
		
}
