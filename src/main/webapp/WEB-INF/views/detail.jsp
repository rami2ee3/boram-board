<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<%@include file="./include/header.jsp" %>

<style>
    #comments {
        width: 65%;
    }

    #comment-password {
        width: 25%;
    }

    #comments-btn {
        width: 10%;
    }
</style>
<body>
<div class="card">
    <b class="card-header">${boardArticleEntity.baTitle}</b>
    <span class="card-header">작성일자 : <fmt:formatDate value="${boardArticleEntity.baInsertDt}" pattern="yyyy.MM.dd"/></span>
    <div class="card-body">
        <pre class="card-text">${boardArticleEntity.baContents}</pre>
    </div>
</div>
<p class="mt-3">댓글목록</p>
<div class="card">
    <ul id="comment-list" class="list-group list-group-flush">
        <c:forEach var="comments" items="${commentsList}">
            <li class="list-group-item d-flex align-items-center">
                    ${comments.bcContents}
                <div class="d-flex ms-auto gap-3">
                    <span class="badge bg-secondary rounded-pill">${comments.bcInsertDt}</span>
                    <i class="bi bi-pencil-square cursor" onclick="OnModifyComments()"></i>
                    <i class="bi bi-x-square cursor" onclick="OnDeleteComments()"></i>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>

<div class="input-group mt-3">
    <input type="text" id="comments" class="reply-content form-control" placeholder="댓글 내용을 입력해 주세요"
           aria-describedby="reply-btn">
    <input type="password" id="comment-password" class="reply-writer form-control" placeholder="비밀 번호를 입력해 주세요">
    <button type="button" id="comments-btn" class="reply-btn btn btn-outline-primary" onclick="WriteComments();">댓글작성</button>
</div>
<form id="frmBoard" name="frmBoard" method="GET">
    <input type="hidden" id="frmBoardBaId" name="baId" value="${boardArticleEntity.baId}">
    <input type="hidden" id="frmBoardCurrentPageNo" name="currentPageNo" value="1">
    <input type="hidden" id="frmBoardSearchType" name="searchType" value="">
    <input type="hidden" id="frmBoardSearchKeyword" name="searchKeyword" value="">
</form>
<div class="d-flex gap-3 mt-3">
    <button type="button" class="btn btn-outline-info ms-auto" onclick="">이전</button>
    <button type="button" class="btn btn-outline-info" onclick="">다음</button>
    <button type="button" class="btn btn-outline-secondary" onclick="OnMainPage();">목록으로</button>
    <button type="button" class="btn btn-outline-warning" onclick="OnModifyPage();">수정하기</button>
    <button type="button" class="btn btn-outline-danger" onclick="DeleteConfirm(${boardArticleEntity.baId});">삭제하기</button>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/detail.js"></script>
</html>