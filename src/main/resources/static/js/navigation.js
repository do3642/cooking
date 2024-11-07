document.addEventListener("DOMContentLoaded", function () {
    const path = window.location.pathname;
    
    document.querySelectorAll('nav a').forEach((link) => {
        const page = link.getAttribute('data-page');
        
        // 홈 페이지 처리: path가 "/"일 때만 "홈"에 active 클래스 추가
        if ((path === "/" && page === "home") || path.includes(page)) {
            link.parentElement.classList.add('active');
        } else {
            link.parentElement.classList.remove('active');
        }
    });
});
