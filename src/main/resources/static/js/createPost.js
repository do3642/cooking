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


/*----------------------------------*/


function submitForm() {
    const category = document.getElementById("category").value;
    const data = new FormData();

    if (category === "free") {
        // 자유게시판 데이터
        data.append("title", document.querySelector("#free-form input[name='title']").value);
        data.append("content", document.querySelector("#free-form textarea[name='content']").value);
    } else if (category === "recipe") {
        // 레시피 데이터
        data.append("thumbnail", document.querySelector("#recipe-form input[name='thumbnail']").files[0]);
        data.append("title", document.querySelector("#recipe-form input[name='title']").value);
        data.append("content", document.querySelector("#recipe-form textarea[name='content']").value);
        data.append("servings", document.querySelector("#recipe-form select[name='servings']").value);
        data.append("cookTime", document.querySelector("#recipe-form input[name='cookTime']").value);
        data.append("cuisine", document.querySelector("#recipe-form select[name='cuisine']").value);

        // 재료 데이터 추가
        const ingredientNames = document.querySelectorAll("#recipe-form input[name='ingredientName[]']");
        const ingredientAmounts = document.querySelectorAll("#recipe-form input[name='ingredientAmount[]']");
        ingredientNames.forEach((nameInput, index) => {
            data.append(`ingredients[${index}][name]`, nameInput.value);
            data.append(`ingredients[${index}][amount]`, ingredientAmounts[index].value);
        });

        // 조리 순서 데이터 추가
        const steps = document.querySelectorAll("#recipe-form input[name='steps[]']");
        steps.forEach((stepInput, index) => {
            data.append(`steps[${index}]`, stepInput.value);
        });
    } else if (category === "restaurant") {
        // 맛집 추천 데이터
        data.append("thumbnail", document.querySelector("#restaurant-form input[name='thumbnail']").files[0]);
        data.append("storeName", document.querySelector("#restaurant-form input[name='storeName']").value);
        data.append("region", document.querySelector("#restaurant-form input[name='region']").value);
        data.append("title", document.querySelector("#restaurant-form input[name='title']").value);
        data.append("content", document.querySelector("#restaurant-form textarea[name='content']").value);
    }

    // fetch 요청
    fetch(`/post/${category}`, {
        method: "POST",
        body: data,
    })
    .then(response => response.json())
    .then(data => {
        console.log("성공:", data);
		console.log("보낸 데이터:", data.data);
    })
    .catch(error => {
        console.error("오류:", error);
    });
}



