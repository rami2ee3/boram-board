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

// 댓글 수정
const OnModifyComments = (bcId) => {
    const bcPassword = prompt('비밀번호를 입력해주세요')
    if (bcPassword === '') {
        alert('비밀번호를 입력해주세요')
        return
    } else {
        // const viewComment = document.querySelector(`#viewComment-${bcId}`);
        // viewComment.classList.remove('d-block')
        // viewComment.classList.add('d-none')
        // const editComment = document.querySelector(`#editComment-${bcId}`);
        // editComment.classList.remove('d-none')
        // editComment.classList.add('d-block')

        // 서버로 비밀번호 검증 요청 보내기
        axios.post('/modify_comment', { bcId, bcPassword })
            .then(function (response) {
                const result = response.data.result;
                if (result === 'valid') {
                    // 유효한 비밀번호인 경우, 댓글 수정 화면으로 전환
                    const viewComment = document.querySelector(`#viewComment-${bcId}`);
                    viewComment.classList.remove('d-block');
                    viewComment.classList.add('d-none');
                    const editComment = document.querySelector(`#editComment-${bcId}`);
                    editComment.classList.remove('d-none');
                    editComment.classList.add('d-block');
                } else {
                    alert('비밀번호가 일치하지 않습니다.');
                }
            })
            .catch(function (error) {
                console.log(error);
                alert('서버 오류가 발생했습니다.');
            });
    }
}

// 댓글 삭제
const OnDeleteComments = (bcId) => {
    const bcPassword = prompt('비밀번호를 입력해주세요')
    if (bcPassword === '') {
        alert('비밀번호를 입력해주세요')
        return
    } else {
        axios.post('/delete_comment', { bcId, bcPassword })
            .then(function (response) {
                const result = response.data.result;
                if (result === 'valid') {
                    const commentElement = document.getElementById(`comment-${bcId}`);
                    if (commentElement) {
                        commentElement.remove();
                    } else {
                            alert('해당 댓글을 찾을 수 없습니다.');
                    }
                } else {
                    alert('비밀번호가 일치하지 않습니다.');
                }
            })
            .catch(function (error) {
                console.log(error);
                alert('서버 오류가 발생했습니다.');
            });
    }

}

// 댓글 작성
const WriteComments = () => {

    // 댓글용 데이터 생성
    const baId = document.querySelector('#frmBoardBaId').value;
    const bcContents = document.querySelector('#contents').value;
    if(bcContents === ''){
        alert('댓글 내용을 입력해 주세요');
        document.querySelector('#contents').focus();
        return false;
    }
    const bcPassword = document.querySelector('#comment-password').value;
    if(bcPassword === ''){
        alert('비밀번호를 입력해 주세요');
        document.querySelector('#comment-password').focus();
        return false;
    }

    const data = {baId, bcContents, bcPassword}
    // form 데이터 생성
    // const config = {headers: {"Content-Type": "application/x-www-form-urlencoded"}}
    const formData = new FormData();
    formData.append('baId', baId);
    formData.append('bcContents', bcContents);
    formData.append('bcPassword', bcPassword);

    // axios 호출
    axios.post('/comment_proc', formData)
        .then(function (response) {
            console.log(response);
            const result = response.data.result;
            console.log(`result: ${result}`);

            if (result === 'Y') {
                const newComments = response.data.data;

                const replyHTML = `
                <li class="list-group-item d-flex align-items-center">
                    ${newComments.bcContents}
                <div class="d-flex ms-auto gap-3">
                    <span class="badge bg-secondary rounded-pill">${newComments.bcInsertDt}</span>
                    <i class="bi bi-pencil-square cursor" onclick="OnModifyComments('${newComments.bcId}')"></i>
                    <i class="bi bi-x-square cursor" onclick="OnDeleteComments('${newComments.bcId}')"></i>
                </div>
            </li>
            `;

                // document.querySelector('#comment-list').innerHTML = document.querySelector('#comment-list').innerHTML + replyHTML;
                document.querySelector('#comment-list').insertAdjacentHTML('afterend', replyHTML);

                document.getElementById('contents').value = '';
                document.getElementById('comment-password').value = '';

                alert('댓글이 등록되었습니다.');
            } else if (result === 'N') {
                alert('댓글이 등록되지 않았습니다.');
            } else if (result === 'E') {
                alert('댓글 등록중 오류가 발생했습니다.');
            }
        })
        .catch(function (error) {
            console.log(error);
        });
}