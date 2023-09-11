const OnMainPage = () => {
    const form = document.querySelector('#frmBoard');
    form.action = '/';
    form.submit();
}

const OnModifyPage = () => {
    document.getElementById("frmBoard").method = `POST`;
    document.getElementById("frmBoard").action = `/modify`;
    document.getElementById("frmBoard").submit();

}

const DeleteConfirm = () => {
    const inputPassword = prompt('삭제하실 글의 비밀번호를 입력해주세요');
    if (inputPassword === '') {
        alert('비밀번호를 입력해주세요.');
        return;
    }
    // form태그에 넣어줄 password용 태그 생성
    const baPasswordInput = document.createElement('input');
    baPasswordInput.type = 'hidden';
    baPasswordInput.name = 'baPassword';
    baPasswordInput.value = inputPassword;

    const frmBoard = document.getElementById('frmBoard');

    frmBoard.appendChild(baPasswordInput);
    frmBoard.action = '/delete_proc';
    frmBoard.method = 'POST';
    frmBoard.submit();

}

