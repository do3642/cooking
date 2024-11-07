package com.example.cooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cooking.posts.RestaurantPost;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantPostRepository extends JpaRepository<RestaurantPost, Integer> {

    // 음식점 이름으로 게시글 검색
    List<RestaurantPost> findByStoreNameContaining(String storeName);

    // 특정 음식점 게시글 조회
    Optional<RestaurantPost> findById(Integer id);

    // 지역별로 음식점 게시글 조회
    List<RestaurantPost> findByRegionContaining(String region);
    
    // 추천수 기준으로 음식점 게시글 정렬
    List<RestaurantPost> findTop5ByOrderByRecommendationCountDesc();
}
