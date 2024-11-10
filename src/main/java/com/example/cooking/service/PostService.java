package com.example.cooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cooking.domain.Client;
import com.example.cooking.posts.FreeBoardPost;
import com.example.cooking.posts.RecipePost;
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
	
//	게시물 저장
	
	public FreeBoardPost createFreePost(FreeBoardPost free, Client client) {
		
		free.setClient(client);
		
		return freePostRepository.save(free);
		
	}
	
	public RecipePost createRecipePost(RecipePost recipe, Client client) {
		
		recipe.setClient(client);
		
		return recipePostRepository.save(recipe);
		
	}
}
