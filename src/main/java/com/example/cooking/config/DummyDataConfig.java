package com.example.cooking.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.cooking.posts.FreeBoardPost;
import com.example.cooking.posts.RecipePost;
import com.example.cooking.service.PostService;
import com.example.cooking.service.UserService;
import com.example.cooking.domain.Client;
import com.example.cooking.posts.CuisineType;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.ArrayList;

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
                    Client testClient = new Client(0, "admin", "1234", "관리자", "11234@naver.com", "010-1234-5678", null, 0, null);
                    userService.register(testClient);
                } else {
                    System.out.println("관리자 계정은 이미 존재합니다.");
                }

                // 게시글이 100개 미만일 경우에만 더미 게시글 추가
                if (postService.getFreeBoardPostCount() < 100) {
                    Client client = userService.findByNickname("관리자"); // 사용자 찾기
                    if (client != null) {
                        // FreeBoardPost 더미 데이터 추가
                        IntStream.rangeClosed(1, 100).forEach(i -> {
                            FreeBoardPost post = new FreeBoardPost();
                            post.setTitle("더미 제목 " + i);
                            post.setContent("더미 내용 " + i);
                            post.setViewCount((int) (Math.random() * 2000)); // 조회수 임의 설정
                            post.setRecommendationCount((int) (Math.random() * 1500)); // 추천수 랜덤 설정
                            post.setCategory("free"); // category 값 설정
                            postService.createFreePost(post, client);
                        });
                        System.out.println("FreeBoardPost 더미 데이터 추가 완료!");
                    }
                } else {
                    System.out.println("FreeBoardPost 게시글이 이미 100개 이상 존재합니다.");
                }

                // RecipePost 더미 데이터 추가
                if (postService.getRecipePostCount() < 50) { // 50개 미만일 경우에만 추가
                    Client client = userService.findByNickname("관리자"); // 사용자 찾기
                    if (client != null) {
                        // RecipePost 더미 데이터 추가
                        IntStream.rangeClosed(1, 50).forEach(i -> {
                            RecipePost recipePost = new RecipePost();
                            recipePost.setTitle("레시피 제목 " + i);
                            recipePost.setContent("레시피 내용 " + i);
                            recipePost.setViewCount((int) (Math.random() * 2000)); // 조회수 임의 설정
                            recipePost.setRecommendationCount((int) (Math.random() * 1500)); // 추천수 랜덤 설정
                            recipePost.setCategory("recipe"); // 카테고리
                            recipePost.setCookTime("30분"); // 조리 시간
                            recipePost.setServings("2인분"); // 인분
                            recipePost.setCuisineType(randomCuisineType()); // 랜덤으로 CuisineType 설정
                            recipePost.setThumbnailFilename(i % 7 + 1 + ".jpg");
                            recipePost.setIngredients(generateIngredients()); // 재료 목록 생성
                            recipePost.setSteps(generateSteps()); // 조리 순서 생성
                            postService.createRecipePost(recipePost, client);
                        });
                        System.out.println("RecipePost 더미 데이터 추가 완료!");
                    }
                } else {
                    System.out.println("RecipePost가 이미 50개 이상 존재합니다.");
                }

            } catch (Exception e) {
                System.err.println("더미 데이터 생성 중 오류 발생: " + e.getMessage());
                e.printStackTrace();
            }
        };
    }

    // 더미 재료 목록 생성
    private List<String> generateIngredients() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("재료1");
        ingredients.add("재료2");
        ingredients.add("재료3");
        return ingredients;
    }

    // 더미 조리 순서 생성
    private List<String> generateSteps() {
        List<String> steps = new ArrayList<>();
        steps.add("1단계: 재료 준비");
        steps.add("2단계: 조리 시작");
        steps.add("3단계: 완성");
        return steps;
    }
    // 랜덤한 CuisineType 값을 반환하는 메서드
    private CuisineType randomCuisineType() {
        Random random = new Random();
        CuisineType[] cuisineTypes = CuisineType.values(); // CuisineType의 모든 값을 배열로 가져옴
        return cuisineTypes[random.nextInt(cuisineTypes.length)]; // 랜덤으로 하나 선택
    }
}
