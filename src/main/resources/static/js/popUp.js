// "내 차에 태우기" 카드 클릭 시 팝업 열기
document.getElementById("driveCard").addEventListener("click", function() {
    const drivePopupOverlay = document.getElementById("drivePopup");
    drivePopupOverlay.style.display = "block"; // 팝업 표시
    setTimeout(() => drivePopupOverlay.classList.add("show"), 10); // 애니메이션 클래스 추가
});

// "내 차에 태우기" 팝업 닫기
document.getElementById("closeDrivePopup").addEventListener("click", function() {
    const drivePopupOverlay = document.getElementById("drivePopup");
    drivePopupOverlay.classList.remove("show"); // 애니메이션 클래스 제거
    setTimeout(() => drivePopupOverlay.style.display = "none", 300); // 애니메이션 후 팝업 숨기기
});

// "다른 차에 탑승하기" 카드 클릭 시 팝업 열기
document.getElementById("carpoolCard").addEventListener("click", function() {
    const carpoolPopupOverlay = document.getElementById("carpoolPopup");
    carpoolPopupOverlay.style.display = "block"; // 팝업 표시
    setTimeout(() => carpoolPopupOverlay.classList.add("show"), 10); // 애니메이션 클래스 추가
});

// "다른 차에 탑승하기" 팝업 닫기
document.getElementById("closeCarpoolPopup").addEventListener("click", function() {
    const carpoolPopupOverlay = document.getElementById("carpoolPopup");
    carpoolPopupOverlay.classList.remove("show"); // 애니메이션 클래스 제거
    setTimeout(() => carpoolPopupOverlay.style.display = "none", 300); // 애니메이션 후 팝업 숨기기
});

// 팝업 바깥쪽 클릭 시 닫기 (drivePopup)
window.addEventListener("click", function(event) {
    const drivePopupOverlay = document.getElementById("drivePopup");
    if (event.target === drivePopupOverlay) {
        drivePopupOverlay.classList.remove("show"); // 애니메이션 클래스 제거
        setTimeout(() => drivePopupOverlay.style.display = "none", 300); // 애니메이션 후 팝업 숨기기
    }
});

// 팝업 바깥쪽 클릭 시 닫기 (carpoolPopup)
window.addEventListener("click", function(event) {
    const carpoolPopupOverlay = document.getElementById("carpoolPopup");
    if (event.target === carpoolPopupOverlay) {
        carpoolPopupOverlay.classList.remove("show"); // 애니메이션 클래스 제거
        setTimeout(() => carpoolPopupOverlay.style.display = "none", 300); // 애니메이션 후 팝업 숨기기
    }
});
// "내 차에 태우기" 팝업 닫기 (X 버튼)
document.getElementById("closeDrivePopup").addEventListener("click", function() {
    const drivePopupOverlay = document.getElementById("drivePopup");
    drivePopupOverlay.classList.remove("show"); // 애니메이션 클래스 제거
    setTimeout(() => drivePopupOverlay.style.display = "none", 300); // 애니메이션 후 팝업 숨기기
});

// "다른 차에 탑승하기" 팝업 닫기 (X 버튼)
document.getElementById("closeCarpoolPopup").addEventListener("click", function() {
    const carpoolPopupOverlay = document.getElementById("carpoolPopup");
    carpoolPopupOverlay.classList.remove("show"); // 애니메이션 클래스 제거
    setTimeout(() => carpoolPopupOverlay.style.display = "none", 300); // 애니메이션 후 팝업 숨기기
});