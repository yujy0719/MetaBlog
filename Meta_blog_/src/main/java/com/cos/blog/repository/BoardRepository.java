package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.Board;

// 자동으로 bean 등록이 가능하다  그래서 @@Repository 어노테이션이 필수 아님
@Repository // 해도 되고 안해도 되고 
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
