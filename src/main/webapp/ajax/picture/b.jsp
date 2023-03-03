<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    // 스크립틀릿 ; 자바 코드를 선언할 수 있는 위치
    // http://localhost:9000/ajax/pictuer/b.jsp?id=3 or 4
    String id = request.getParameter("id");
    out.print(id); // 3 or 4
    %>