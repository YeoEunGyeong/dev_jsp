<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
  <script type = "text/javascript">
  // 호출하지 않아도 자동 실행
  // jquery(document)
  // window.document.ready() ready는 함수 ready(function)(){실행문 : 변수 선언, if문, switch문, i+j}
  $(document).ready(() => {
	  // 실행문
	  start = () => {
		  setInterval(autoReload, 2000);
  } // 2초 간격으로 autoReload 호출 출력
  //function start(){}
	  start();
  }); // end ready - DOM 다 읽었으면 실행함
  </script>
  <div id = "d_news">뉴스</div>
  <%
  System.out.print("<font color = 'red' size = 18></font>");
  %>
      <script>
    const autoReload = () => {
    	console.log('autoReload 호출')
    	// ajax 함수는 jquery.min.js가 제공하는 API
    	// XMLHttpRequest 대신한다
    	// const ajax = new XMLHttpRequest();
    	// ajax.open("GET", url, false)
    	// ajax.send()
        $.ajax({
            type: "GET",
            url: "newsList.jsp",
            success: function (data) {
              console.log(data);
              $("#d_news").html(data); // d_news = DOM
            },
          });
    }
    </script>
  </body>
</html>
<!-- 
html(단방향, 변수 선언이나 제어문 지원 안 됨, 이벤트 처리 불가)은 순차적 진행
자바 스크립트 코드의 위치에 따라 document.querySelector(id or class or ele)
; 선언이 먼저
자바 스크립트 위치
1 head 안 : 전변 선언, 함수 선언 할 때(호출해야 실행됨)
만일, 이것을 지연하고 싶을 때 defer 사용! HTML, DOM Tree 그린다
2 body 안 : 호출하지 않아도 실행(단 함수로 선언된 부분은 제외)

자바 스크립트로 화면 그릴 수 있음
document.write("<font color = 'red' size = 18></font>")

wirte는 어디에 ? 브라우저에
java는 브라우저에 쓸 수 없음

jsp라 쓰고 html
jsp라 쓰고 json
메인타입/서브타입 image/png, image/jpg, image/gif
 -->