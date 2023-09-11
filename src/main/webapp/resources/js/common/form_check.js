const boardFormCheck = () => {
    const baTitle = document.getElementById("ba_title");
    if(baTitle.value === '') {
        alert('제목을 입력해 주세요.');
        baTitle.focus();
        return false;
    }

    const baContents = document.getElementById("ba_contents");
    if(baContents.value === ''){
        alert('내용을 입력해 주세요');
        baContents.focus();
        return false;
    }

    return true;
}