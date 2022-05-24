package com.dw.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
// url주소 검색할 때는 api/v1 붙여야 함!
public class StudentsRestController {

	@Autowired
	private StudentsService studentsService;
	
	//0519
	//중요한 정보를 서버에 전송할 때 post사용!
	@CrossOrigin 
	@PostMapping("/login") 
	public boolean callIsLogin(@RequestBody StudentsVO vo, HttpSession httpSession) { // 회원정보, 이름만 있는 상태
		boolean isLogin = studentsService.IsStudents(vo); // IsStudents()결과를 (true) isLogin에 넣어줌 (비밀번호가 같은지 다른지)
		if(isLogin) {
			httpSession.setAttribute("name", "yangdaeun"); //true면 세션에 저장
			// 세션에 저장하는 방식은 key, value
			// 내가 설정하기 전까진 yangdaeun 이름이 세션 value에 저장됨
		}
		return studentsService.IsStudents(vo); 
	}
	// boolean으로 html과 db에서 온 데이터(비밀번호)를 비교해서 같으면 true, 다르면 false를 반환함(postman)에서 확인가능
	// 학생을 저장하고(post), 같은 json데이터를 비교하면(post) 비번을 확인해 결과를 리턴한다.
	
	
	//post는 body로 데이터를 받아야 한다(보안)
	//ex) password가 url에 보이면 안되는 이유

	//학생 저장
		@CrossOrigin 
		@PostMapping("/students") // api/v1/students : api주소고 버전은 1이라는 뜻
		public int callSaveStudents(@RequestBody StudentsVO vo) {
			return studentsService.insertStudents(vo);
		}

	//VO로 학생 조회
		@GetMapping("/students")
		public List<StudentsVO> callStudentsList(){
			return studentsService.getAllStudentsList();
		}
	
	//학생 조회 (map으로 리턴해보기) //세션에서 불러오기 0524
		@GetMapping("/students/map")
//		public List<Map<String,Object>> callStudentsListByMap()
		public List<Map<String,Object>> callStudentsListByMap(HttpSession httpSession){
			String name = (String)httpSession.getAttribute("name");
			System.out.println("세션에서 가져온 이름은 ===> " + name);
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
