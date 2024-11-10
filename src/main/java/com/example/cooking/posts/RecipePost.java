package com.example.cooking.posts;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.example.cooking.domain.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RecipePost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글 고유번호

    @Column(nullable = false, length = 100)
    private String category; // 카테고리
    
    @Transient // DB에 저장되지 않도록 설정
    private MultipartFile thumbnail; // 썸네일 이미지 (실제 파일 객체)

    @Column(nullable = false)
    private String thumbnailFilename; // 저장된 파일명 (파일 시스템에 저장된 파일명)

    @Column(nullable = false, length = 100)
    private String title; // 제목

    @Column(nullable = false, length = 500)
    private String content; // 내용

    @Column(nullable = false)
    private String servings; // 몇 인분인지

    @Column(nullable = false)
    private String cookTime; // 조리 시간

    @CreationTimestamp
    private Timestamp createDate; // 생성 시간

    private Timestamp updateDate; // 수정 시간

    @ManyToOne
    private Client client; // 게시글 작성자 (유저 정보)

    @Column(nullable = false)
    private int viewCount = 0; // 조회수

    @Enumerated(EnumType.STRING)
    private CuisineType cuisineType; // 한식, 중식, 일식, 양식, 기타 (레시피 종류)

    @OneToMany(mappedBy = "recipePost")
    private List<Comment> comments; // 해당 게시글에 달린 댓글들
    
    @Column(nullable = false)
    private int recommendationCount = 0; // 추천 수
    
    // 재료와 조리 순서를 RecipePost와 함께 저장
    @ElementCollection
    private List<String> ingredients; // 재료 목록 (예: ["재료1", "재료2"])

    @ElementCollection
    private List<String> steps; // 조리 방법 목록 (예: ["조리 순서 1", "조리 순서 2"])
    
    
    
    
    
    
    
    
    
    
    
    
}