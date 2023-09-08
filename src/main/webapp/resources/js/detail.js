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
    prompt('비밀 번호를 입력해 주세요','글 작성시 입력한 비밀 번호');

    document.getElementById("frmBoard").submit();
}

const DeleteConfirm = (baId) => {
    // TODO : 삭제 구현

}


const WriteComments = async () => {

}