package com.cos.blog.controller.api;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		log.info("TRY JOIN US => [ " + user.toString() +" ]"); // default
		int result = this.userService.save(user);
		log.info("SUCCESS JOIN");
		  
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result) ;
	}
	
	
	// 전통적인 로그인 방식, HttpSession를 위에 @@Autowired 로 걸어서 가져와도 된다.
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user , HttpSession session ){
//		log.info("TRY LOGIN WEBSITE=> [ " + user.toString() +" ]"); // default
//		User principal = userService.login(user); // principal 접근주체
//		if (principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		log.info("SUCCESS LOGIN");
//		  
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1) ;
//	}
	

}
