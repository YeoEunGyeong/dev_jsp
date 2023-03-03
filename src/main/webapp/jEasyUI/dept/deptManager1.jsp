<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../../../common/easyUI_common.jsp"%>
</head>
<body>
	<table id = "dg"></table>
	<script type="text/javascript">
	// jquery에서 제공하는 ready 함수 사용 ; 돔 구성이 되었을 때
	$(document).ready(function() {
		$('#dg').datagrid({
			// dg가 누구인지 모르면 화면에 출력 Xxx
			title : '부서 관리',
			url : 'datagrid_data.json',
			columns : [ [ {
				field : 'code',
				title : 'Code',
				width : 100
			}, {
				field : 'name',
				title : 'Name',
				width : 100
			}, {
				field : 'price',
				title : 'Price',
				width : 100,
				align : 'right'
			} ] ]
		});
	})
	</script>
</body>
</html>