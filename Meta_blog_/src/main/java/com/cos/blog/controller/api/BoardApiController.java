package com.cos.blog.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.Board;
import com.cos.blog.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BoardApiController {
	
	@Autowired
	BoardService boardService;
	
//	authentication
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board , @AuthenticationPrincipal PrincipalDetail principl) {
		
		
		log.info("TRY WRITE BOARD => [ " + board.toString() +" ]"); 
		try {
			System.out.println("타이틀 : " + board.getTitle());
			System.out.println("내 용 : " + board.getContent());
			System.out.println("조회수 : " + board.getCount());
			System.out.println("작성자 : " + principl);
			boardService.createBoard(board , principl.getUser());
			log.info("SUCCESS WRITE BOARD");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		  
		return new ResponseDto<Integer>(HttpStatus.OK.value(),200) ;
	}


}
