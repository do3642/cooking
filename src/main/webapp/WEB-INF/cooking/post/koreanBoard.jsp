<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/basics.jsp" %>
<title>요리연구소 틀</title>
<link rel="stylesheet" href="/css/koreanBoard.css">
  
<%@ include file="../layout/header.jsp" %>
<section class="visual-content">

    <!-- 게시글 항목들 -->
    <c:if test="${empty postList}">
        <h1>등록된 게시물이 없습니다.</h1>	 
    </c:if>

    <!-- 한식 메뉴 목록 -->
    <div class="menu-list">
      <c:forEach var ="post" items="${postList.content}">
        <a href="/board/koreanBoard/${post.id}" class="menu-box">
            <div class="thumbnail">
                <img src="../img/${post.thumbnailFilename}" alt="메뉴목록" />
            </div>
            <div class="menu-info">
                <h3 class="menu-title">${post.title }</h3>
                <p class="menu-description">${post.content }</p>
                <div class="author-info">
                    <span class="author-nickname">${post.client.nickname }</span>
                    <span class="author-grade">
                      <c:out value="${fn:trim(post.client.postCount > 30 ? '골드' : post.client.postCount > 20 ? '실버' : post.client.postCount > 10 ? '브론즈' : '일반사용자')}" />
                    </span>
                </div>
                <div class="interaction-info">
                    <span class="recommend-count">추천수 ${post.recommendationCount}</span>
                    <span class="comment-count">댓글 ${fn:length(post.comments)}개</span>
                </div>
            </div>
        </a>
      </c:forEach>
    </div>

    <!-- 페이지 이동 버튼 (그리드 밖에 배치) -->
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

