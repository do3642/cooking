package com.example.cooking.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.cooking.domain.Client;
import com.example.cooking.posts.FreeBoardPost;
import com.example.cooking.repository.UserRepository;
import com.example.cooking.service.PostService;

@Controller
public class PostController {

// 게시물 등록(save) 서비스 의존성 주입
	@Autowired
	public PostService postService;
	@Autowired
	public UserRepository userRepository;
	
	
	
// 게시물 작성 페이지 이동
	@GetMapping("/posts/create")
	public String newpost() {
		return "/post/createPost";
	}
	
	
	
	
	
// 게시판들 맵핑
	// 게시물 작성 페이지 이동
		@GetMapping("/board/freeBoard")
		public String freeBoard() {
			return "/post/freeBoard";
		}
		
		// 게시물 작성 페이지 이동
		@GetMapping("/board/koreanBoard")
		public String koreanBoard() {
			return "/post/koreanBoard";
		}
		
		// 게시물 작성 페이지 이동
		@GetMapping("/board/chineseBoard")
		public String chineseBoard() {
			return "/post/chineseBoard";
		}
		
		// 게시물 작성 페이지 이동
		@GetMapping("/board/japaneseBoard")
		public String japaneseBoard() {
			return "/post/japaneseBoard";
		}
		
		// 게시물 작성 페이지 이동
		@GetMapping("/board/westernBoard")
		public String westernBoard() {
			return "/post/westernBoard";
		}
		// 게시물 작성 페이지 이동
		@GetMapping("/board/restaurantBoard")
		public String restaurantBoard() {
			return "/post/restaurantBoard";
		}
	
	
	
	
// 게시물 등록 맵핑
		@PostMapping("/post/free")
		public ResponseEntity<Map<String, String>> createFreePost(
		    @RequestParam("title") String title,
		    @RequestParam("content") String content,
		    @RequestParam(value = "thumbnail", required = false) MultipartFile thumbnail,
		    Principal principal) {
		    
		    // 로그인한 사용자 정보 가져오기
		    Client client = userRepository.findByUsername(principal.getName())
		        .orElseThrow(() -> new RuntimeException("유저정보가 없습니다."));

		    // 게시물 데이터 처리 (예시로 제목과 내용만 저장)
		    FreeBoardPost freePost = new FreeBoardPost();
		    freePost.setTitle(title);
		    freePost.setContent(content);
		    freePost.setClient(client);
		    
		    // 썸네일 파일이 존재하면 저장 처리
		    if (thumbnail != null && !thumbnail.isEmpty()) {
		        // 파일 저장 로직 추가
		    }
		    
		    // 게시물 저장
		    postService.createFreePost(freePost, client);

		    // JSON 응답 반환
		    Map<String, String> response = new HashMap<>();
		    response.put("message", "게시물이 등록되었습니다.");

		    return ResponseEntity.ok(response);
		}

}
