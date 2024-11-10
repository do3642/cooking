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
    let postData = {};

    // 카테고리별 데이터 준비
    if (category === "free") {
        // 자유게시판 데이터
        postData = {
            category: category,
            title: document.querySelector("input[name='title']").value,
            content: document.querySelector("textarea[name='content']").value
        };
    } else if (category === "recipe") {
        // 레시피 데이터
        postData = {
            category: category,
            title: document.querySelector("input[name='title']").value,
            content: document.querySelector("textarea[name='content']").value,
            thumbnail: document.querySelector("input[name='thumbnail']").files[0], // 파일 처리
            servings: document.querySelector("select[name='servings']").value,
            cookTime: document.querySelector("input[name='cookTime']").value,
            cuisine: document.querySelector("select[name='cuisine']").value,
            ingredients: [],
            steps: []
        };

        // 재료 추가
        const ingredients = document.querySelectorAll("input[name='ingredientName[]']");
        for (let i = 0; i < ingredients.length; i++) {
            postData.ingredients.push({
                name: ingredients[i].value,
                amount: document.querySelectorAll("input[name='ingredientAmount[]']")[i].value
            });
        }

        // 조리 순서 추가
        const steps = document.querySelectorAll("input[name='steps[]']");
        for (let i = 0; i < steps.length; i++) {
            postData.steps.push(steps[i].value);
        }

    } else if (category === "restaurant") {
        // 맛집 추천 데이터
        postData = {
            category: category,
            title: document.querySelector("input[name='title']").value,
            content: document.querySelector("textarea[name='content']").value,
            storeName: document.querySelector("input[name='storeName']").value,
            region: document.querySelector("input[name='region']").value,
            thumbnail: document.querySelector("input[name='thumbnail']").files[0] // 파일 처리
        };
    }

    // FormData 객체 생성
    const formData = new FormData();
    for (const key in postData) {
        if (postData[key] instanceof File) {
            formData.append(key, postData[key]); // 파일 추가
        } else if (Array.isArray(postData[key])) {
            postData[key].forEach((item, index) => {
                formData.append(`${key}[${index}]`, JSON.stringify(item)); // 배열 데이터 처리
            });
        } else {
            formData.append(key, postData[key]); // 일반 데이터 추가
        }
    }

    // AJAX 요청
    $.ajax({
        type: "POST",
        url: `/post/${category}`,
        data: formData,
        contentType: false,  // 파일 전송을 위한 설정
        processData: false,  // 데이터가 JSON이 아니므로 자동 변환 방지
        success: function(response) {
            alert('게시물 등록 성공!');
            console.log('응답 데이터:', response);
            if (response.status === 200) {
                location.href = "/";
            }
        },
        error: function(error) {
            console.error("게시물 등록 오류:", error);
            alert("게시물 등록에 실패했습니다.");
        }
    });
}

