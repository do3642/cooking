<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/basics.jsp" %>
<title>게시글 상세</title>
<link rel="stylesheet" href="/css/Free.css">

<%@ include file="../../layout/header.jsp" %>

<section class="visual-content">
<div class="post-title">${post.title}</div>

<!-- 좌측: 카테고리 + 작성자/등급 -->
<div class="post-meta">
    <div class="post-meta-left">
        <div class="post-category">${post.category}</div>
        <div class="post-author">${post.client.nickname}</div>
        <div class="author-grade">[<c:out value="${fn:trim(post.client.postCount > 30 ? '골드' : post.client.postCount > 20 ? '실버' : post.client.postCount > 10 ? '브론즈' : '일반사용자')}" />]</div>
    </div>

    <!-- 우측: 추천수 | 조회수 | 댓글수 -->
    <div class="post-meta-right">
        <div class="recommendation">추천 ${post.recommendationCount}</div>
        <div class="view-count">조회수 ${post.viewCount}</div>
        <div class="comment-count">댓글수 ${post.comments.size()}</div>
    </div>
</div>

<!-- 작성일 -->
<div class="post-date">${post.createDate}</div>

<!-- 게시글 내용 -->
<div class="post-content">${post.content}</div>

<!-- 추천 버튼 및 추천 수 -->
<div class="recommendation-center">
    <button class="recommend-button">추천</button>
    <div class="recommend-count">${post.recommendationCount}</div>
</div>

<!-- 댓글 작성 -->
<div class="comments-section">
    <!-- 댓글 작성 폼 -->
    <form class="comment-form">
        <!-- 로그인한 사용자의 닉네임 표시 -->
        <div class="current-user">${user.nickname}</div>
        <textarea placeholder="댓글을 작성하세요..." rows="4"></textarea>
        <button class="submit-comment-button">댓글 작성</button>
    </form>

    <!-- 댓글 리스트 -->
    <div class="comment-list">
        <!-- 댓글 항목 반복 -->
        <div class="comment-item">
            <div class="comment-author">작성자</div>
            <div class="comment-content">댓글 내용</div>
            <div class="comment-meta">
                <span class="comment-time">2024-11-10</span>
            </div>
        </div>
    </div>
</div>

</section>

<%@ include file="../../layout/sideContent.jsp" %>
