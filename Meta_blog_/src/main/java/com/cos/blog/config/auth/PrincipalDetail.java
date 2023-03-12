package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

import lombok.Getter;

/*
 * 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails타입의 오브젝트를 
 * 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다. 
 * */

@Getter
public class PrincipalDetail implements UserDetails{

	private User user; // 컴포지션
	
	public PrincipalDetail(User user) {
		this.user = user;
	}

	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	//계정이 만료되지 않았는지 리턴한다. (true/만료되지않음)
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	//계정이 잠겨있지 않은지 리턴한다. (true/잠기지않음)
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	// 비밀번호가 만료되지 않았는지 리턴한다 (true : 만료안됨)
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	// 계정이 활성화(사용가능)인지 리턴한다 (true:활성화)
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	// 계정이 갖고 있는 권한 목록을 리턴한다.( 권한이 여러개가 있을 수 있어서 루프를 돌아야하는데 우리는 USER 한개만)
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		System.out.println();
		collectors.add(()-> {return "ROLE_" + user.getRole();});
		return collectors;
		
		// 밑에 껄, 위에서 람다식으로 표현. 
//		collectors.add(new GrantedAuthority() {
//			@Override
//			public String getAuthority() {
//				return "ROLE_" + user.getRole(); // "ROLE_" 은 필수. 스프링 규칙. prefix로 꼭 붙여줘야함.
//			}
//		});
	}

	
}
