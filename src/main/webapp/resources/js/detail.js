const OnMainPage = () => {
    // 다 동일한 표현
    // const form = document.getElementById("frmBoard"); - js id selector ( 얘는 id 로만 찾는다 )
    // const form = $('#frmBoard') - jquery
    // const form = document.querySelector('#frmBoard'); - js query selector ( 얘는 .이랑 # 이런식으로 가져올수 있다 )
    const form = document.querySelector('#frmBoard');
    form.action = '/';
    form.submit();
}

const OnModifyPage = (baId) => {
    document.getElementById("frmBoard").action = `/modify/${baId}`;
    prompt('비밀 번호를 입력해 주세요', '글 작성시 입력한 비밀 번호');

    document.getElementById("frmBoard").submit();
}

const DeleteConfirm = (baId) => {
    // TODO : 삭제 구현

}


const WriteComments = async () => {

    const baId = document.querySelector('#frmBoardBaId').value;
    const bcComments = document.querySelector('#comments').value;
    const bcPassword = document.querySelector('#comment-password').value;


    // 1. ajax 호출을 위해 XMLHttpRequest 객체 호출
    const request = new XMLHttpRequest();
    request.open('POST', '/comments', true);
    // 2. ajax 콜백 함수
    request.onload = function () {
        // 성공했을때
        if (this.status === 200) {
            const resp = this.response;
            const regComments = JSON.parse(resp);
            const commentHTML = `<li class="list-group-item d-flex align-items-center">
                    ${regComments.bcContents}
                <div class="d-flex ms-auto gap-3">
                    <span class="badge bg-secondary rounded-pill">${regComments.bcInsertDt}</span>
                    <i class="bi bi-pencil-square cursor"></i>
                    <i class="bi bi-x-square cursor"></i>
                </div>
            </li>`;
            document.querySelector('#comment-list').append(commentHTML);
        }
    };
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
    request.send(`baId=${baId}&bcContents=${bcComments}&bcPassword=${bcPassword}`);

}