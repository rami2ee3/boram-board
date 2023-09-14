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

document.getElementById("btnSearch").addEventListener("click", event => {
    const selectSearchType = document.getElementById("selectSearchType").value;
    const textSearchKeyword = document.getElementById("textSearchKeyword").value;

    console.log("selectSearchType: " + selectSearchType);
    console.log(`textSearchKeyword: ${textSearchKeyword}`);

    if(textSearchKeyword !== '') {
        if(selectSearchType === '') {
            alert('검색 조건을 선택해 주세요.');
            document.getElementById("selectSearchType").focus();
            return;
        }
    }

    const frmBoardSearch = document.getElementById("frmBoardSearch");
    frmBoardSearch.submit();
});


const changePage = (pageNumber) => {

    // http://localhost:8080/?currentPageNo=2
    // http://localhost:8080/?baId=&currentPageNo=1&searchType=&searchKeyword=

    document.getElementById('frmBoardBaId').value = 0;
    document.getElementById('frmBoardCurrentPageNo').value = pageNumber;
    document.getElementById('frmBoard').action = "/";
    document.getElementById('frmBoard').submit();
}