package com.example.cooking.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.cooking.domain.Client;
import com.example.cooking.dto.ResponseDTO;
import com.example.cooking.posts.FreeBoardPost;
import com.example.cooking.repository.UserRepository;
import com.example.cooking.security.UserDetailsImpl;
import com.example.cooking.service.PostService;
import com.example.cooking.service.UserService;

@Controller
public class PostController {

// 게시물 등록(save) 서비스 의존성 주입
	@Autowired
	public PostService postService;
	@Autowired
	public UserService userService;
	
	
	
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
		@ResponseBody
		public ResponseDTO<?> createFreePost(FreeBoardPost freePost,@AuthenticationPrincipal UserDetailsImpl principal) {
				Client client = principal.getClient();
				postService.createFreePost(freePost, client);
				
				return new ResponseDTO<>(HttpStatus.OK.value(),"게시물 등록 완료");
				
		}
}
