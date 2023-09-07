console.log('main.js');

const OnPageView = (baId) => {
    console.log(`baId: ${baId}`);

    document.getElementById("frmBoardBaId").value = baId;
    document.getElementById("frmBoard").action = "detail";
    document.getElementById("frmBoard").submit();
}

const OnWritePage = () => {
    document.getElementById("frmBoard").action = "write";
    document.getElementById("frmBoard").submit();
}