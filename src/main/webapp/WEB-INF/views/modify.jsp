<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@include file="./include/header.jsp" %>


<body>
<form name="frmBoard" id="frmBoard" method="POST" action="/modify_proc" onsubmit="return OnModifyProc();">
    <div class="d-flex flex-column gap-4">
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">제목</span>
            <input type="text" id="ba_title" name="baTitle" value="${boardArticleEntity.baTitle}" class="form-control" placeholder="글 제목을 입력하세요" aria-label="title"
                   aria-describedby="basic-addon1">
        </div>

        <div class="form-floating">
        <textarea id="ba_contents" name="baContents" class="form-control" placeholder="Leave a comment here" id="floatingTextarea"
                style="height: 100px">${boardArticleEntity.baContents}</textarea>
            <label for="floatingTextarea">글 내용</label>
        </div>
        <div class="custom-file">
            <input type="file" class="custom-file-input" id="customFile">
            <label class="custom-file-label" for="customFile"></label>
        </div>
        <div class="form-floating w-25">
            <input type="password" id="ba_password" name="baPassword" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">Password</label>
        </div>
        <div class="d-flex gap-3">
            <button type="submit" class="btn btn-warning ms-auto">수정 완료</button>
            <button type="button" class="btn btn-secondary" onclick="OnDetailPage();">수정 취소</button>
        </div>

    </div>

    <input type="hidden" id="frmBoardBaId" name="baId" value="${boardArticleVo.baId}">
    <input type="hidden" id="frmBoardCurrentPageNo" name="currentPageNo" value="${boardArticleVo.currentPageNo}">
    <input type="hidden" id="frmBoardSearchType" name="searchType" value="${boardArticleVo.searchType}">
    <input type="hidden" id="frmBoardSearchKeyword" name="searchKeyword" value="${boardArticleVo.searchKeyword}">
</form>
<script src="${pageContext.request.contextPath}/resources/js/common/form_check.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/modify.js"></script>
</body>

</html>