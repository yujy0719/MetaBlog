package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;


// 자동으로 bean 등록이 가능하다  그래서 @@Repository 어노테이션이 필수 아님
@Repository // 해도 되고 안해도 되고 
public interface UserRepository extends JpaRepository<User, Integer> {
	
	//SELECT * FORM user WHERE username =1?;
	Optional<User> findByUsername(String username);
	
	// JPA NAMING 쿼리 전략
	// SELECT * FROM user WHERE username = ? AND password = ?;
//	스프링 시큐리티를 통한 로그인을 할 것이기 때문에 아래 전통적인 로그인 방식의 service 단은 제거
//	User findByUsernameAndPassword (String username , String password);

	// findByUsernameAndPassword 매소드와 아래 매소드가 같은 기능이다.
//	@Query(value="SELECT * FROM user WHERE username = ?1 AND password=?2" , nativeQuery = true)
//	User login(String username , String password);
}
