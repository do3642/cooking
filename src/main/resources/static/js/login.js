


// 로그인페이지 접속 시 nav의 active 제거
window.addEventListener('DOMContentLoaded', () => {
    const navItems = document.querySelectorAll('nav > ul > li');
    
    // 모든 li 요소에서 클래스 제거
    navItems.forEach(item => item.classList.remove('active'));
    
});