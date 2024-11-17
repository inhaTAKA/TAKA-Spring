document.addEventListener('DOMContentLoaded', function () {
    const dropdownButton = document.getElementById('dropdownMenuButton');
    const dropdownMenu = document.getElementById('dropdownMenu');

    // 드롭다운 메뉴 토글
    dropdownButton.addEventListener('click', function (event) {
        event.preventDefault();
        dropdownMenu.classList.toggle('show');
    });

    // 외부 클릭 시 드롭다운 닫기
    document.addEventListener('click', function (event) {
        if (!dropdownButton.contains(event.target) && !dropdownMenu.contains(event.target)) {
            dropdownMenu.classList.remove('show');
        }
    });
});