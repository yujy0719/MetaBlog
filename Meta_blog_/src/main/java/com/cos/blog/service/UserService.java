package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.controller.api.UserApiController;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

	@Autowired
	private final UserRepository userRepo ;
	@Autowired
	private final BCryptPasswordEncoder encoder;
	
	@Transactional // 여러개의 서비스를 하나의 트랙잭션 로직으로 묶인다. 
	public int save(User user) {
		try {
			// 시큐리티 해쉬 암호화로 값 저장
			String userPW = user.getPassword();
			userPW = encoder.encode(userPW);
			user.setPassword(userPW);
			user.setRole(user.getRole() == null ? RoleType.USER : user.getRole());
			this.userRepo.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("회원가입에 실패했습니다. " + e.getMessage());
		}
		return -1;
	}
	
//	스프링 시큐리티를 통한 로그인을 할 것이기 때문에 아래 전통적인 로그인 방식의 service 단은 제거
//	@Transactional(readOnly = true)
//	public User login(User user) {
//		userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//		System.out.println(user.getUsername() + ">>>> "+ user.getPassword());
//		
//		return user;
//	}
}
