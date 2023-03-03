<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table border="1" bordercolor="gray" width="100%" height="100%">
	<tr>
		<td>
		<div id = "d_news">
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
		</div>
		</td>
	</tr>
</table>
