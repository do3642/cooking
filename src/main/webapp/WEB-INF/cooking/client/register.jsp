<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/basics.jsp" %>
<title>요리연구소 회원가입</title>
<link rel="stylesheet" href="/css/register.css">
  
<%@ include file="../layout/header.jsp" %>
<section class="visual-content">
    <h2>회원가입</h2>
    <form action="/register" method="post" class="registration-form" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="username">아이디</label>
            <input type="text" id="username" name="username" required class="form-input" autocomplete="username">
            <span></span>
        </div>
        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" required class="form-input" autocomplete="current-password">
            <span></span>
        </div>
        <div class="form-group">
            <label for="nickname">닉네임</label>
            <input type="text" id="nickname" name="nickname" required class="form-input">
            <span></span>
        </div>
        <div class="form-group">
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" required class="form-input">
            <span></span>
        </div>
		<div class="form-group">
		    <label for="phone-part1">핸드폰 번호</label>
		    <div class="phone-input">
		        <input type="text" id="phone-part1" name="phone-part1" maxlength="3" required class="form-input" > -
		        <input type="text" id="phone-part2" name="phone-part2" maxlength="4" required class="form-input" > -
		        <input type="text" id="phone-part3" name="phone-part3" maxlength="4" required class="form-input" >
		    </div>
		    <span></span>
		</div>
         <div class="terms-scroll">
            <div class="terms-content">
                <p><strong>회원가입 약관</strong></p>
                <p>이용자는 본 약관에 동의함으로써 회원가입을 신청하며, 사이트의 서비스를 이용할 수 있습니다.</p>
                <p>이용자는 등록 시 제공하는 모든 정보가 정확하며, 이를 유지할 의무가 있습니다.</p>
                
                <p><strong>서비스 이용 약관</strong></p>
                <p>사이트 이용자는 제공된 서비스를 적법한 범위 내에서만 이용해야 하며, 불법적인 행위는 금지됩니다.</p>
                <p>회원은 사이트 이용 시 타인의 권리를 침해하지 않도록 주의해야 합니다.</p>

                <p><strong>개인정보 처리 방침</strong></p>
                <p>사이트는 이용자의 개인정보를 보호하기 위해 최선을 다하며, 관련 법규를 준수합니다.</p>
                <p>회원가입 시 수집된 개인정보는 서비스 제공 목적으로만 사용되며, 제3자에게 제공되지 않습니다.</p>
            </div>
        </div>
        
        <div class="form-group terms-agreement">
            <label for="terms">
                <input type="checkbox" id="terms" name="terms" required>
                약관에 동의합니다.
            </label>
        </div>

        <button type="submit" class="submit-button insert-btn" >회원가입</button>
    </form>

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
<script src="/js/register.js"></script>
<%@ include file="../layout/sideContent.jsp" %>