package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.board.mapper.StudentsMapper;
import com.dw.board.vo.StudentsVO;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsMapper studentsMapper;
	
	public int insertStudents(StudentsVO vo) {
		return studentsMapper.insertStudents(vo);
	}
	
	//학생 조회
	public List<StudentsVO> getAllStudentsList(){
		return studentsMapper.selectAllStudentsList();
	}
	
	//학생 조회 (map으로 리턴해보기)
	public List<Map<String, Object>> getAllStudentListByMap(){
		return studentsMapper.selectAllStudentsListByMap();
	}
	
	//특정 학생 조회
	public StudentsVO getselectStudents(int studentsId) {
		return studentsMapper.selectStudents(studentsId);
	}
	
	//특정 학생 삭제
	public int getDeleteStudents(int studentsId) {
		return studentsMapper.DeleteStudents(studentsId);
	}
	
	// 특정 학생 수정
	public int getUpdateStudents(StudentsVO vo, int studentsId) {
		vo.setStudentsId(studentsId);
		return studentsMapper.updateStudents(vo, studentsId);
	}
	
}
