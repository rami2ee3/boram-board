<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<%@include file="./include/header.jsp" %>

<style>
    #contents {
        width: 65%;
    }

    #comment-password {
        width: 25%;
    }

    #comments-btn {
        width: 10%;
    }

    #pwInput {
        width: 350px;
        margin-top: 20px;
    }

    #delete_proc {
        margin-top: 20px;
    }

</style>
<body>
<div class="card">
    <b class="card-header">${boardArticleEntity.baTitle}</b>
    <span class="card-header">작성일자 : <fmt:formatDate value="${boardArticleEntity.baInsertDt}"
                                                     pattern="yyyy.MM.dd"/></span>
    <div class="card-body">
        <pre class="card-text">${boardArticleEntity.baContents}</pre>
    </div>
</div>
<p class="mt-3">댓글목록</p>
<div class="card">
    <ul id="comment-list" class="list-group list-group-flush">
        <c:forEach var="comments" items="${commentsList}">
            <li class="list-group-item d-flex align-items-center">
                <span id="viewComment-${comments.bcId}" class="d-block">${comments.bcContents}</span>
                <div id="editComment-${comments.bcId}" class="d-flex w-100 gap-2 d-none">
                    <input class="w-75" type="text" value="${comments.bcContents}"/>
                    <i class="bi bi-check-square-fill cursor"></i>
                </div>
                <div class="d-flex ms-auto gap-3">
                    <span class="badge bg-secondary rounded-pill">${comments.bcInsertDt}</span>
                    <i class="bi bi-pencil-square cursor" onclick="OnModifyComments('${comments.bcId}')"></i>
                    <i class="bi bi-x-square cursor" onclick="OnDeleteComments('${comments.bcId}')"></i>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>

<div class="input-group mt-3">
    <input type="text" id="contents" name="contents" class="reply-content form-control" placeholder="댓글 내용을 입력해 주세요"
           aria-describedby="reply-btn">
    <input type="password" id="comment-password" name="comment-password" class="reply-writer form-control"
           placeholder="비밀 번호를 입력해 주세요">
    <button type="button" id="comments-btn" class="reply-btn btn btn-outline-primary" onclick="WriteComments();">댓글작성
    </button>
</div>
<div class="d-flex">
    <input type="password" id="pwInput" name="baPassword" style="display: none;" placeholder="삭제 하려면 비밀 번호를 입력해 주세요">
    <button type="submit" id="delete_proc" style="display: none;" onclick="OnDelete();">삭제</button>
</div>

<form id="frmBoard" name="frmBoard" method="GET">
    <input type="hidden" id="frmBoardBaId" name="baId" value="${boardArticleVo.baId}">
    <input type="hidden" id="frmBoardCurrentPageNo" name="currentPageNo" value="${boardArticleVo.currentPageNo}">
    <input type="hidden" id="frmBoardSearchType" name="searchType" value="${boardArticleVo.searchType}">
    <input type="hidden" id="frmBoardSearchKeyword" name="searchKeyword" value="${boardArticleVo.searchKeyword}">
</form>
<div class="d-flex gap-3 mt-3">
    <button type="button" class="btn btn-outline-info ms-auto" onclick="">이전</button>
    <button type="button" class="btn btn-outline-info" onclick="">다음</button>
    <button type="button" class="btn btn-outline-secondary" onclick="OnMainPage();">목록으로</button>
    <button type="button" class="btn btn-outline-warning" onclick="OnModifyPage();">수정하기</button>
    <button type="button" id="del-btn" class="btn btn-outline-danger">삭제하기</button>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/detail.js"></script>
</html>