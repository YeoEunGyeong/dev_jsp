<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Map" %>
<% 
	// 테스트 시나리오
	// 서블릿 경유하여 forward 메서드 호출의 결과 페이지로 b.jsp 출력될 때
	// rmap이 null 아니므로 주의
	// 즉, b.jsp 페이지를 직접 호출하면 출력값은 null
	Map<String, Object> rmap = (Map<String, Object>)request.getAttribute("rmap");
	out.print(rmap.get("mem_id")); // NullPointException
%>
<hr>
<!-- 익스프레션으로 출력 -->
<%= rmap.get("mem_id") %>

<!-- 
200번 성공
300번 재요청으로 인한 304번 에러
400번 클라이언트측의 실수 에러
500번 서버 에러
 -->