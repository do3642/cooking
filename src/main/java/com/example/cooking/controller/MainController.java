package com.example.cooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.cooking.posts.FreeBoardPost;
import com.example.cooking.service.PostService;

@Controller
public class MainController {

	@Autowired
    private PostService postService;
	
	@GetMapping("/")
	public String index(Model model) {
		// 추천수 기준으로 인기 게시물 5개 가져오기
        List<FreeBoardPost> popularPosts = postService.getTop5PopularPosts();
        
        // 인기 게시물 목록을 모델에 추가
        model.addAttribute("popularPosts", popularPosts);
        
		return "index";
		
	}
	
}
