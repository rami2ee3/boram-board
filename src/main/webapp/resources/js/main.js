const OnPageView = (baId) => {
    document.getElementById("frmBoardBaId").value = baId;

    const frmBoard = document.getElementById("frmBoard");
    frmBoard.action = `/detail`;
    frmBoard.submit();
}

const OnWritePage = () => {
    document.getElementById("frmBoard").action = "write";
    document.getElementById("frmBoard").submit();
}