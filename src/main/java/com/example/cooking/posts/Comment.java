package com.example.cooking.posts;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.example.cooking.domain.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 댓글 고유번호

    @Column(nullable = false)
    private String content; // 댓글 내용

    @CreationTimestamp
    private Timestamp createDate; // 댓글 작성일

    @ManyToOne
    private FreeBoardPost freeBoardPost; // 해당 댓글이 달린 자유게시판 게시글 (유효한 경우)

    @ManyToOne
    private RecipePost recipePost; // 해당 댓글이 달린 레시피 게시글 (유효한 경우)

    @ManyToOne
    private RestaurantPost restaurantPost; // 해당 댓글이 달린 맛집추천 게시글 (유효한 경우)

    @ManyToOne
    private Client client; // 댓글 작성자 (유저 정보)
}