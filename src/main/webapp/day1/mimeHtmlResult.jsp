<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>카리나는 신이에요❤!!!!!!!!!!!!!!!!!!!!</h1>
	<%
	// 스크립틀릿 안에서 선언한 변수는 지역 변수
	// ; a.jsp > a_jsp.java 이때, service 메서드 안으로 들어감
	String myName = null; // 지역 변수는 초기화 필요
	myName = (String) session.getAttribute("myName");
	out.print(myName);
	out.print("<hr>");
	Integer age = null;
	age = (Integer) session.getAttribute("age");
	out.print(age);
	out.print("<hr>");
	Map<String, Object> rmap = (Map<String, Object>) session.getAttribute("ramp");
	if (rmap != null) { // NullPointException 방어 코드
		Object keys[] = rmap.keySet().toArray();
		for (int i = 0; i < keys.length; i++) {
			out.print(rmap.get(keys[i]));
			out.print("<br/>");
		}
	}
	out.print("<hr>");
	// getAttribute의 리턴 타입은 Object
	// getParameter의 리턴 타입은 String ; 사용자가 인증을 위해서 입력한 아이디를 서버에 전달할 때 사용
	List<Map<String, Object>> mList = (List<Map<String, Object>>) session.getAttribute("mList");
	// key = String, value = Object
	if (mList != null) {
		for (int i = 0; i < mList.size(); i++) {
			Map<String, Object> rMap = mList.get(i);
			out.print(rMap.get("mem_id") + ", " + rMap.get("mem_pw") + ", " + rMap.get("mem_name"));
			out.print("<br/>");
		}
	}
	%>
</body>
</html>