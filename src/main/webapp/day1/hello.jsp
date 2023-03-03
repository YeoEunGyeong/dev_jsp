<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id = "f_test" method = "post" action = "/day1/hello.kh">
<button>전송</button>
<!-- 전송 버튼에 대한 이벤트 처리가 없는데 요청이 서버에 전달되는 이유 ? 
type이 submit이기 때문에 별도에 이벤트 처리가 없더라도 즉시 전송이 일어남-->
<input type = "button" id = "btnSend" value = "전송">
<script type="text/javascript">
const btnSend = document.querySelector("#btnSend");
btnSend.addEventListener('click', () => {
	alert("전송 버튼 클릭")
	document.querySelector("#f_test").submit() // input일 때는 따로 이벤트 처리가 필요
})
</script>
</form>
</body>
</html>