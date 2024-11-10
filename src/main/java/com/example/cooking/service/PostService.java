package com.example.cooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cooking.domain.Client;
import com.example.cooking.posts.FreeBoardPost;
import com.example.cooking.posts.RecipePost;
import com.example.cooking.posts.RestaurantPost;
import com.example.cooking.repository.FreePostRepository;
import com.example.cooking.repository.RecipePostRepository;
import com.example.cooking.repository.RestaurantPostRepository;
import com.example.cooking.repository.UserRepository;

@Service
public class PostService {
// 레포지토리 의존성주입
	@Autowired
	private FreePostRepository freePostRepository;
	
	@Autowired
	private RecipePostRepository recipePostRepository;
	
	@Autowired
	private RestaurantPostRepository restaurantPostRepository;

	@Autowired
	public UserRepository userRepository;
	
// 자유 게시물 저장
	
	public FreeBoardPost createFreePost(FreeBoardPost free, Client client) {
		
		free.setClient(client);
		
		return freePostRepository.save(free);
		
	}
// 레시피 게시물 저장
	public RecipePost createRecipePost(RecipePost recipe, Client client) {
		
		recipe.setClient(client);
		
		return recipePostRepository.save(recipe);
		
	}
	
    // 레스토랑 게시물 저장
    public RestaurantPost createRestaurantPost(RestaurantPost restaurantPost, Client client) {
    	
        restaurantPost.setClient(client);
        
        return restaurantPostRepository.save(restaurantPost);
    }
    
    
	// 게시물DB 리스트 형태로 전체 리턴
	@Transactional(readOnly = true)
	public Page<FreeBoardPost> getPostList(Pageable pageable){
		
			return freePostRepository.findAll(pageable);
		}
	
	
}
