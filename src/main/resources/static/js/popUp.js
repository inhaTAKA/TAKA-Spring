document.getElementById("driveCard").addEventListener("click", function () {
    const drivePopupOverlay = document.getElementById("drivePopup");

    // 팝업 표시
    drivePopupOverlay.style.display = "block";
    setTimeout(() => drivePopupOverlay.classList.add("show"), 10);

    // 드롭다운 초기화
    const startSidoSelect = document.getElementById("startsido");
    const startSigunguSelect = document.getElementById("startsigungu");
    const transitSidos = ["transitSido", "transitSido2", "transitSido3"];

    // 출발 지역 초기화
    startSidoSelect.value = ""; // "목적지의 시/도를 선택하세요" 기본값으로 설정
    startSigunguSelect.innerHTML = '<option value="" disabled selected>시/군/구를 선택하세요</option>';
    startSigunguSelect.disabled = true;

    // 도착 지역 초기화
    const arriveSidoSelect = document.getElementById("arrivesido");
    const arriveSigunguSelect = document.getElementById("arrivesigungu");
    arriveSidoSelect.value = ""; // "목적지의 시/도를 선택하세요" 기본값으로 설정
    arriveSigunguSelect.innerHTML = '<option value="" disabled selected>시/군/구를 선택하세요</option>';
    arriveSigunguSelect.disabled = true;

    // 경유 지역 초기화
    transitSidos.forEach(id => {
        const transitSido = document.getElementById(id);
        const transitSigungu = document.getElementById(id.replace("Sido", "Sigungu"));

        transitSido.value = ""; // "시/도를 선택하세요" 기본값으로 설정
        transitSigungu.innerHTML = '<option value="" disabled selected>시/군/구를 선택하세요</option>';
        transitSigungu.disabled = true;
    });
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

const regions = {
    "서울특별시": ["강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구"],
    "부산광역시": ["해운대구", "부산진구", "사하구", "동래구", "남구", "북구"],
    "경기도": ["수원시", "고양시", "용인시", "성남시", "부천시", "화성시"],
    // 추가 시도 및 시군구 목록
};

function updateSigungu(sidoSelect, sigunguId) {
    const sigunguSelect = document.getElementById(sigunguId);
    const selectedSido = sidoSelect.value;

    sigunguSelect.innerHTML = '<option value="" disabled selected>시/군/구를 선택하세요</option>';
    sigunguSelect.disabled = !selectedSido;

    if (selectedSido && regions[selectedSido]) {
        regions[selectedSido].forEach((sigungu) => {
            const option = document.createElement("option");
            option.value = sigungu;
            option.text = sigungu;
            sigunguSelect.appendChild(option);
        });
    }
}

function updateTransitSigungu(sidoId, sigunguId) {
    const sidoSelect = document.getElementById(sidoId);
    const sigunguSelect = document.getElementById(sigunguId);
    const selectedSido = sidoSelect.value;

    sigunguSelect.innerHTML = '<option value="" disabled selected>시/군/구를 선택하세요</option>';
    sigunguSelect.disabled = !selectedSido;

    if (selectedSido && regions[selectedSido]) {
        regions[selectedSido].forEach((sigungu) => {
            const option = document.createElement("option");
            option.value = sigungu;
            option.text = sigungu;
            sigunguSelect.appendChild(option);
        });
    }

    document.getElementById("driveCard").addEventListener("click", function() {
        const drivePopupOverlay = document.getElementById("drivePopup");

        // 팝업 표시
        drivePopupOverlay.style.display = "block";
        setTimeout(() => drivePopupOverlay.classList.add("show"), 10);

        // 드롭다운 초기화
        const sidoSelect = document.getElementById("sido");
        const sigunguSelect = document.getElementById("sigungu");
        sidoSelect.value = ""; // 시/도를 선택하세요 기본값으로 초기화
        sigunguSelect.innerHTML = '<option value="" disabled selected>시/군/구를 선택하세요</option>'; // 초기값
        sigunguSelect.disabled = true; // 선택 비활성화
    });

}