package com.example.cooking.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cooking.posts.RecipePost;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipePostRepository extends JpaRepository<RecipePost, Integer> {

    // 제목으로 레시피 게시글 검색
    List<RecipePost> findByTitleContaining(String keyword);

    // 특정 레시피 게시글 조회
    Optional<RecipePost> findById(Integer id);

    // 추천수 기준으로 레시피 게시글 정렬
    List<RecipePost> findTop5ByOrderByRecommendationCountDesc();
    
    // 등록 날짜를 기준으로 내림차순으로 레시피 6개 가져오기
    Page<RecipePost> findAllByOrderByCreateDateDesc(Pageable pageable);
}
