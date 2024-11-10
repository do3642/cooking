package com.example.cooking.posts;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.example.cooking.domain.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RestaurantPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 게시글 고유번호

    @Column(nullable = false, length = 100)
    private String category; // 카테고리
    
    @Column(nullable = false, length = 100)
    private String title; // 제목

    @Column(nullable = false, length = 100)
    private String content; // 내용

    @Column(nullable = false)
    private String thumbnail; // 썸네일 이미지

    @Column(nullable = false, length = 100)
    private String storeName; // 상호명

    @Column(nullable = false, length = 100)
    private String region; // 지역명

    @CreationTimestamp
    private Timestamp createDate; // 생성 시간

    private Timestamp updateDate; // 수정 시간

    @ManyToOne
    private Client client; // 게시글 작성자 (유저 정보)

    @Column(nullable = false)
    private int viewCount = 0; // 조회수

    @OneToMany(mappedBy = "restaurantPost")
    private List<Comment> comments; // 해당 게시글에 달린 댓글들
    
    @Column(nullable = false)
    private int recommendationCount = 0; // 추천 수
}