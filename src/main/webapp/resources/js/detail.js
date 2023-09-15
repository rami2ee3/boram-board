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
showInputButton.addEventListener('click', function() {
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
function WriteComments() {
    let contents = document.getElementById("contents").value;
    let commentPassword = document.getElementById("comment-password").value;

    // XMLHttpRequest 객체 생성
    let xhr = new XMLHttpRequest();

    // POST 요청을 보낼 URL 설정
    xhr.open("POST", "/writeComment", true);

    // 요청 헤더 설정
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    // 요청 파라미터 설정
    let params = "contents=" + encodeURIComponent(contents) + "&commentPassword=" + encodeURIComponent(commentPassword);
    xhr.send(params);

    // 요청 완료 시 처리
    xhr.onload = function () {
        if (xhr.status === 200) {
            // 성공적으로 댓글 작성을 처리한 경우

            // 새로운 댓글 데이터
            const response = JSON.parse(xhr.responseText);
            const content = response.content;
            const bc_insert_dt = response.bc_insert_dt;

            // 새로운 댓글을 화면에 추가
            const replyList = document.getElementById('reply-list');

            // 새로운 댓글 DOM 요소 생성
            const newReplyItem = document.createElement('li');
            newReplyItem.className = 'list-group-item d-flex align-items-center';
            newReplyItem.innerHTML = `
                ${content}
                <span class="badge bg-secondary rounded-pill">
                    ${bc_insert_dt}
                </span>
            `;

            // 댓글 목록에 새로운 댓글 추가
            replyList.appendChild(newReplyItem);

            console.log("댓글 작성 성공");

            // 입력 필드 초기화
            document.getElementById('contents').value = '';
            document.getElementById('comment-password').value = '';

        } else {
            // 댓글 작성에 실패한 경우
            console.error("댓글 작성 실패");
        }
    };
}

