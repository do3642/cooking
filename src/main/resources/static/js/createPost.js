let stepCount = 1; // 조리 순서 카운터 초기화 

function updateForm() {
    const category = document.getElementById("category").value;
    const forms = document.querySelectorAll(".post-category");
    forms.forEach(form => form.style.display = "none"); // 모든 폼 숨기기

    if (category === "free") {
        forms[0].style.display = "block"; // 자유게시판 폼 보여주기
    } else if (category === "recipe") {
        forms[1].style.display = "block"; // 레시피 폼 보여주기
    } else if (category === "restaurant") {
        forms[2].style.display = "block"; // 맛집추천 폼 보여주기
    }
}


function addIngredient() {
    const ingredientsDiv = document.getElementById("ingredients");
    const addButton = ingredientsDiv.querySelector("button"); // 버튼 요소를 찾음
    const newIngredient = document.createElement("div");
    newIngredient.innerHTML = `<input type="text" name="ingredientName[]" placeholder="재료 이름" />
                               <input type="text" name="ingredientAmount[]" placeholder="재료 용량" />`;
    ingredientsDiv.insertBefore(newIngredient, addButton); // 버튼 위에 새로운 재료 필드 추가
}

function addStep() {
    const stepsDiv = document.getElementById("steps");
    const addButton = stepsDiv.querySelector("button"); // 버튼 요소를 찾음
    stepCount++; // 카운터 증가
    const newStep = document.createElement("div");
    newStep.innerHTML = `<label class="step-label">조리 순서 ${stepCount}</label>
                         <input type="text" name="steps[]" placeholder="내용을 입력하세요" />`;
    stepsDiv.insertBefore(newStep, addButton); // 버튼 위에 새로운 조리 순서 필드 추가
}

function submitForm() {
    // Form submission logic goes here
}
