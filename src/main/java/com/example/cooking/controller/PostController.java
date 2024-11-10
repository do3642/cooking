package com.example.cooking.controller;

import java.io.File;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.cooking.domain.Client;
import com.example.cooking.dto.PageDTO;
import com.example.cooking.dto.ResponseDTO;
import com.example.cooking.posts.FreeBoardPost;
import com.example.cooking.posts.RecipePost;
import com.example.cooking.posts.RestaurantPost;
import com.example.cooking.repository.UserRepository;
import com.example.cooking.security.UserDetailsImpl;
import com.example.cooking.service.FileStorageService;
import com.example.cooking.service.PostService;
import com.example.cooking.service.UserService;

@Controller
public class PostController {

// 게시물 등록(save) 서비스 의존성 주입
	@Autowired
	public PostService postService;
	@Autowired
	public UserService userService;
	@Autowired
	private FileStorageService fileStorageService;
	
	
	
// 게시물 작성 페이지 이동
	@GetMapping("/posts/create")
	public String newpost() {
		return "/post/createPost";
	}
	
	
	
	
	
// 게시판들 맵핑
	// 게시물 작성 페이지 이동
//		@GetMapping("/board/freeBoard")
//		public String freeBoard() {
//			return "/post/freeBoard";
//		}
//		
		@GetMapping("/board/freeBoard")
		public String getFreePostList(Model model, @PageableDefault(size=7,sort="id",direction = Direction.DESC) Pageable pageable) {
			
			Page<FreeBoardPost> postList = postService.getPostList(pageable);
			
			// html로 데이터를 보내기 위한 모델객체
			model.addAttribute("postList", postList);
			model.addAttribute("pageDTO", new PageDTO(postList));
			
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
		
		// 게시물 등록 맵핑
				@PostMapping("/post/recipe")
				@ResponseBody
				public ResponseDTO<?> createRecipePost(@ModelAttribute RecipePost recipe, @RequestParam("thumbnail") MultipartFile thumbnail, @AuthenticationPrincipal UserDetailsImpl principal) {
					System.out.println(recipe);
				    // 파일 처리 (썸네일 이미지)
				    if (thumbnail != null && !thumbnail.isEmpty()) {
				        try {
				            String thumbnailFilename = fileStorageService.storeFile(thumbnail);
				            recipe.setThumbnailFilename(thumbnailFilename); // 저장된 파일명 설정
				            
				           
				           
				        } catch (Exception e) {
				            e.printStackTrace(); // 로그에 오류 출력
				            return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "파일 저장 중 오류 발생");
				        }
				    } else {
				        // 썸네일 파일이 없을 경우 기본값 설정
				        recipe.setThumbnailFilename("default_thumbnail.jpg"); // 기본 썸네일 설정
				    }
				    // 사용자 정보 (로그인한 사용자의 Client 정보)
				    Client client = principal.getClient();

			
			        // 게시물 등록 로직
			        postService.createRecipePost(recipe, client);
			        
			        return new ResponseDTO<>(HttpStatus.OK.value(), "게시물 등록 완료");
				}
				
				
			    // 레스토랑 게시물 등록 처리
			    @PostMapping("/post/restaurant")
			    @ResponseBody
			    public ResponseDTO<?> createRestaurantPost(
			            @ModelAttribute RestaurantPost restaurantPost, 
			            @RequestParam("thumbnail") MultipartFile thumbnail,
			            @AuthenticationPrincipal UserDetailsImpl principal) {
			        
			        // 썸네일 파일 처리 (파일 저장)
			        if (thumbnail != null && !thumbnail.isEmpty()) {
			            try {
			                String thumbnailFilename = fileStorageService.storeFile(thumbnail);
			                restaurantPost.setThumbnailFilename(thumbnailFilename); // 저장된 파일명 설정
			            } catch (Exception e) {
			                e.printStackTrace(); // 파일 저장 중 오류 발생 시 로그 출력
			                return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "파일 저장 중 오류 발생");
			            }
			        } else {
			            restaurantPost.setThumbnailFilename("default_thumbnail.jpg"); // 기본 썸네일 이미지 설정
			        }

			        // 로그인된 사용자 정보 (UserDetailsImpl에서 Client 객체 가져오기)
			        Client client = principal.getClient();
			        
			        // 레스토랑 게시물 저장
			        postService.createRestaurantPost(restaurantPost, client);
			        
			        // 성공 응답 반환
			        return new ResponseDTO<>(HttpStatus.OK.value(), "게시물 등록 완료");
			    }
}
