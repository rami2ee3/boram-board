<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>main</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>

<style>
    body {
        padding: 100px;
    }
</style>

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
        <th scope="col">작성자</th>
        <th scope="col">작성일</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>제목1</td>
        <td>신보람</td>
        <td>2023.09.01</td>
    </tr>
    <tr>
        <th scope="row">2</th>
        <td>제목2</td>
        <td>정의석</td>
        <td>2023.09.02</td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td>제목3</td>
        <td>허진영</td>
        <td>2023.09.03</td>
    </tr>
    <tr>
        <th scope="row">4</th>
        <td>제목4</td>
        <td>나진영</td>
        <td>2023.09.04</td>
    </tr>
    <tr>
        <th scope="row">5</th>
        <td>제목5</td>
        <td>이준규</td>
        <td>2023.09.05</td>
    </tr>
    </tbody>
</table>

<div class="d-flex">
    <button type="button" class="btn btn-success ms-auto">작성하기</button>
</div>
</body>
</html>