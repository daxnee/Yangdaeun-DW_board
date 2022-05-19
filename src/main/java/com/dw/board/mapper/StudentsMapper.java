package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dw.board.vo.StudentsVO;

@Mapper
public interface StudentsMapper {
	//단축키 : 해당 메소드를 클릭하고 + alt + shift + J
	/**
	 * @param vo
	 * @return
	 * @author : Daeun Yang
	 * @date : 2022. 5. 18.
	 * comment : 학생 저장
	 */
	public int insertStudents(StudentsVO vo);
	/**
	 * @return
	 * @author : Daeun Yang
	 * @date : 2022. 5. 18.
	 * comment : 학생 조회
	 */
	public List<StudentsVO> selectAllStudentsList();
	
	/**
	 * @return
	 * @author : Daeun Yang
	 * @date : 2022. 5. 18.
	 * comment : map으로 조회
	 */
	public List<Map<String, Object>> selectAllStudentsListByMap();
	
	public StudentsVO selectStudents(int studentsId);
	
	public int deleteStudents(int studentsId);
	
	public int updateStudents(StudentsVO vo);
		
	/**
	 * @param vo
	 * @return
	 * @author : Daeun Yang
	 * @date : 2022. 5. 19.
	 * comment : 학생 이름으로 학생정보 조회
	 */
	public StudentsVO selectStudentsOne(StudentsVO vo);
	
	
}
