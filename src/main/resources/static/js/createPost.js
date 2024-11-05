let stepCount = 1; // 조리 순서 카운터 초기화

function updateForm() {
    const category = document.getElementById("category").value;
    const forms = document.querySelectorAll(".post-category");
    forms.forEach(form => form.style.display = "none"); // 모든 폼 숨기기

    if (category === "free") {
        document.getElementById("free-form").style.display = "block"; // 자유게시판 폼 보여주기
    } else if (category === "recipe") {
        document.getElementById("recipe-form").style.display = "block"; // 레시피 폼 보여주기
    } else if (category === "restaurant") {
        document.getElementById("restaurant-form").style.display = "block"; // 맛집추천 폼 보여주기
    }
}

function addIngredient() {
    const ingredientsDiv = document.getElementById("ingredients");
    const newIngredient = document.createElement("div");
    newIngredient.innerHTML = `<input type="text" placeholder="재료 이름" />
                                <input type="text" placeholder="재료 용량" />`;
    ingredientsDiv.appendChild(newIngredient);
}

function addStep() {
    const stepsDiv = document.getElementById("steps");
    stepCount++; // 카운터 증가
    const newStep = document.createElement("div");
    newStep.innerHTML = `<label>조리 순서 ${stepCount}</label>
                         <input type="text" placeholder="내용을 입력하세요" />`;
    stepsDiv.appendChild(newStep);
}