package com.cos.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.blog.controller.api.BoardApiController;
import com.cos.blog.model.Board;
import com.cos.blog.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService ;
	
	
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size=3,sort="id", direction=Sort.Direction.DESC) Pageable pageable) {
		Page<Board> boardList = boardService.selectAllBoard(pageable);
		model.addAttribute("boardList", boardList);
		return "index";
	}
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "/board/saveForm";
	}
	
	@GetMapping("/board/{id}")
	public String detailForm(@PathVariable int id , Model model) throws Exception {	
		model.addAttribute("board", boardService.selectOneBoard(id));
			
		return "/board/detailForm";
	}
	
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id , Model model) throws Exception {	
		log.info("TRY UPDATE BOARD => [ " + id +" ]"); 
		model.addAttribute("board", boardService.selectOneBoard(id));
			
		return "/board/updateForm";
	}
	
}
