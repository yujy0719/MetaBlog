package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService{

	// 스프링이 로그인 요청을 가로챌 때 username이란 변수와 password라는 변수를 가로채는데 
	// password 부분처리는 시큐리티가 알아서 함. 패스워드가 틀렸으면 이것도 시큐리티가 잡아줌 
	// 해당 username이 db에 있는지만 우리는 확인해주면된다.
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserDetails ######");
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다." + username); 
				});
		System.out.println("principal " + principal);
		return new PrincipalDetail(principal); // 시큐리티 세션에 유저 정보가 저장됨 .  시큐리티 세션에 저장 시 정보가 userDetails 타입이기 때문에 ..
	}


	
}
