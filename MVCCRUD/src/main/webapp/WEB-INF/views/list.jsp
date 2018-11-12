<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <h1>CRUD</h1>
  </div>

<center>
  <div class="container"> 
   <table class="table table-striped table-bordered table-hover">
    <thead> 
     <tr>
       <td align="center">번호</td>
       <td align="center">작성자</td>
       <td align="center">제목</td>
       <td align="center">날짜</td>
       <td align="center">조회수</td>
     </tr>
     </thead>
    <c:forEach items="${list }" var="dto">
    <tr>
       <td>${dto.bId }</td>
       <td>${dto.bName }</td>
       <td>
           <c:forEach begin="1" end="${dto.bIndent }">-</c:forEach>
           <a href="content_view?bId=${dto.bId }">${dto.bTitle}</a>
       </td>
       <td>${dto.bDate }</td>
       <td>${dto.bHit }</td>
    </tr>
    </c:forEach> 
    
    <tr>
        <td colspan="5" align="center"><input type="button" value="글 쓰기" onClick="location.href='write_view'">
    </tr>
       
   </table>
   </div>
</center>

</body>
</html>