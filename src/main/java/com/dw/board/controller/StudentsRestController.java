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

import com.dw.board.service.StudentsService;
import com.dw.board.vo.StudentsVO;

@RestController
@RequestMapping("/api/v1") // v1: version
// @RequestMapping("/api/v1") : 아래 중복되는 URL을 간소화
public class StudentsRestController {

	@Autowired
	private StudentsService studentsService;
	
	//학생 저장
		//post는 body로 데이터를 받음(보안)
		@CrossOrigin 
		@PostMapping("/students")
		public int callSaveStudents(@RequestBody StudentsVO vo) {
			return studentsService.insertStudents(vo);
		}

	//학생 조회
		@GetMapping("/students")
		public List<StudentsVO> callStudentsList(){
			return studentsService.getAllStudentsList();
		}
	
	//학생 조회 (map으로 리턴해보기)
		@GetMapping("/students/map")
		public List<Map<String, Object>> callStudentsListByMap(){
			return studentsService.getAllStudentListByMap();
		}
	
	//특정 학생 조회(PK로 조회예정)
		@GetMapping("/students/id/{id}")
		public StudentsVO callStudents(@PathVariable("id") int studentsId) {
			
			return studentsService.getselectStudents(studentsId);
		}
		
		
	// 특정 학생 delete
		@DeleteMapping("/students/id/{id}")
		public int callRemoveStudents(@PathVariable("id") int studentsId) {
			return studentsService.getDeleteStudents(studentsId);
		}
	
	// 특정 학생 update
		@PatchMapping("/students/id/{id}")
		public int callUpdateStudents(@PathVariable("id") int studentsId, @RequestBody StudentsVO vo){
			return studentsService.getUpdateStudents(vo, studentsId);
		}
		
		
		
}
