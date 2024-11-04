package com.example.cooking.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, length = 40)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(unique = true, nullable = false, length = 40)
    private String nickname;

    @Column(nullable = false, length = 40)
    private String email;

    @Column(nullable = false, length = 15) 
    private String tel;

    @CreationTimestamp
    private Timestamp createDate;

    // 게시글 개수에 따라 등급 상승을 위한 필드
    private int postCount = 0; // 초기값 0

    @Enumerated(EnumType.STRING)
    private RoleType role; 
}