package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dw.board.vo.BoardVO;

/**
 * @author admin
 *
 */
@Mapper
public interface BoardMapper {

	/**
	 * @param vo
	 * @return
	 * @author : Daeun Yang
	 * @date : 2022. 5. 19.
	 * comment : 게시판 저장
	 */
	public int insertBoard(BoardVO vo);
	/**
	 * @return
	 * @author : Daeun Yang
	 * @date : 2022. 5. 19.
	 * comment : 게시판 조회
	 */
	public List<Map<String, Object>> selectBoard();
	
	/**
	 * @param boardId
	 * @return
	 * comment : 게시판 게시물 삭제
	 */
	public int deleteBoard(int boardId);
	
	/**
	 * @param boardId
	 * @return
	 * comment : 게시판 게시물 수정
	 */
	public int updateBoard(BoardVO vo);
	
	
	/**
	 * @param boardId
	 * @return
	 * comment : 특정 회원 게시물 조회
	 */
	public BoardVO getBoard(int boardId);
	
	
	
	
}
