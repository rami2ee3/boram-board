const checkForm = () => {
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

    const baPassword = document.getElementById("ba_password");
    if(baPassword.value === ''){
        alert('비밀 번호를 입력해 주세요');
        baPassword.focus();
        return false;
    }

    const baPasswordConfirm = document.getElementById("ba_password_confirm");

    if(baPassword.value !== baPasswordConfirm.value) {
        alert('비밀 번호를 확인해 주세요.')
        baPasswordConfirm.focus();
        return false;
    }

    return true;
}


const OnMainPage = () => {
    document.getElementById("frmBoard").action = "/";
}