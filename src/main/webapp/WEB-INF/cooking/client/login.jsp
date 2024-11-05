<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/basics.jsp" %>
<title>요리연구소 로그인</title>
<link rel="stylesheet" href="/css/login.css">
  
<%@ include file="../layout/header.jsp" %>

<section class="visual-content">

  <div class="login-container">
        <h2>로그인</h2>
        <form action="/login" method="post">
         <input type="hidden" name="_csrf" th:value="${_csrf.token}">
            <div class="form-group">
                <label for="username">아이디</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="login-btn">로그인</button>
        </form>
        <div class="extra-links">
            <a href="/auth/register">회원가입</a>
            <a href="/find-username">아이디 찾기</a>
            <a href="/forgot-password">비밀번호 찾기</a>
        </div>
    </div>
    
    <!-- -------------- 하단영역 ----------------->
     <footer class="copyright">
        <p>&copy; 2024 요리연구소. All rights reserved.</p>
        <p>최고의 요리 레시피를 공유하세요!</p>
      	<div class="social-media">
		    <a href="https://facebook.com" target="_blank"><i class="fab fa-facebook-f"></i></a>
		    <a href="https://twitter.com" target="_blank"><i class="fab fa-twitter"></i></a>
		    <a href="https://instagram.com" target="_blank"><i class="fab fa-instagram"></i></a>
		    <a href="https://linkedin.com" target="_blank"><i class="fab fa-linkedin-in"></i></a>
		</div>	

        <div class="footer-links">
            <a href="/terms">이용약관</a> |
            <a href="/privacy">개인정보처리방침</a>
        </div>
    </footer>
</section>

<script src="/js/login.js"></script>
<%@ include file="../layout/sideContent.jsp" %>


