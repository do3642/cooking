/*const regexId = /^\w{5,20}$/;
const regexPw = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,25}$/;
const regexNickname = /^[가-힣a-zA-Z0-9]{2,10}$/;
const regexTel = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
*/

const regexId = /^[가-힣a-zA-Z0-9]{2,15}$/; // 아이디: 2~15글자, 한글, 영어, 숫자
const regexPw = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+])[가-힣a-zA-Z0-9!@#$%^&*()_+]{4,20}$/; // 비밀번호: 4~20글자, 한글, 영어, 숫자, 특수문자
const regexNickname = /^[가-힣a-zA-Z0-9]{2,10}$/; // 닉네임: 2~10글자, 한글, 영어, 숫자
const regexEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // 이메일: 기본적인 이메일 형식
const regexTel = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/; // 전화번호: 010-1234-5678 또는 010-123-4567


let isIdCheck = false;
let isPwCheck = false;
let isNicknameCheck = false;
let isTelCheck = false;
let isEmailCheck = false;

const selectSpan = document.querySelectorAll("form span");

// 아이디 정규식
document.getElementById("username").addEventListener("input", () => {
  if (regexId.test(document.getElementById("username").value)) {
    selectSpan[0].innerText = "사용 가능한 아이디 입니다.";
    selectSpan[0].style.color = "green";
    isIdCheck = true;
  } else {
    selectSpan[0].innerText = "사용 불가능한 아이디 입니다.";
    selectSpan[0].style.color = "red";
    isIdCheck = false;
  }
});

// 비밀번호 정규식
document.getElementById("password").addEventListener("input", () => {
  if (regexPw.test(document.getElementById("password").value)) {
    selectSpan[1].innerText = "사용 가능한 비밀번호 입니다.";
    selectSpan[1].style.color = "green";
    isPwCheck = true;
  } else {
    selectSpan[1].innerText = "사용 불가능한 비밀번호 입니다.";
    selectSpan[1].style.color = "red";
    isPwCheck = false;
  }
});

// 닉네임 정규식
document.getElementById("nickname").addEventListener("input", () => {
  if (regexNickname.test(document.getElementById("nickname").value)) {
    selectSpan[2].innerText = "사용 가능한 닉네임 입니다.";
    selectSpan[2].style.color = "green";
    isNicknameCheck = true;
  } else {
    selectSpan[2].innerText = "사용 불가능한 닉네임 입니다.";
    selectSpan[2].style.color = "red";
    isNicknameCheck = false;
  }
});

// 이메일 정규식
document.getElementById("email").addEventListener("input", () => {
  if (regexEmail.test(document.getElementById("email").value)) {
    selectSpan[3].innerText = "사용 가능한 이메일 입니다.";
    selectSpan[3].style.color = "green";
    isEmailCheck = true;
  } else {
    selectSpan[3].innerText = "사용 불가능한 이메일 입니다.";
    selectSpan[3].style.color = "red";
    isEmailCheck = false;
  }
});
// 전화번호 정규식
/*document.getElementById("phone").addEventListener("input", () => {
  if (regexTel.test(document.getElementById("phone").value)) {
    selectSpan[4].innerText = "사용 가능한 전화번호 입니다.";
    selectSpan[4].style.color = "green";
    isTelCheck = true;
  } else {
    selectSpan[4].innerText = "사용 불가능한 전화번호 입니다.";
    selectSpan[4].style.color = "red";
    isTelCheck = false;
  }
});*/
// 전화번호 입력 시 자동으로 칸 넘어가게 만드는 js
document.getElementById("phone-part1").addEventListener("input", (e) => {
    if (e.target.value.length === 3) {
        document.getElementById("phone-part2").focus();
    }
});

document.getElementById("phone-part2").addEventListener("input", (e) => {
    if (e.target.value.length === 4) {
        document.getElementById("phone-part3").focus();
    }
});


// 폼 제출전 유효성 검사 안맞는데 전송 방지 | form태그에 옵션으로 호출되어있음
function validateForm() {
  // 전화번호 파트를 결합하여 전체 번호로 생성
  const phonePart1 = document.getElementById("phone-part1").value;
  const phonePart2 = document.getElementById("phone-part2").value;
  const phonePart3 = document.getElementById("phone-part3").value;
  const fullPhoneNumber = `${phonePart1}-${phonePart2}-${phonePart3}`;
  
  // 전화번호 유효성 검사
  if (regexTel.test(fullPhoneNumber)) {
    isTelCheck = true;
  } else {
    isTelCheck = false;
  }
/*  console.log(isTelCheck)*/

  // 유효성 검사 통과 여부 확인
  if (!isIdCheck || !isPwCheck || !isNicknameCheck || !isTelCheck || !isEmailCheck) {
    alert("입력한 정보가 유효하지 않습니다. 다시 확인해 주세요.");
    return false; // 폼 제출 차단
  }
  return true; // 폼 제출 허용
}
