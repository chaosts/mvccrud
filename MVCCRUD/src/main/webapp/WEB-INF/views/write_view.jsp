<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style>
    #container {
      width: 70%;
      margin: 0 auto;     /* 가로로 중앙에 배치 */
      padding-top: 10%;   /* 테두리와 내용 사이의 패딩 여백 */
    }
     
    #list {
      text-align: center;
    }
   
    #write {
      text-align: right;
    }
     
    /* Bootstrap 수정 */
    .table > thead {
      background-color: #b3c6ff;
    }
    .table > thead > tr > th {
      text-align: center;
    }
    .table-hover > tbody > tr:hover {
      background-color: #e6ecff;
    }
    .table > tbody > tr > td {
      text-align: center;
    }
    .table > tbody > tr > #title {
      text-align: left;
    }
     
    div > #paging {
      text-align: center;
    }
     
    .hit {
      animation-name: blink;
      animation-duration: 1.5s;
      animation-timing-function: ease;
      animation-iteration-count: infinite;
      /* 위 속성들을 한 줄로 표기하기 */
      /* -webkit-animation: blink 1.5s ease infinite; */
    }
     
    /* 애니메이션 지점 설정하기 */
    /* 익스플로러 10 이상, 최신 모던 브라우저에서 지원 */
    @keyframes blink {
      from {color: white;}
      30% {color: yellow;}
      to {color: red; font-weight: bold;}
      /* 0% {color:white;}
      30% {color: yellow;}
      100% {color:red; font-weight: bold;} */
    }
  </style>
</head>
<body>

	<div id="list">
		<h1>Write</h1>
	</div>

	<div class="container">
		<form action="write" method="post">
			<div class="form-group">
				<label for="bName">Writer</label> <input type="text"
					class="form-control" id="bName" name="bName">
			</div>

			<div class="form-group">
				<label for="bTitle">Subject</label> <input type="text"
					class="form-control" id="bTitle" name="bTitle">
					
			</div>

			<div class="form-group">
				<label for="bContent">Content</label>
				<textarea class="form-control" id="bContent" name="bContent"
					rows="3"></textarea>
			</div>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="확인">&nbsp;&nbsp;<input
					type="button" value="목록보기" onclick="location.href='list'">
			</tr>
        </form>
	</div>
</body>
</html>