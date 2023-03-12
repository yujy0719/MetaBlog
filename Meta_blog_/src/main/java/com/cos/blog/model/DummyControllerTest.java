package com.cos.blog.model;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cos.blog.repository.UserRepository;


@RestController
public class DummyControllerTest {
	
	@Autowired
	private UserRepository userRepository; 
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		
		user.setUsername("하용권");
		user.setPassword("save-man");
		user.setRole(RoleType.USER);
		
		this.userRepository.save(user);
		return "회원가입이 완료되었습니다. ";
	}
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {

		User user = this.userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException> () {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id : " + id );
			}
		});
		
		// 람다식
//		this.userRepository.findById(id).orElseThrow(()->{
//			return new IllegalArgumentException("해당 유저는 없습니다. id : " + id );
//		});
		
		return user;
	}
//	
//	@GetMapping("/dummy/user")
//	public List<User> pageList(@PageableDefault(size=2, sort="id", direction= Sort.Direction.DESC) Pageable pageable) {
//		
//		Page<User> pageUser = this.userRepository.findAll(pageable);
//		List<User> users = pageUser.getContent();
//		return users;
//	}
	@GetMapping("/dummy/user")
	public Page<User> pageList(@PageableDefault(size=2, sort="id", direction= Sort.Direction.DESC) Pageable pageable) {
		
		Page<User> pageUser = this.userRepository.findAll(pageable);
		//List<User> users = pageUser.getContent();
		return pageUser;
	}
	
	@DeleteMapping("/dummy/user/{id}")
	public String pageList(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			return "삭제에 실패하였습니다." + id;
		}
	
		return "해당 유저가 삭제되었습니다. ";
	}
	
}
