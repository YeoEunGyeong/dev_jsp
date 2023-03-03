<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String smem_id = (String)session.getAttribute("smem_id");
	String smem_name = (String)session.getAttribute("smem_name");
	out.print("세션에서 꺼내온 값 : " + smem_id + ", "+ smem_name);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Application</title>
<%@ include file="../common/easyUI_common.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
<script type="text/javascript">
const login = () => {
	// 테스트 : com.mve.dao.MemberDao.java
	// xml : com.mybatis.mapper > member.xml
	/* 
	SELECT mem_name FROM book_member
 WHERE mem_id =:id
   AND mem_pw =:pw
	*/
	// 사용자가 입력한 아이디 가져오기
	const user_id = $("#_easyui_textbox_input1").val();
	// 사용자가 입력한 비밀번호 가져오기
	const user_pw = $("#_easyui_textbox_input2").val();
	alert(user_id + user_pw);
	
}
</script>
</head>
<body>
	<h2>실습</h2>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 1000px; height: 550px;">
		<!-- 메뉴 구성 [로그인 화면과 트리 메뉴] -->
		<div id="p" data-options="region:'west'" title="EUNGYEONG"
			style="width: 200px; padding: 10px">
			<!-- ===================[로그인 화면]================== -->
			<div id="d_login" align="center">
				<!-- create table member mem_id varchar2(10) -->
				<input id="tb_id" type="text" style="width: 150px">
				<script>
					$('#tb_id').textbox({
						iconCls : 'icon-man',
						iconAlign : 'right',
						prompt : 'Id'
					})
				</script>
				<div style="margin: 4px 0"></div>
				<input id="pb_pw" type="text" style="width: 150px">
				<script>
					$(function() {
						$('#pb_pw').passwordbox({
							prompt : 'Password',
							showEye : true
						});
					});
				</script>
				<div style="margin: 4px 0"></div>
				<a id="btn_login" href="javascript:login()">login</a>
				<script>
					$('#btn_login').linkbutton({
						iconCls : 'icon-search'
					});
				</script>
				<a id="btn_member" href="javascript:memberShip()">signup</a>
				<script>
					$('#btn_member').linkbutton({
						iconCls : 'icon-add'
					});
				</script>
			</div>
			<!-- ===================[로그아웃 화면]================== -->
			<div id="d_logout" align="center"></div>
			<div style="margin: 6px 0"></div>
			<ul id="tre_gym" class="easyui-tree">
				<li data-options="state:closed"><span>회원 관리</span>
					<ul>
						<li><a href="#">회원 목록</a></li>
						<li><a href="#">회원 등록</a></li>
						<li><a href="#">회원 삭제</a></li>
					</ul></li>
				<li data-options="state:closed"><span>쪽지함</span>
					<ul>
						<li><a href="#">받은 쪽지함</a></li>
						<li><a href="#">보낸 쪽지함</a></li>
					</ul></li>
				<li data-options="state:closed"><span>기타</span>
					<ul>
						<li><a href="#">우편번호 검색기</a></li>
						<li><a href="#">게시판</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- 메뉴 구성  -->
		<!-- 메인 화면 [게시판, 온라인 시험, 쪽지 관리(받은 쪽지, 보낸 쪽지), 회원 관리(회원 목록, 회원 등록, 회원 삭제), 우편번호 검색기] -->
		<div data-options="region:'center', iconCls:'icon-ok'"
			title="20-04-1996">
			<div style="margin: 5px 0;"></div>
			Home > 회원관리 > 회원목록
			<hr>
			<div style="margin: 25px 0;"></div>
		</div>
		<!-- 메인화면 [게시판, 온라인시험, 회원관리, 우편번호검색기] -->
	</div>
</body>
</html>
<!--
부트스트랩 - 리액트 수업 > spring과 리액트 연계 수업 > 프로젝트 적용
; 반응형 지원, CSS 라이브러리 사용

jEasyUI 
; 이벤트 처리(jquery ; 레거시 시스템)
자바스크립트 표준이 아니라 jquery 기반
자바스크립트 기반의 UI 솔루션 사용
개발자 도구 활용 - 디버깅 > html을 래핑하기 때문에 문제 해결이나 디버깅
view.js, react.js

JSTL

로그인 테스트 시나리오
1 intro 아래 index.jsp 실행
2 아이디와 비밀번호 입력 받음
3 로그인 버튼 클릭 > 자바 스크립트에 login() 함수 호출
4 login.do 호출 > 로그인 처리를 하는 서블릿 호출 - doGet(), doPost()
5 com.mvc.dao.MemberDao 클래스 인스턴스화
6 로그인 처리 메서드 호출
7 MemberDao의 login(Map[mem_id(사용자가 입력한 id), mem_pw(사용자가 입력한 pw)]) 메서드 호출
8 리턴 타입으로 Map 받아옴 (mem_id, mem_name)
9 8에서 돌려 받은 Map에서 (?) 오라클 서버에서 조회된 id와 이름을 session에 담음
10 페이지 이동은 sendTedirect나 forward 모두 가능
  ; forward로 응답 처리한 경우 인증 후에 다른 서비스를 forward로 처리하는 것 불가하므로 주의!

 -->
