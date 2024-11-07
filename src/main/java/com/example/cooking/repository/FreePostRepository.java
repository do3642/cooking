package com.example.cooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cooking.posts.FreeBoardPost;

@Repository
public interface FreePostRepository extends JpaRepository<FreeBoardPost, Integer> {

    // 작성자 이름으로 게시글 조회
    Optional<FreeBoardPost> findByClient_Username(String username);

    // 제목으로 게시글 검색
    List<FreeBoardPost> findByTitleContaining(String keyword);

    // 특정 게시글 조회
    Optional<FreeBoardPost> findById(Integer id);
    

}