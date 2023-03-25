package com.cos.blog.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@DeleteMapping("/api/delete/{id}")
	public ResponseDto<Integer> deleteForm(@PathVariable int id) throws Exception {	
		System.out.println("게시글 삭제 id :" + id);
		boardService.deleteOneBoard(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),200);
	}
	
	@PatchMapping("/api/update/{id}")
	public ResponseDto<Integer> updateForm(@PathVariable int id, @RequestBody Board board) throws Exception {	
		log.info("TRY UPDATE BOARD => [ " + id +" ]"); 
		System.out.println(board.getTitle() + " , " + board.getContent());
		boardService.updateBoard(id,board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),200);
	}


}
