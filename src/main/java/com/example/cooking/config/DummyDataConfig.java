package com.example.cooking.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.cooking.posts.FreeBoardPost;

import com.example.cooking.service.PostService;
import com.example.cooking.service.UserService;
import com.example.cooking.domain.Client;

import java.util.stream.IntStream;

@Configuration
public class DummyDataConfig {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            try {
                // 사용자 중복 검사
                if (userService.findByNickname("관리자") == null) {
                    Client testClient = new Client(0, "admin", "1234", "관리자", "do36421@naver.com", "010-1234-5678", null, 0, null);
                    userService.register(testClient);
                } else {
                    System.out.println("관리자 계정은 이미 존재합니다.");
                }

                // 자유게시판 더미 게시글 20개 추가
                Client client = userService.findByNickname("관리자"); // 사용자 찾기
                if (client != null) {
                    IntStream.rangeClosed(1, 20).forEach(i -> {
                        FreeBoardPost post = new FreeBoardPost();
                        post.setTitle("더미 제목 " + i);
                        post.setContent("더미 내용 " + i);
                        post.setViewCount((int) (Math.random() * 100)); // 조회수 임의 설정
                        post.setCategory("free"); // category 값 설정
                        postService.createFreePost(post, client);
                    });
                    System.out.println("더미 데이터 추가 완료!");
                }

            } catch (Exception e) {
                System.err.println("더미 데이터 생성 중 오류 발생: " + e.getMessage());
                e.printStackTrace();
            }
        };
    }
   }