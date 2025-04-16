package edu.kh.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.demo.model.dto.Student;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("example") //   /example로 시작하는 주소를 해당 컨트롤러에 매핑
@Slf4j  // lombok 라이브러리가 제공하는 로그 객체 자동생성 어노테이션
public class ExampleController {

	/* Model (org.springframework.ui.Model)
	 * - Spring 에서 데이터 전달 역할을 하는 객체
	 * 
	 * - 기본 scope : request
	 * 
	 * - @SessionAttibute 와 함께 사용 시 session scope 변환
	 * 
	 * [기본 사용법]
	 * model.addAttrubute("key", value); 
	 * 
	 * */
	
	@GetMapping("ex1")
	public String ex1(HttpServletRequest req, Model model) {
		
		// Servlet 내장객체 범위
		// page < request < session < application
		req.setAttribute("test1", "HttpServletRequest로 전달한 값");
		model.addAttribute("test2", "Model로 전달한 값");
		
		// 단일 값(숫자, 문자열) Model을 이용해서 html로 전달
		model.addAttribute("productName", "종이컵");
		model.addAttribute("price", 2000);
		
		// 복수값 (배열 List) Model 이용해서 html로 전달
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("바나나");
		
		model.addAttribute("fruitList", fruitList);
		
		// DTO 객체 Model을 이용해서 html로 전달
		Student std = new Student();
		std.setStudentNo("12345");
		std.setName("홍길동");
		std.setAge(22);
		
		model.addAttribute("std", std);
		
		// List<Student> 객체를 Model을 이용해서 html로 전달
		List<Student> stdList = new ArrayList<>();
		
		stdList.add(new Student("11111", "김일번", 20));
		stdList.add(new Student("22222", "최이번", 23));
		stdList.add(new Student("22222", "홍삼번", 22));
		
		model.addAttribute("stdList", stdList);
		
		
		// src/main.resources/templates/example/ex1.html 로 forward
		return "example/ex1";
	}
	
	@PostMapping("ex2") // /example/ex2 Post 방식 요청 매핑
	public String ex2(Model model) {
		 
		model.addAttribute("str", "<h1>테스트 중 &times; </h1>");
		
		return "example/ex2";
	}
}
