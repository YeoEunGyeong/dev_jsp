<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//스크립틀릿
String mem_id = request.getParameter("mem_id");
out.print("사용자가 입력한 아이디 : " + mem_id);
String mem_pw = request.getParameter("mem_pw5555");
out.print("사용자가 입력한 비밀번호 : " + mem_pw);
String mem_name = request.getParameter("mem_name");
out.print("사용자가 입력한 이름 : " + mem_name);
out.print("<br />"); // 줄바꿈
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원가입
</body>
</html>