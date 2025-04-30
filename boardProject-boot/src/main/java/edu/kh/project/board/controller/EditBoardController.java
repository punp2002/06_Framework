package edu.kh.project.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.project.board.model.service.EditBoardService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("editBoard")
@Slf4j
public class EditBoardController {
 
	@Autowired
	private EditBoardService service;
	
	// 게시글 작성 화면 전환
	@GetMapping("{boardCode:[0-9]+}/insert") // /editBoard/${boardCode}/insert
	public String boardInsert(@PathVariable("boardCode") int boardCode) {
		
		return "board/boardWrite";
	}
}
