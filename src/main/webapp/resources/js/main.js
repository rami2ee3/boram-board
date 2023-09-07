console.log('main.js');

const OnPageView = (baId) => {
    // RequestParam 으로 이동시킬 경우
    // document.getElementById("frmBoardBaId").value = baId;
    // document.getElementById("frmBoard").action = '/detail';
    // document.getElementById("frmBoard").submit();
    // PathVariable 로 이동시킬 경우
    document.getElementById("frmBoard").action = `/detail/${baId}`;
    document.getElementById("frmBoard").submit();
}

const OnWritePage = () => {
    document.getElementById("frmBoard").action = "write";
    document.getElementById("frmBoard").submit();
}