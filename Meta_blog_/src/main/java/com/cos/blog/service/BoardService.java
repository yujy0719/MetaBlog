package com.cos.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

	@Autowired
	private final BoardRepository boardRepository ;
	
	@Transactional // 여러개의 서비스를 하나의 트랙잭션 로직으로 묶인다. 
	public int createBoard(Board board, User user) {
		log.info("[createBoard_글등록] " + board.toString());
		board.setUser(user);
		boardRepository.save(board);
		return 1;
	}
	
	@Transactional  
	public Page<Board> selectAllBoard(Pageable pageable) {
		log.info("[selectAllBoard_글목록] ");
		Page<Board> boardList = boardRepository.findAll(pageable);
		return boardList;
	}

	@Transactional  
	public Board selectOneBoard(int id) throws Exception {
		log.info("[selectOneBoard_글상세정보] ");
//		Optional<Board> boardOptional = boardRepository.findById(id);
//		boardOptional.orElseThrow(()->
//			new Exception("data of id is null")
//		);
//		Board board = boardOptional.get();
		return boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시물에 대한 정보가 없습니다."));
	}
	@Transactional  
	public void deleteOneBoard(int id) throws Exception {
		log.info("[deleteOneBoard_글삭제하기] ");
//		Optional<Board> boardOptional = boardRepository.findById(id);
//		boardOptional.orElseThrow(()->
//			new Exception("data of id is null")
//		);
//		Board board = boardOptional.get();
		boardRepository.deleteById(id);
	}
	
	@Transactional  
	public void updateBoard(int id,Board requestboard) throws Exception {
		log.info("[updateBoard_글수정하기] ");
		
		Board board = boardRepository.findById(id)
			.orElseThrow(()->{
				return new IllegalArgumentException("data of id is null");
			});
		board.setTitle(requestboard.getTitle());
		board.setContent(requestboard.getContent());
		
	}
}
