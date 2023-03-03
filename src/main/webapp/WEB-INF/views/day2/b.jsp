<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF b.jsp</title>
</head>
<body>
<!-- WEB-INF URL페이지 경로로는 접근 불가 -->
WEB-INF b.jsp
</body>
</html>
<!-- 
WEB-INF 아래에 있는 jsp 페이지는 절대로 URL 접근 불가
반드시 서블릿을 경유하여 RequsetDispatcher 사용해 요청하여야 페이지 호출 가능
다만 scope는 request scope를 갖게되는 점을 주의
 -->