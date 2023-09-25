<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@include file="./include/header.jsp" %>

<body>
<div class="d-flex flex-column gap-4">
    <form name="frmBoard" id="frmBoard" method="POST" action="/write_proc" enctype="multipart/form-data" onsubmit="return OnWriteProc();">
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">제목</span>
            <input type="text" name="baTitle" id="ba_title" class="form-control" placeholder="글 제목을 입력하세요"
                   aria-label="title"
                   aria-describedby="basic-addon1">
        </div>
        <div class="form-floating">
          <textarea name="baContents" id="ba_contents" class="form-control" placeholder="Leave a comment here"
                    id="floatingTextarea2"
                    style="height: 100px"></textarea>
            <label for="floatingTextarea2">글 내용</label>
        </div>
        <div>
            <input type="file" name="file">
        </div>
        <div class="form-floating w-25">
            <input type="password" name="baPassword" id="ba_password" class="form-control" id="floatingPassword"
                   placeholder="Password">
            <label for="floatingPassword">Password</label>
        </div>
        <div class="form-floating w-25">
            <input type="password" name="baPasswordConfirm" id="ba_password_confirm" class="form-control"
                   id="floatingConfirmPassword" placeholder="Password">
            <label for="floatingPassword">Password 확인</label>
        </div>
        <div class="d-flex gap-3">
            <button type="submit" class="btn btn-success ms-auto">작성 완료</button>
            <button type="button" class="btn btn-outline-secondary" onclick="OnMainPage();">작성 취소</button>
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/write.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common/form_check.js"></script>
</body>

</html>