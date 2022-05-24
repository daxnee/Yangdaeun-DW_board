package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(rollbackFor = {Exception.class})
	public int getDeleteStudents(int studentsId) {
		return studentsMapper.deleteStudents(studentsId);
	}
	
	// 특정 학생 수정
	@Transactional(rollbackFor = {Exception.class})
	public int getUpdateStudents(StudentsVO vo, int studentsId) {
		vo.setStudentsId(studentsId);
		return studentsMapper.updateStudents(vo);
	}
	
	//가입된 학생인지 아닌지 여부 체크
	public boolean IsStudents(StudentsVO vo) { // post로 이름을 받아옴 
		StudentsVO student = studentsMapper.selectStudentsOne(vo); // student mapper에서 쿼리를 돌린 결과를 변수에 대입
		if(student == null) { // 쿼리 결과가 null이면 리턴
			return false;
		}
		String inputPassword = vo.getStudentsPassword(); // HTML에서 가져온(입력한) 비밀번호
		String password = student.getStudentsPassword(); // DB에서 가져온 비밀번호
		
		if(!passwordEndoder.matches(inputPassword, password)) {
			return false;
		}//비번이 다르면 false
		
		return true;
	}
	
}
