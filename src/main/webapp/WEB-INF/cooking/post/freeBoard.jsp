<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/basics.jsp" %>
<title>요리연구소 틀</title>
<link rel="stylesheet" href="/css/freeBoard.css">
  
<%@ include file="../layout/header.jsp" %>
<section class="visual-content">

     <!-- 게시글 목록 -->
    <div class="board-posts">
        <!-- 게시글 항목 (게시글 1) -->
        <div class="post-item">
            <div class="title-info">
                <a href="detail.jsp" class="post-link"> <!-- 클릭 시 상세 페이지로 이동 -->
                    <span class="post-title">게시글 제목</span>
                    <span class="comment-count">댓글 10개</span>
                </a>
            </div>
            <div class="author-info">
                <span class="author">작성자</span>
                <span class="author-grade">[회원 등급]</span> <!-- 작성자 등급 -->
                <span class="post-time">20:10</span>
            </div>
        </div>
        
        <!-- 게시글 항목 (게시글 2) -->
        <div class="post-item">
            <div class="title-info">
                <a href="detail.jsp" class="post-link">
                    <span class="post-title">게시글 제목</span>
                    <span class="comment-count">댓글 5개</span>
                </a>
            </div>
            <div class="author-info">
                <span class="author">작성자</span>
                <span class="author-grade">[회원 등급]</span>
                <span class="post-time">18:30</span>
            </div>
        </div>
        
        <!-- 게시글 항목 추가... (게시글 3 ~ 15) -->
    </div>
    
    <!-- 페이지 이동 버튼 -->
    <div class="pagination">
        <button class="prev-page">이전</button>
        <span class="page-number">1</span>
        <button class="next-page">다음</button>
    </div>

</section>

<%@ include file="../layout/sideContent.jsp" %>
