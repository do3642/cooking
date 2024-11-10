<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/basics.jsp" %>
<title>요리연구소 틀</title>
<link rel="stylesheet" href="/css/freeBoard.css">
  
<%@ include file="../layout/header.jsp" %>
<section class="visual-content">

     <!-- 게시글 목록 -->
    <div class="board-posts">
        
        <!-- 게시글 항목들 -->
        <c:if test="${empty postList}">
            <h1>등록된 게시물이 없습니다.</h1>	 
        </c:if>
        
        <c:forEach var ="post" items="${postList.content}">
            <div class="post-item">
                <div class="title-info">
                    <a href="/board/freeBoard/${post.id}" class="post-link">
                        <span class="post-title">${post.title }</span>
                        <span class="comment-count">댓글 ${fn:length(post.comments)}개</span>
                    </a>
                </div>
                <div class="author-info">
                    <span class="author">${post.client.nickname }</span>
                    <span class="author-grade">
                        [<c:out value="${fn:trim(post.client.postCount > 30 ? '골드' : post.client.postCount > 20 ? '실버' : post.client.postCount > 10 ? '브론즈' : '일반사용자')}" />]
                    </span>
                    <span class="post-time">
                        <fmt:formatDate value="${post.createDate}" pattern="yyyy-MM-dd HH:mm" />
                    </span>
                </div>
            </div>
        </c:forEach>
  
			<!-- 페이지 이동 버튼 -->
			<div class="pagination">
			    <!-- 이전 그룹 버튼 -->
			    <c:if test="${pageDTO.prev}">
			        <a class="prev-group" href="?page=${pageDTO.startPage - 2}">◀</a>
			    </c:if>
			
			    <!-- 페이지 번호 버튼들 -->
			    <c:forEach begin="${pageDTO.startPage}" end="${pageDTO.endPage}" var="pageNum">
			        <c:if test="${pageNum <= pageDTO.totalPages}">
			            <a href="?page=${pageNum - 1}" class="page-number ${pageNum == pageDTO.page.number + 1 ? 'active' : ''}">
			                ${pageNum}
			            </a>
			        </c:if>
			    </c:forEach>
			
			    <!-- 다음 그룹 버튼 -->
			    <c:if test="${pageDTO.next}">
			        <a class="next-group" href="?page=${pageDTO.endPage}">▶</a>
			    </c:if>
			</div>
</section>

<%@ include file="../layout/sideContent.jsp" %>
