<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <h1>Content</h1>
    </div>
      
       <input type="hidden" name="bId" value="${view.bId }">
       	 <div class="container"> 
       <table class="table table-striped table-bordered table-hover">
            <tr>
				<td>번호</td>
				<td> ${view.bId} </td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td> ${view.bHit} </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> ${view.bName}</td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> ${view.bTitle}</td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td>${view.bContent }</td>
			</tr>
			
			<tr >
				<td colspan="2"> 
				<a href="modify_view?bId=${view.bId }">수정</a> &nbsp;&nbsp; 
				<a href="list">목록보기</a> &nbsp;&nbsp; 
				<a href="delete?bId=${view.bId}">삭제</a> &nbsp;&nbsp; 
				<a href="reply_view?bId=${view.bId}">답변</a></td>
			</tr>
   
         </table>
       </div>


</body>
</html>