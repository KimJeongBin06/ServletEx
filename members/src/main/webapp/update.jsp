<%@page import="com.vo.member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	
</head>
<body>
<!-- 수정페이지는 수정하는 데이터의 기본 키값을 반드시 저장 -->
<!-- 누구를 수정할것인가? -->
<%
member members = (member)request.getAttribute("members");
%>
<div class="container mt-3">
  <h3>회원 수정</h3>
  <form action="update" method="post" class="col-3">
  <input type="hidden" name="mno" value=<%=members.getMno() %>> <!-- 숨겨진 기본키 -->
  	<div class="mb-3 mt-3">
      <label for="mname">회원이름</label>
      <input type="text" class="form-control" id="mname" placeholder="이름을 입력하세요" name="mname" value=<%=members.getMname() %>>
    </div>
    <div class="mb-3 mt-3">
      <label for="mail">이메일:</label>
      <input type="email" class="form-control" id="mail" placeholder="이메일을 입력하세요" name="mail" value=<%=members.getMail() %>>
    </div>
    <div class="mb-3">
      <label for="pwd">비밀번호:</label>
      <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요" name="pwd" value=<%=members.getPwd() %>>
    </div>
    
    <button type="submit" class="btn btn-primary">수정</button>
  </form>
</div>
</body>
</html>