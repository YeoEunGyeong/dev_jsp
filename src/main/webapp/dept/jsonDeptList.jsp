<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	// jsp 페이지이지만 page directive에 마임 타입을 application/json
	// 브라우저는 페이지를 json 포맷으로 인지
	String temp = (String)request.getAttribute("jsonDoc");
	out.print(temp);
%>
 