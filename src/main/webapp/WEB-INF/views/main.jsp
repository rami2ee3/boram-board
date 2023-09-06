<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<%@include file="./include/header.jsp" %>


<body>
<select class="form-select form-select-sm w-25" aria-label="Small select example">
    <option selected>정렬 조건</option>
    <option value="1">작성자</option>
    <option value="2">글 내용</option>
    <option value="3">작성일</option>
</select>
<div class="d-flex gap-3">
    <div class="col-sm-4">
        <label for="exampleInputPassword1" class="form-label"></label>
        <input type="text" class="form-control" id="exampleInputPassword1">
    </div>
    <button type="button" class="btn btn-outline-info mt-auto">검색</button>
</div>
<table class="table table-hover mt-3">
    <thead>
    <tr>
        <th scope="col">글 번호</th>
        <th scope="col">제목</th>
        <th scope="col">작성일</th>
        <th scope="col">조회수</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${boardList}">
    <tr>
        <th scope="row">1</th>
        <td>${list.baTitle}</td>
        <td>
            <fmt:formatDate value="${list.baInsertDt}" pattern="yyyy.MM.dd"/>
        </td>
        <td>${list.baReadCount}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<div class="d-flex">
    <button type="button" class="btn btn-success ms-auto">작성하기</button>
</div>
</body>
</html>