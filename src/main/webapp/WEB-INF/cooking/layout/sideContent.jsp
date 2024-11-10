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
                <div class="welcome-message">${user.client.nickname}회원님, 반갑습니다!</div>
                <div class="user-grade">
                    <c:choose>
                        <c:when test="${user.postCount > 30}">
                            <div>회원등급 : 골드</div>
                        </c:when>
                        <c:when test="${user.postCount > 20}">
                            <div>회원등급 : 실버</div>
                        </c:when>
                        <c:when test="${user.postCount > 10}">
                            <div>회원등급 : 브론즈</div>
                        </c:when>
                        <c:otherwise>
                            <div>회원등급 : 일반사용자</div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="button-group">
                    <a href="/auth/logout" class="btn" onclick="event.preventDefault(); document.getElementById('logout-form').submit();">로그아웃</a>
                    <a href="/auth/userinfo" class="btn">내 정보 관리</a>
                    <a href="/auth/myposts" class="btn">내 게시물 관리</a>
                    <a href="/posts/create" class="btn">게시물 작성</a>
                    <!-- post요청을 위한 폼태그 -->
                    <form id="logout-form" action="/auth/logout" method="POST" style="display: none;">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
            </c:if>    
        </article>

        <article class="premium-store <c:if test="${user != null }">logged-in</c:if>">
            <h5>프리미엄 가게</h5>
            <div class="premium-list">
                <div class="card">
                    <div class="premium-title">
                        <span>맛있는 국수집</span>
                        <small>서울</small>
                    </div>
                    <figure>
                        <a href="#"><img src="/img/premium-store1.jpg" alt="프리미엄가게썸네일"></a>
                        <figcaption>정통 국수의 맛을 그대로 재현한 '맛있는 국수집'에서는 매일 신선한 재료로 만든 국수를 즐길 수 있습니다. 부드럽고 깊은 국물 맛을 경험해보세요!</figcaption>
                    </figure>
                </div>
                <div class="card">
                    <div class="premium-title">
                        <span>서울 김밥의 집</span>
                        <small>서울</small>
                    </div>
                    <figure>
                        <a href="#"><img src="/img/premium-store2.jpg" alt="프리미엄가게썸네일"></a>
                        <figcaption>매일 아침 신선한 재료로 만든 김밥과 떡볶이를 제공합니다. 언제든지 간편하게 맛있는 한 끼를 즐기세요. '서울 김밥의 집'에서 건강하고 맛있는 음식을 만나보세요!</figcaption>
                    </figure>
                </div>
                <div class="card">
                    <div class="premium-title">
                        <span>쌀국수의 향연</span>
                        <small>부산</small>
                    </div>
                    <figure>
                        <a href="#"><img src="/img/premium-store3.jpg" alt="프리미엄가게썸네일"></a>
                        <figcaption>베트남 전통 쌀국수를 맛볼 수 있는 '쌀국수의 향연'은 신선한 재료로 만든 국물과 면이 일품인 곳입니다. 다양한 종류의 쌀국수를 만나보세요!</figcaption>
                    </figure>
                </div>
                <div class="card">
                    <div class="premium-title">
                        <span>전통 한정식</span>
                        <small>경기도</small>
                    </div>
                    <figure>
                        <a href="#"><img src="/img/premium-store1.jpg" alt="프리미엄가게썸네일"></a>
                        <figcaption>전통 한정식을 제공하는 '전통 한정식'에서는 다양한 반찬과 함께 푸짐한 한상을 즐길 수 있습니다. 정갈하고 맛있는 한식을 경험해보세요.</figcaption>
                    </figure>
                </div>
                <div class="card">
                    <div class="premium-title">
                        <span>해물 맛집</span>
                        <small>인천</small>
                    </div>
                    <figure>
                        <a href="#"><img src="/img/premium-store2.jpg" alt="프리미엄가게썸네일"></a>
                        <figcaption>싱싱한 해산물과 함께하는 해물 요리를 제공하는 '해물 맛집'은 고유의 맛을 자랑하는 요리로 입맛을 사로잡습니다. 인천에서 해물 요리를 즐기세요.</figcaption>
                    </figure>
                </div>
                <div class="card">
                    <div class="premium-title">
                        <span>호주식 스테이크</span>
                        <small>서울</small>
                    </div>
                    <figure>
                        <a href="#"><img src="/img/premium-store3.jpg" alt="프리미엄가게썸네일"></a>
                        <figcaption>호주식 스테이크를 전문으로 하는 '호주식 스테이크'에서는 질 좋은 고기와 완벽한 조리법으로 최고의 스테이크를 제공합니다. 이태원에서 특별한 스테이크를 즐기세요.</figcaption>
                    </figure>
                </div>
                <div class="card">
                    <div class="premium-title">
                        <span>커피와 디저트</span>
                        <small>서울</small>
                    </div>
                    <figure>
                        <a href="#"><img src="/img/premium-store1.jpg" alt="프리미엄가게썸네일"></a>
                        <figcaption>정성껏 준비한 커피와 디저트를 제공하는 '커피와 디저트'는 하루의 여유를 즐기기에 안성맞춤인 카페입니다. 다양한 커피와 디저트를 즐기세요.</figcaption>
                    </figure>
                </div>
            </div>
        </article>
    </div>
</section>
            
        </main>

    </div>

      <script src="/js/script.js"></script>
      <script src="/js/navigation.js"></script>
      <script src="https://kit.fontawesome.com/c0680c70ea.js" crossorigin="anonymous"></script>
</body>
</html>