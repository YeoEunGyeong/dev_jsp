package com.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc.dao.TestDao;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(MemberController.class);
	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		logger.fatal("doService 호출");
		logger.debug("doService 호출");
		logger.info("doService 호출");
		logger.warn("doService 호출");
		logger.error("doService 호출");
		TestDao tDao = new TestDao();
		List<Map<String, Object>> mList = tDao.getBookMember();
		// 페이지 이동
		// 페이지 이름 gerMemberList.jsp
		// 페이지의 물리적인 경로는 어디를 바라보고 있는가? web.xml > servlet - mapping[/test/test.co]
		// > url-pattern
		// 경로명/요청을 처리하는 이름.do[뒤에 오는 확장자는 의미 없음 ?
		// ; 해당 요청을 인터셉트해서 해당 업무를 담당하는 클래스에 연결해야 함] 
		// 연결을 담당하는 클래스 FrontController.java 설계 ; 각 업무별 XXXContorller 필요
		// 페이지 처리는 JSP에게 맡김
		// 서블릿은 요청을 받아서 업무 담당자에게 연결 (매핑, 매칭)
		// 이것을 어떻게 나눌 것 ?
		// ; 요청은 업무 담당자나 사용자에 선택에 따라 결정됨
		// 결정에 대응하는 클래스를 FrontController가 연결
		// FrontController에서 실제 업무를 담당하는 XXXController에 전달할 때
		// 요청 객체와 응답 객체에 전달되어져야 함
		// 요청 객체는 무엇을 누릴 수 있나 ?
		// 사용자가 입력한 값을 듣기 위해 필요 request !!
		// request.getParameter(""); String
		// session.getAttribute(""); Object
		// ; request.getParameter("XXX"); mem_id, mem_name, mem_pw, mem_address
		//   HttpSession session = request.getSession(); 세션 객체 생성
		// http 프로토콜이 비상태 프로토콜이므로 상태값을 관리하는 별도의 메카니즘 필요
		// 쿠키와 세션(:시간을 지배 ??) < List, Map < 객체 배열(:[{}]) < 배열 < 원시형 타입(:변수)
		// response
		// response.setContentType(); 마임 타입을 결정 가능
		// ; 서블릿/json, 서블릿/html, 서블릿/xml
		// response.setContentType("application/json");
		// response.setContentType("text/html");
		// response.setContentType("text/xml");
		// response.setContentType("text/css");
		// response.sendRedirect("페이지 이름"); > 페이지 이동
		// 주소창 변경 ; 기존에 요청이 끊어지고 새로운 요청 발생
		// 그렇지만 계속 유지하고 있는 상태로 보여야 함 -> 쿠키나 세션에 저장 -> 비상태 프로토콜이기 때문
		// 쿠키 ; 문자열 (객체는 받지 못함)
		// 세션 ; 캐시 메모리, 객체
		// 테스트 시나리오
		// 방법1 : TestSevlet.java 소스에서 오른쪽 버튼 눌러 실행
		// 방법2 : 브라우저 주소창에 http://localhost:9000/test/test.do 요청
		// 아래 코드를 만나기 전까지는 http://localhost:9000/test/test.do
		res.sendRedirect("./getMemberList.jsp");
		// 위의 코드를 읽으면 http://localhost:9000/test/getMemberList.jsp를 요청
		//String cTime = tDao.testDate();
		//logger.info("today : " + cTime);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doService(req, res);
	}
}
