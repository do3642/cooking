package com.example.cooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

	
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
	
	
	
	
	
	
}
