package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
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

}
