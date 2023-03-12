package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert // null인 필드 인서트를 제외한다.
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	int id;
	@Column(nullable=false,length=30)
	private String username;
	@Column(nullable=false,length=100)
	private String password;
	@Column(nullable=false,length=50, unique = true)
	private String email;
//	@ColumnDefault("'user'") // enum을 쓰지 않았을 때 
	@Enumerated(EnumType.STRING)
	private RoleType role;
	@CreationTimestamp // 시간이 자동입력
	private Timestamp createDate;
	
	
}
