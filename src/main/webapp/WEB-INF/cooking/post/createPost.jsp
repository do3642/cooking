<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/basics.jsp" %>
<title>요리연구소 게시물작성</title>
<link rel="stylesheet" href="/css/createPost.css">

<%@ include file="../layout/header.jsp" %>
<section class="visual-content">
    <h1>게시물 작성</h1>

    <label for="category">카테고리 선택:</label>
    <select id="category" name="category" onchange="updateForm()">
        <option value="free">자유게시판</option>
        <option value="recipe">레시피</option>
        <option value="restaurant">맛집추천</option>
    </select>

    <div id="post-form">
        <!-- 자유게시판 폼 -->
        <div id="free-form" class="post-category">
            <input type="text" name="title" placeholder="제목" required />
            <textarea name="content" placeholder="내용" required></textarea>
        </div>

        <!-- 레시피 폼 -->
        <div id="recipe-form" class="post-category" style="display:none;">
        	<label for="recipeThumbnail">썸네일</label>
            <input type="file" id="recipeThumbnail" name="thumbnail" />
            <input type="text" name="title" placeholder="제목" required />
              <textarea name="content" placeholder="내용" required></textarea>
            <select name="servings">
                <option>1인분</option>
                <option>2인분</option>
                <option>3인분</option>
                <option>4인분</option>
                <option>5인분 이상</option>
            </select>
            <input type="text" name="cookTime" placeholder="조리 시간" required />

            <label for="cuisine">한식, 중식, 일식, 양식, 기타:</label>
            <select id="cuisine" name="cuisine">
                <option value="korean">한식</option>
                <option value="chinese">중식</option>
                <option value="japanese">일식</option>
                <option value="western">양식</option>
                <option value="other">기타</option>
            </select>

            <div id="ingredients">
            	<div>
                	<input type="text" name="ingredientName[]" placeholder="재료 이름" />
                	<input type="text" name="ingredientAmount[]" placeholder="재료 용량" />
                </div>
                <button onclick="addIngredient()">재료 추가</button>
            </div>

            <div id="steps">
                <div>
                    <label class="step-label">조리 순서 1</label>
                    <input type="text" name="steps[]" placeholder="내용을 입력하세요" />
                </div>
                <button onclick="addStep()">조리 순서 추가</button>
            </div>
        </div>

        <!-- 맛집추천 폼 -->
        <div id="restaurant-form" class="post-category" style="display:none;">
        	<label for="recipeThumbnail">썸네일</label>
            <input type="file" id="restaurantThumbnail" name="thumbnail" />
            <input type="text" name="storeName" placeholder="상호명" required />
            <input type="text" name="region" placeholder="지역명" required />
            <input type="text" name="title" placeholder="제목" required />
            <textarea name="content" placeholder="내용" required></textarea>
        </div>
    </div>

    <!-- 제출 버튼 -->
    <button id="submit-btn"type="button" onclick="submitForm()">게시물 등록</button>
</section>


<script src="/js/createPost.js"></script>
<%@ include file="../layout/sideContent.jsp" %>
