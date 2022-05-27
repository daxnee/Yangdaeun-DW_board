package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dw.board.vo.BoardVO;

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
	
	
	//삭제
	public int deleteBoard(int boardId);
	
	//수정
	public int updateBoard(BoardVO vo);
	
	//상세보기
	public BoardVO getBoard(int boardId);
	
	
	/**
	 * @param boardId
	 * @return
	 * @author : Daeun Yang
	 * @date : 2022. 5. 27.
	 * comment : 특정 회원 조회(count)
	 */
	public BoardVO selectBoardOne(int boardId);
	
	/**
	 * @param vo
	 * @return
	 * @author : Daeun Yang
	 * @date : 2022. 5. 27.
	 * comment : 조회수 count keyup
	 */
	public int updateBoardViews(BoardVO vo);
	
	//map 쿼리스트링
	public List<Map<String, Object>> selectSearchBoardList(String studentsName);
	// 파라미터값이 두개면 @param 써줘야 한다. 한 개는 생략 가능
	

}
