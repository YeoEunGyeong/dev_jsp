<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.*, com.google.gson.Gson" %>
<%
	List<Map<String, Object>> memberList = new ArrayList<>();
	Map<String, Object> map = new HashMap<>();
	map.put("mem_id", "taeyeon");
	memberList.add(map);
	map = new HashMap<>();
	map.put("mem_id", "karina");
	memberList.add(map);
	map = new HashMap<>();
	map.put("mem_id", "winter");
	memberList.add(map);
	// 구글에서는 Gson.jar 라이브러리 지원
	Gson g = new Gson();
	String temp = g.toJson(memberList);
	out.print(temp);
	// 아래와 같이 자료 구조를 출력하면 JSON 포맷이 아님 ; 자바 스크립트에서 읽을 수 없으므로 조회 결과 없음
	//out.print(memberList);
%>