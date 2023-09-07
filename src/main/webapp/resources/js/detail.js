const OnMainPage = () => {
    // 다 동일한 표현
    // const form = document.getElementById("frmBoard"); - js id selector ( 얘는 id 로만 찾는다 )
    // const form = $('#frmBoard') - jquery
    // const form = document.querySelector('#frmBoard'); - js query selector ( 얘는 .이랑 # 이런식으로 가져올수 있다 )
    const form = document.querySelector('#frmBoard');
    form.action = '/';
    form.submit();
}

const OnModifyPage = () => {
    document.getElementById("frmBoard").action = "modify";
}

const DeleteConfirm = () => {

}