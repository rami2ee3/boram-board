const OnMainPage = () => {
    const form = document.querySelector('#frmBoard');
    history.go(-1);
    //form.action = '/';
    //form.submit();
}

const OnModifyPage = () => {
    document.getElementById("frmBoard").method = `POST`;
    document.getElementById("frmBoard").action = `/modify`;
    document.getElementById("frmBoard").submit();

}

// 버튼 요소와 input 요소를 가져옵니다.
const showInputButton = document.getElementById('del-btn');
const pwInput = document.getElementById('pwInput');
const delete_proc = document.getElementById('delete_proc');

// 버튼 클릭 이벤트 리스너를 추가합니다.
showInputButton.addEventListener('click', function () {
    // input 요소를 보이게 만듭니다.
    pwInput.style.display = 'block';
    delete_proc.style.display = 'block';
});

const OnDelete = () => {
    const inputPassword = document.getElementById('pwInput');

    if (inputPassword.value === '') {
        alert('비밀번호를 입력해주세요.');
        inputPassword.focus();
        return false;
    }

    const frmBoard = document.getElementById('frmBoard');
    frmBoard.appendChild(inputPassword);
    frmBoard.action = '/delete_proc';
    frmBoard.method = 'POST';
    frmBoard.submit();
}

// 댓글 작성
const WriteComments = () => {
    // 댓글용 데이터 생성
    const baId = document.querySelector('#frmBoardBaId').value;
    const bcContents = document.querySelector('#contents').value;
    const bcPassword = document.querySelector('#comment-password').value;
    const data = {baId, bcContents, bcPassword}
    // form 데이터 생성
    const config = {headers: {"Content-Type": "application/x-www-form-urlencoded"}}
    // axios 호출
    axios.post('/comment_proc', data, config)
        .then(function (response) {
            const result = response.data;
            if (data === 'Y') {
                // TODO: 댓글 작성 성공 이후 액션 어떻게 할지
            } else {
                alert('댓글 등록에 실패하였습니다.')
            }
        })
        .catch(function (error) {
            console.log(error);
        });
}