<!-- 목록페이지 -->
<!-- 표를 이용해서 회원정보를 출력하는 페이지 -->
<%@page import="com.vo.member"%>		<!-- vo 추가 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %> <!-- 컬렉션 추가 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	
</head>
<body>
<div class="container">
  <h2>회원조회</h2>  
  <!-- 원하는 모양을 확인할 수 있을 정도로 임의로 작성 -->
  <!-- 디자인은 계속적으로 확인(모양)-파일명으로 확인 -->
  <!-- 페이지연결 a태그, 버튼 -->
  <a href="insert">등록</a>	<!-- insert doGet으로 이동 -->
  <table class="table table-bordered">
    <thead> <!-- head에 th개수만큼 body에 td개수를 맞춘다. -->
      <tr>
        <th>회원번호</th>
        <th>회원이름</th>
        <th>이메일</th>
        <th>수정작업</th>
        <th>삭제작업</th>
      </tr>
    </thead>
    <tbody><!-- 한개를 제외하고 삭제 -->
<!--  컬렉션으로 보내온 데이터를 받기 id 사용자명, scope 범위 
class 사용할 라이브러리, type 사용할 vo-->
<jsp:useBean id="members" 
scope = "request" 
class="java.util.ArrayList" 
type="java.util.ArrayList<com.vo.member>"/>
<%
//controller에서 members로 setAttribute로 전달한 값을 저장
//			저장할 사용자 변수		캐스트연산(가져온값을 변환)	setAttribute("members"))
//ArrayList<member> members = (ArrayList<member>)request.getAttribute("members");
%>
<%
//foreach문 members에 저장된 내용을 : mem에 하나씩 읽어서 처리
	for(member mem:members) {
%>
	  <tr>
        <td><%=mem.getMno() %></td>
        <td><%=mem.getMname() %></td>
        <td><%=mem.getMail() %></td>
        <!-- 수정, 삭제는 작업할 번호(기본키)를 수동으로 request -->
        <th><a href="update?mno=<%=mem.getMno()%>">수정</a></th>
        <td><a href="delete?mno=<%=mem.getMno()%>">삭제</a></td>
      </tr>
<%
	}
%>
      
    </tbody>
  </table>
</div>
</body>
</html>