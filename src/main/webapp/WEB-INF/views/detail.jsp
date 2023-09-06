<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@include file="./include/header.jsp" %>



<body>

<h5 class="card-title">글 제목입니다.</h5>
<div class="card mb-3" style="max-width: 540px;">
    <div class="row g-0">
        <div class="col-md-4">
            <img src="..." class="img-fluid rounded-start" alt="...">
        </div>
        <div class="col-md-8">
            <div class="card-body">
                <pre class="card-text">글 내용입니다.</pre>
                <p class="card-text"><small class="text-body-secondary">작성일시</small></p>
            </div>
        </div>
    </div>
</div>
<div class="form-floating">
        <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2"
                  style="height: 100px"></textarea>
    <label for="floatingTextarea2">댓글</label>
</div>

<div  class="d-flex">
    <button type="button" class="btn btn-outline-warning ms-auto">수정하기</button>
    <button type="button" class="btn btn-outline-danger">삭제하기</button>
</div>
</body>
</html>