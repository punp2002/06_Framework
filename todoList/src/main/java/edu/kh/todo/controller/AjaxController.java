package edu.kh.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;
import lombok.extern.slf4j.Slf4j;

/*
 * @ResponsBody
 * - 컨트롤러 메서드의 반환값을
 * 	 Http 응답 본문에 직접 바인딩하는 역할임을 명시
 * 
 * -> 컨트롤러 메서드의 반환값을
 * 	비동기 요청 했던 HTML/JS 파일 부분에 값을 그대로 돌려보낼 것이다.
 * 
 * -> 해당 어노테이션이 붙은 컨트롤러의 메서드는 return에 작성된 값이 forward / redirect 로 인식 X
 * 
 * @RequestBody
 * - 비동기 요청시 전달되는 데이터중 body 부분에 포함된 요청 데이터를
 * 	 알맞은 Java 객체 타입으로 바인딩하는 어노테이션
 * 
 * - 기본적으로 JSON 형식을 기대함.
 * 
 * [HttpMessageConvertor]
 * Spring에서 비동기 통신 시
 * - 전달 받은 데이터의 자료형
 * - 응답 하는 데이터의 자료형
 * 위 두가지를 알맞은 형태로 가공(변환)해주는 객체
 * 
 * 		Java					JS
 * 문자열, 숫자 <------------->TEXT
 * 	 	Map    <->  JSON   <-> JS Object
 * 	 	DTO    <->  JSON   <-> JS Object
 * 
 * (참고)
 * Spring 에서 HttpMessageConvertor 작동하기 위해서는
 * jackson-data-bind 라이브러리가 필요한데
 * Spring boot 에는 모듈에 내장되어 있음
 *  
 * */

@Controller // 요청/응답 제어하는 역할 명시 + Bean 등록
@RequestMapping("ajax") // 요청 주소 시작이 "ajax"인 요청을 매핑
@Slf4j
public class AjaxController {
	
	// @Autowired
	// - 등록된 Bean 중 같은 타입 또는 상속관계인 Bean을 찾아
	// 	 해당 필드에 의존성 주입
	
	@Autowired // DI 의존성 주입
	private TodoService service;
	
	@GetMapping("main")
	public String ajaxMain() {
		return "ajax/main";
	}
	
	// 전체 Todo 개수 조회
	// -> forward / redirect 를 원하는게 아님!
	// -> "전체 Todo 개수" 라는 데이터를 비동기 요청 보낸 클라이언트(브라우저) 반환되는 것을 원함.
	// -> 반환되어야하는 결과값의 자료형을 반환형에 써야함!
	@ResponseBody // 반환값을 HTTP 응답 본문으로 직접 전송 (값 그대로 돌려보낼꺼야!!!)
	@GetMapping("totalCount")
	public int getTotalCount() {		
		
		// 전체 할 일 개수 조회 서비스 호출 결과 반환받기
		int totalCount = service.getTotalCount();
		
		// 이자리에 결과 작성하기
		return totalCount;
	}

	@ResponseBody
	@GetMapping("completeCount")
	public int getCompleteCount() {
		return service.getCompleteCount();
	}
	
	// 할 일 추가
	@ResponseBody
	@PostMapping("add")
	public int addTodo(@RequestBody Todo todo) { // 요청body에 담긴 값을 Todo DTO에 저장
		// @RequestParam 은 일반적으로 쿼리파라미터나 url 파라미터에 사용
		log.debug("todo : " + todo);
		
		// 할 일 추가 서비스 호출 후 응답
		int result = service.addTodo(todo.getTodoTitle(), todo.getTodoContent());
		
		return result;
		
	}
	
	// 전체 할일 목록 조회
	@ResponseBody
	@GetMapping("selectList")
	public List<Todo> selectList(){
		List<Todo> todoList = service.selecList();
		
		return todoList;
		
		// List(Java 전용 타입)를 반환
		// -> JS 가 인식할 수 없기 때문에 JSON으로 변환 필요!
		// -> HttpMessageConvertor 가 JSON 형태로 변환하여 반환
	}
	
	// 할 일 상세 조회
	@ResponseBody   // 비동기 요청을 보낸곳으로 데이터(반환값) 돌려보냄
	@GetMapping("detail")
	public Todo selectTodo(@RequestParam("todoNo") int todoNo) {		
		return service.todoDetail(todoNo);
		// return 자료형 : Todo(dto)
		// -> HttpMessageConvertor 가 String(JSON) 형태로 변환해서 반환		
	}
	
	// 할일 삭제 요청(DELETE)
	@ResponseBody
	@DeleteMapping("delete")
	public int todoDelete(@RequestBody int todoNo) {		
		return service.todoDelete(todoNo);
	}
	
	// 완료 여부 변경(PUT)
	@ResponseBody
	@PutMapping("changeComplete")
	public int changeComplete(@RequestBody Todo todo) {
		return service.changeComplete(todo);
	}
	
	// 할 일 수정(PUT)
	@ResponseBody
	@PutMapping("update")
	public int todoUpdate(@RequestBody Todo todo) {
		return service.todoUpdate(todo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
