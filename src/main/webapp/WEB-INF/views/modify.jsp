<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@include file="./include/header.jsp" %>


<body>
<div class="d-flex flex-column gap-4">
    <form name="frmBoard" id="frmBoard" method="POST" action="modify/${detail.baId}" onsubmit="">
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">제목</span>
        <input type="text" class="form-control" placeholder="글 제목을 입력하세요" aria-label="title"
               aria-describedby="basic-addon1">
    </div>

    <div class="form-floating">
      <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"
                style="height: 100px"></textarea>
        <label for="floatingTextarea">글 내용</label>
    </div>
<%--    <c:forEach var="comments" items="${commentsList}">--%>
<%--    <ul class="list-group">--%>
<%--        <li class="list-group-item">${}</li>--%>
<%--    </ul>--%>
<%--    </c:forEach>--%>
    <div class="custom-file">
        <input type="file" class="custom-file-input" id="customFile">
        <label class="custom-file-label" for="customFile"></label>
    </div>

    <div class="form-floating w-25">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Password</label>
    </div>
    <div class="form-floating w-25">
        <input type="password" class="form-control" id="floatingConfirmPassword" placeholder="Password">
        <label for="floatingPassword">Password 확인</label>
    </div>

    <div class="d-flex">
        <button type="button" class="btn btn-warning ms-auto">수정 완료</button>
        <button type="button" class="btn btn-secondary">수정 취소</button>
    </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/write.js"></script>
</body>

</html>