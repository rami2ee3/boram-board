<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<%@include file="./include/header.jsp" %>


<body>
<form id="frmBoardSearch" name="frmBoardSearch" method="get" action="">
    <select id="selectSearchType" name="searchType" class="form-select form-select-sm w-25" aria-label="Small select example">
        <option value="">검색 조건</option>
        <option value="TITLE" <c:if test="${boardArticleVo.searchType eq 'TITLE'}">selected</c:if>>제목</option>
        <option value="CONTENTS" <c:if test="${boardArticleVo.searchType eq 'CONTENTS'}">selected</c:if>>내용</option>
    </select>
    <div class="d-flex gap-3">
        <div class="col-sm-4">
            <label for="textSearchKeyword" class="form-label"></label>
            <input type="text" id="textSearchKeyword" name="searchKeyword" class="form-control" value="${boardArticleVo.searchKeyword}">
        </div>
        <button type="button" id="btnSearch" class="btn btn-outline-info mt-auto">검색</button>
    </div>
</form>

<!-- proc 결과 -->
<c:if test="${procName eq 'modifyProc'}">
    <c:choose>
        <c:when test="${result > 0}">수정 완료되었습니다.</c:when>
        <c:otherwise>오류 발생!!!!</c:otherwise>
    </c:choose>
</c:if>
<c:if test="${procName eq 'deleteProc'}">
    <c:choose>
        <c:when test="${result > 0}">삭제 처리 되었습니다.</c:when>
        <c:otherwise>오류 발생!!!!</c:otherwise>
    </c:choose>
</c:if>
</label>

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
    <c:forEach var="board" items="${boardList}">
    <tr>
        <th scope="row">${board.baId}</th>
        <td><span onclick="OnPageView('${board.baId}')" style="cursor: pointer">${board.baTitle}</span></td>
        <td>
            <fmt:formatDate value="${board.baInsertDt}" pattern="yyyy.MM.dd"/>
        </td>
        <td>${board.baReadCount}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<div class="d-flex">
    <button type="button" class="btn btn-success ms-auto" onclick="OnWritePage();">작성하기</button>
</div>
<form id="frmBoard" name="frmBoard" method="GET">
    <input type="hidden" id="frmBoardBaId" name="baId" value="">
    <input type="hidden" id="frmBoardCurrentPageNo" name="currentPageNo" value="1">
    <input type="hidden" id="frmBoardSearchType" name="searchType" value="">
    <input type="hidden" id="frmBoardSearchKeyword" name="searchKeyword" value="">
</form>
<script src="${pageContext.request.contextPath}/resources/js/list.js"></script>
</body>
</html>
