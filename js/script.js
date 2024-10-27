const navItems = document.querySelectorAll(".nav-item");

navItems.forEach((navItem, i) => {
  navItem.addEventListener("click", () => {
    navItems.forEach((item, j) => {
      item.className = "nav-item";
    });
    navItem.className = "nav-item active";
  });
});







let index = 0;
const list = document.querySelector('.premium-list');
const cards = document.querySelectorAll('.premium-list .card');
const totalCards = cards.length;

function scrollCards() {
    // 카드의 높이 계산
    const cardHeight = cards[0].offsetHeight;
    
    // 변환할 위치 계산
    index = (index + 1) % totalCards; // 카드가 마지막에 도달하면 처음으로 돌아옴
    const translateY = -(cardHeight * index);

    // 카드 리스트 스크롤
    cards.forEach(card => {
        card.style.transform = `translateY(${translateY}px)`;
    });
}

// 3초마다 자동 스크롤
setInterval(scrollCards, 3000);