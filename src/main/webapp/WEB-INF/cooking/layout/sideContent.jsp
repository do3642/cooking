<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <!-- 사이드 컨텐츠(로그인관련 포함) -->
            <section class="side-content">
                <div class="side-content-box">
                    <article class="account">
                    	<c:if test="${user == null }">
	                        <a href="/auth/login">로그인</a>
	                        <a href="#"><img src="/img/kakao_login_medium_narrow.png" alt="카카오 로그인"></a>
	                        <a href="#"><img src="/img/btn_google_signin_dark_normal_web.png" alt="구글 로그인"></a>
	                        <p>
	                            <a href="/auth/register">회원가입 |</a>
	                            <a href="#">아이디 찾기 |</a>
	                            <a href="#">비밀번호 찾기</a>
	                        </p>
                       </c:if>
                       <c:if test="${user != null }">
   							 <!-- 로그인 상태에서만 표시할 내용 -->
   							 <div class="welcome-message">${user.username}회원님, 반갑습니다!</div>
   							 <div class="user-grade">
						        <c:choose>
						            <c:when test="${user.postCount > 30}">
						                <div>당신의 등급은: 골드</div>
						            </c:when>
						            <c:when test="${user.postCount > 20}">
						                <div>당신의 등급은: 실버</div>
						            </c:when>
						            <c:when test="${user.postCount > 10}">
						                <div>당신의 등급은: 브론즈</div>
						            </c:when>
						            <c:otherwise>
						                <div>당신의 등급은: 일반 사용자</div>
						            </c:otherwise>
						        </c:choose>
						    </div>
				      		 <div class="button-group">
					            <a href="/auth/logout" class="btn" onclick="event.preventDefault(); document.getElementById('logout-form').submit();">로그아웃</a>
					            <a href="/auth/userinfo" class="btn">내 정보 관리</a>
					            <a href="/auth/myposts" class="btn">내 게시물 관리</a>
					            
					            <!-- post요청을 위한 폼태그 -->
					            <form id="logout-form" action="/auth/logout" method="POST" style="display: none;">
   									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								</form>
					        </div>
						</c:if>	
                    </article>

                    <article class="premium-store">
                        <h5>프리미엄 가게</h5>
                        <div class="premium-list">
                            <div class="card">
                                <div class="premium-title">
                                    <span>상호명</span>
                                    <small>지역명</small>
                                </div>
                                <figure>
                                    <a href="#"><img src="/img/premium-store1.jpg" alt="프리미엄가게썸네일"></a>
                                    <figcaption>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Veritatis eius ab voluptatibus porro at, libero ea placeat dicta fugiat reiciendis, quaerat ipsa minima nesciunt esse odit eos similique veniam quidem.</figcaption>
                                </figure>
                            </div>
                            <div class="card">
                                <div class="premium-title">
                                    <span>상호명</span>
                                    <small>지역명</small>
                                </div>
                                <figure>
                                    <a href="#"><img src="/img/premium-store2.jpg" alt="프리미엄가게썸네일"></a>
                                    <figcaption>가게설명가게설명가게설명가게설명가게설명가게설명가게설명</figcaption>
                                </figure>
                            </div>
                            <div class="card">
                                <div class="premium-title">
                                    <span>상호명</span>
                                    <small>지역명</small>
                                </div>
                                <figure>
                                    <a href="#"><img src="/img/premium-store3.jpg" alt="프리미엄가게썸네일"></a>
                                    <figcaption>가게설명</figcaption>
                                </figure>
                            </div>
                            <div class="card">
                                <div class="premium-title">
                                    <span>상호명</span>
                                    <small>지역명</small>
                                </div>
                                <figure>
                                    <a href="#"><img src="/img/premium-store1.jpg" alt="프리미엄가게썸네일"></a>
                                    <figcaption>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Veritatis eius ab voluptatibus porro at, libero ea placeat dicta fugiat reiciendis, quaerat ipsa minima nesciunt esse odit eos similique veniam quidem.</figcaption>
                                </figure>
                            </div>
                            <div class="card">
                                <div class="premium-title">
                                    <span>상호명</span>
                                    <small>지역명</small>
                                </div>
                                <figure>
                                    <a href="#"><img src="/img/premium-store2.jpg" alt="프리미엄가게썸네일"></a>
                                    <figcaption>가게설명가게설명가게설명가게설명가게설명가게설명가게설명</figcaption>
                                </figure>
                            </div>
                            <div class="card">
                                <div class="premium-title">
                                    <span>상호명</span>
                                    <small>지역명</small>
                                </div>
                                <figure>
                                    <a href="#"><img src="/img/premium-store3.jpg" alt="프리미엄가게썸네일"></a>
                                    <figcaption>가게설명</figcaption>
                                </figure>
                            </div>
                            <div class="card">
                                <div class="premium-title">
                                    <span>상호명</span>
                                    <small>지역명</small>
                                </div>
                                <figure>
                                    <a href="#"><img src="/img/premium-store1.jpg" alt="프리미엄가게썸네일"></a>
                                    <figcaption>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Veritatis eius ab voluptatibus porro at, libero ea placeat dicta fugiat reiciendis, quaerat ipsa minima nesciunt esse odit eos similique veniam quidem.</figcaption>
                                </figure>
                            </div>
                            <div class="card">
                                <div class="premium-title">
                                    <span>상호명</span>
                                    <small>지역명</small>
                                </div>
                                <figure>
                                    <a href="#"><img src="/img/premium-store2.jpg" alt="프리미엄가게썸네일"></a>
                                    <figcaption>가게설명가게설명가게설명가게설명가게설명가게설명가게설명</figcaption>
                                </figure>
                            </div>
                            <div class="card">
                                <div class="premium-title">
                                    <span>상호명</span>
                                    <small>지역명</small>
                                </div>
                                <figure>
                                    <a href="#"><img src="/img/premium-store3.jpg" alt="프리미엄가게썸네일"></a>
                                    <figcaption>가게설명</figcaption>
                                </figure>
                            </div>
                            <div class="card">
                                <div class="premium-title">
                                    <span>상호명</span>
                                    <small>지역명</small>
                                </div>
                                <figure>
                                    <a href="#"><img src="/img/premium-store1.jpg" alt="프리미엄가게썸네일"></a>
                                    <figcaption>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Veritatis eius ab voluptatibus porro at, libero ea placeat dicta fugiat reiciendis, quaerat ipsa minima nesciunt esse odit eos similique veniam quidem.</figcaption>
                                </figure>
                            </div>
                        </div>
                    </article>
                </div>
            </section>
            
        </main>

    </div>

      <script src="/js/script.js"></script>
      <script src="https://kit.fontawesome.com/c0680c70ea.js" crossorigin="anonymous"></script>
</body>
</html>