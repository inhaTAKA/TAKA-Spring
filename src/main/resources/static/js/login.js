function resetClassAndAttributes(form, classname, buttonText, actionType) {
    form.classList.remove("signup", "signin", "reset"); // 기존 클래스 제거
    form.classList.add(classname); // 새 클래스 추가
    document.getElementById("submit-btn").innerText = buttonText; // 버튼 텍스트 설정
    document.getElementById("actionType").value = actionType; // actionType 설정
}

// 'Sign Up' 버튼 클릭 시
document.getElementsByClassName("show-signup")[0].addEventListener("click", function() {
    let form = document.getElementsByClassName("form")[0];
    resetClassAndAttributes(form, "signup", "Sign Up", "signup");
});

// 'Sign In' 버튼 클릭 시
document.getElementsByClassName("show-signin")[0].addEventListener("click", function() {
    let form = document.getElementsByClassName("form")[0];
    resetClassAndAttributes(form, "signin", "Sign In", "signin");
});

// 'Reset Password' 버튼 클릭 시
document.getElementsByClassName("show-reset")[0].addEventListener("click", function() {
    let form = document.getElementsByClassName("form")[0];
    resetClassAndAttributes(form, "reset", "Reset password", "reset");
});