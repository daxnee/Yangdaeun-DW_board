package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dw.board.mapper.StudentsMapper;
import com.dw.board.vo.StudentsVO;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsMapper studentsMapper;
	@Autowired
	private PasswordEncoder passwordEndoder; // config에 등록한 @bean이 대신해주는 것임! 안쓰면 new로 호출하면 됨
	
	//학생 저장
	public int insertStudents(StudentsVO vo) {
		String password = vo.getStudentsPassword();
		password = passwordEndoder.encode(password); // 가져와서 암호화한 것을 다시 리턴
		vo.setStudentsPassword(password);
		return studentsMapper.insertStudents(vo);
	}
	//
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
