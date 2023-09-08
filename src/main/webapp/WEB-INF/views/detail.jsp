<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<%@include file="./include/header.jsp" %>

<style>
    .d-flex {
        margin-top : 30px;
    }
</style>

<body>

<h5 class="card-title">${detail.baTitle}</h5>
<h6><fmt:formatDate value="${detail.baInsertDt}" pattern="yyyy.MM.dd"/></h6>
<div class="card mb-3" style="max-width: 540px;">
    <div class="row g-0">
        <div class="col-md-4">
            <img src="..." class="img-fluid rounded-start" alt="...">
        </div>
        <div class="col-md-8">
            <div class="card-body">
                <pre class="card-text">${detail.baContents}</pre>
            </div>
        </div>
    </div>
</div>
<h6>댓글목록</h6>
<ul id="reply-list" class="list-group">
    <c:forEach var="comments" items="${commentsList}">
        <li class="list-group-item d-flex justify-content-between align-items-center">
                ${comments.bcContents}
            <span class="badge bg-secondary rounded-pill">
            ${comments.bcInsertDt}}
        </span>
        </li>
    </c:forEach>
</ul>
<div class="input-group mb-3">
    <input type="text" id="reply-content" class="reply-content form-control" placeholder="댓글 내용을 입력해 주세요"
           aria-describedby="reply-btn">
    <input type="text" id="reply-writer" class="reply-writer form-control" placeholder="비밀 번호를 입력해 주세요">
    <button type="button" id="comments-btn" class="reply-btn btn btn-outline-primary" onclick="WriteComments();">댓글작성</button>
</div>

<form id="frmBoard" name="frmBoard" method="GET">
    <input type="hidden" id="frmBoardBaId" name="baId" value="">
    <input type="hidden" id="frmBoardCurrentPage" name="frmBoardCurrentPage" value="">
</form>
<div class="d-flex">
    <button type="button" class="btn btn-outline-primary" onclick="">댓글수정</button>
    <button type="button" class="btn btn-outline-primary" onclick="">댓글삭제</button>

    <button type="button" class="btn btn-outline-info ms-auto" onclick="">이전</button>
    <button type="button" class="btn btn-outline-info" onclick="">다음</button>

    <button type="button" class="btn btn-outline-secondary ms-auto" onclick="OnMainPage();">목록으로</button>
    <button type="button" class="btn btn-outline-warning" onclick="OnModifyPage(${detail.baId});">수정하기</button>
    <button type="button" class="btn btn-outline-danger" onclick="DeleteConfirm(${detail.baId});">삭제하기</button>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/detail.js"></script>
</html>