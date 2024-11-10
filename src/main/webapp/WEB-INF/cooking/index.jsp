<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./layout/basics.jsp" %>
<title>요리연구소</title>
<link rel="stylesheet" href="./css/style.css">
  
<%@ include file="./layout/header.jsp" %>
            <!-- --------------------------------------------- -->
            <!-- 메인컨텐츠 -->
            <section class="visual-content">

                <!-- 썸네일 이미지가 노출되는 게시판 -->
                <article class="new-recipe">
                    <h2>신규 레시피</h2>
                    <div class="visual">
                        <figure>
                            <a href="#"><img src="./img/1.jpg" alt="해당하는 게시물 썸네일"></a>
                            <span>카테고리</span>
                            <figcaption>
                                <p>작성자</p>
                                <span>제목테스트제목테스트제목테스트</span>
                            </figcaption>
                        </figure>
                        <figure>
                            <a href="#"><img src="./img/2.jpg" alt="해당하는 게시물 썸네일"></a>
                            <span>카테고리</span>
                            <figcaption>
                                <p>작성자</p>
                                <span>제목</span>
                            </figcaption>
                        </figure>
                        <figure>
                            <a href="#"><img src="./img/3.jpg" alt="해당하는 게시물 썸네일"></a>
                            <span>카테고리</span>
                            <figcaption>
                                <p>작성자</p>
                                <span>제목테스트제목테스트제목테스트제목테스트제목테스트제목테스트</span>
                            </figcaption>
                        </figure>
                        <figure>
                            <a href="#"><img src="./img/4.jpg" alt="해당하는 게시물 썸네일"></a>
                            <span>카테고리</span>
                            <figcaption>
                                <p>작성자</p>
                                <span>제목</span>
                            </figcaption>
                        </figure>
                        <figure>
                            <a href="#"><img src="./img/5.jpg" alt="해당하는 게시물 썸네일"></a>
                            <span>카테고리</span>
                            <figcaption>
                                <p>작성자</p>
                                <span>제목</span>
                            </figcaption>
                        </figure>
                        <figure>
                            <a href="#"><img src="./img/6.jpg" alt="해당하는 게시물 썸네일"></a>
                            <span>카테고리</span>
                            <figcaption>
                                <p>작성자</p>
                                <span>제목</span>
                            </figcaption>
                        </figure>
                    </div>
                </article>

                <!-- 작성자,제목만 보이는 게시판과 가게추천-->
                <article class="new-content">
                    <!-- 게시판리스트 -->
 <div class="favorite-recipe">
    <h3>인기 레시피</h3>
    <div class="favorite-list">
        <c:forEach var="post" items="${popularPosts}" varStatus="status">
            <ul>
                <li>
                    <!-- 인덱스에 따라 색상 지정 -->
                    <c:choose>
                        <c:when test="${status.index % 5 == 0}">
                            <i class="fa-solid fa-heart" style="color: #74C0FC;"></i>
                        </c:when>
                        <c:when test="${status.index % 5 == 1}">
                            <i class="fa-solid fa-heart" style="color: #FFD43B;"></i>
                        </c:when>
                        <c:when test="${status.index % 5 == 2}">
                            <i class="fa-solid fa-heart" style="color: #63E6BE;"></i>
                        </c:when>
                        <c:when test="${status.index % 5 == 3}">
                            <i class="fa-solid fa-heart" style="color: #e66586;"></i>
                        </c:when>
                        <c:otherwise>
                            <i class="fa-solid fa-heart" style="color: #B197FC;"></i>
                        </c:otherwise>
                    </c:choose>
                    <span>${post.recommendationCount}</span> <!-- 추천수 표시 -->
                </li>
                <li>
                    <small>${post.client.nickname}</small> <!-- 작성자 표시 -->
                    <strong>${post.title}</strong> <!-- 제목 표시 -->
                    <a href="/post/${post.id}">상세보기</a> <!-- 상세보기 링크 -->
                </li>
            </ul>
        </c:forEach>
    </div>
</div>

                    <!-- 이달의 맛집 -->
                    <div class="store">
                        <div class="store-title">
                            <h4>이달의 맛집1</h4>
                            <a href="#">+더보기</a>
                        </div>
                        <div class="store-list">
                            <div>
                                <a href="#"><img src="./img/store1.jpg" alt="이달의맛집 이미지"></a>
                                <p>
                                    <a href="#">상호명1</a>
                                    <span>지역</span>
                                </p>
                            </div>
                            <div>
                                <a href="#"><img src="./img/store2.jpg" alt="이달의맛집 이미지"></a>
                                <p>
                                    <a href="#">상호명</a>
                                    <span>지역</span>
                                </p>
                            </div>
                            <div>
                                <a href="#"><img src="./img/store3.jpg" alt="이달의맛집 이미지"></a>
                                <p>
                                    <a href="#">상호명</a>
                                    <span>지역</span>
                                </p>
                            </div>
                           
                        </div>
                    </div>
                </article>
            </section>
            

            <!-- --------------------------------------------- -->

<%@ include file="./layout/sideContent.jsp" %>

