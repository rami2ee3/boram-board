<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<%@include file="./include/header.jsp" %>



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
<div class="form-floating">
        <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2"
                  style="height: 100px"></textarea>
    <label for="floatingTextarea2">댓글</label>
</div>
<form id="frmBoard" name="frmBoard" method="GET">
    <input type="hidden" id="frmBoardBaId" name="baId" value="">
    <input type="hidden" id="frmBoardCurrentPage" name="frmBoardCurrentPage" value="">
</form>
<div  class="d-flex">
    <button type="button" class="btn btn-outline-secondary ms-auto" onclick="OnMainPage();">목록으로</button>
    <button type="button" class="btn btn-outline-warning" onclick="OnModifyPage();">수정하기</button>
    <button type="button" class="btn btn-outline-danger"onclick="DeleteConfirm();">삭제하기</button>
</div>
</body>
</html>