package com.cos.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.model.Board;
import com.cos.blog.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService ;
	
	
	@GetMapping({"","/"})
	public String index(Model model) {
		List<Board> boardList = boardService.selectAllBoard();
		model.addAttribute("boardList", boardList);
		return "index";
	}
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "/board/saveForm";
	}
}
