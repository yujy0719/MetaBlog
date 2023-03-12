package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.blog.config.auth.PrincipalDetailService;

@Configuration // 빈등록 (ioc 관리)
@EnableWebSecurity // 시큐리티 필터가 등록이 된다. 
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정주소
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	public BCryptPasswordEncoder encodePWD () {
		return new BCryptPasswordEncoder();
	}
	
	//시큐리티가 대신 로그인을 해주는데 password를 가로채기하는데 
	//해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
	//같은 해쉬로 암호화해서 db에 있는 해쉬랑 비교할 수 있음.
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()	 // csrf (test시에 걸어두는 것이 좋음.)
			.authorizeRequests() // 인증요청이 들어오면 
				.antMatchers("/","/auth/**","/js/**","/css/**","/image/**") // /auth/** 로 들어온 요청은 시큐리티 안 거치고 입장가능.
				.permitAll()			 // 모두 허용한다. 
				.anyRequest() 			 // 그 외 요청은 
				.authenticated()		 // 인증을 받아야한다. , 여기까지만 적으면 auth~ 로 들어온요청이 아니면 "Access Denied 접근불허" (HTTP ERROR 403) 에러뜬다.
			.and()						 // and로 이어서 적으면 Access Denied 접근불허 오류 이외에 loginForm 으로 페이지 이동한다. 
				.formLogin()
				.loginPage("/auth/loginForm") // 로그인 요청이 들어오면 해당 로그인 페이지로 이동.
				.loginProcessingUrl("/auth/loginProc")// /auth/loginForm 주소로 요청이 들어오면 시큐리티가 가로채서 로그인 로직을 수행한다. 시큐리티가 대신 로그인을 해준다.
				.defaultSuccessUrl("/"); // 정상로그인이 되면 "/" 메인화면으로 
//				.failureUrl(null) // 실패시 이동할 페이지 .
	}
	
}
