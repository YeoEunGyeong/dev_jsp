<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 스크립틀릿 ; 자바 코드를 선언할 수 있는 위치
// http://localhost:9000/ajax/pictuer/b.jsp?id=3 or 4
String id = request.getParameter("id");
// out.print(id); // 3 or 4
String pics[] = { "회의.jpg", "회의-1.jpg", "회의-2.jpg", "회의-3.jpg" };
String newIMG = null;
for (int i = 0; i < pics.length; i++) {
	// out.print(id + ", " + i);
	if (Integer.parseInt(id) == i) {
		newIMG = pics[i];
	} // end if
} // end for
%>
<!-- html 선언 지역 -->
<img id="imgDetail" src="../../images/sample/<%out.print(newIMG);%>"
	width="400px" height="400px" alt="그림" />