package com.cos.blog.controller;

//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.blog.model.User;

import lombok.extern.slf4j.Slf4j;


// 인증이 안된 사용자들이 출입할 수 있는 경로릏 /auth/** 으로 하나 만든다.
// 그냥 주소가 /이면 index.jsp 허용 
// static 이하에 있는 /js/**, css/**, /image/**
@Slf4j
@Controller
public class UserController {

	//private final Logger log = LoggerFactory.getLogger(null)
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		log.info("info message"); // default
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}
}
