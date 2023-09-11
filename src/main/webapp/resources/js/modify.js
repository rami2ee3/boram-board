const OnModifyProc = () => {
    const formCheck = boardFormCheck();
    if(!formCheck) return;

    const baPassword = document.getElementById("ba_password");
    if(baPassword.value === '') {
        alert('패스워드를 입력해 주세요.');
        baPassword.focus();
        return false;
    }

    document.getElementById("frmBoard").submit();
}

const OnDetailPage = () => {
    const frmBoard = document.getElementById("frmBoard");
    frmBoard.action = "/detail";
    frmBoard.method = 'GET';
    frmBoard.submit();
}