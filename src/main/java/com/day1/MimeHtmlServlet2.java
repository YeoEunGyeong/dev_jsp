package com.day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

// 서블릿은 java인데 브라우저에 출력 가능 ; 화면 그리는데 서블릿 사용 (mime 타입이 가능하게 해 줌)

// 서블릿을 경유하여 응답 페이지를 jsp로 가져가는 실습
// ; 최초 mimeHtmlResult.jsp를 직접 호출하는 것이 아닌
// URL /day1/html2.do 요청했을 때 42열 만나 mimeHtmlResult.jsp
// 주소창이 변경되는 것을 관찰한 뒤 서블릿에서 세션에 담은 정보를 mimeHtmlResult.jsp 페이지에서 유지되는 지 확인
@WebServlet("/day1/html2.do") // 웹에서 접근 가능한 맵핑 주소 설정
public class MimeHtmlServlet2 extends HttpServlet {
	Logger logger = Logger.getLogger(MimeHtmlServlet2.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		logger.info("doGet 호출");
		// 요청 객체로 세션 객체를 생성
		// 서블릿에서는 객체의 유지 정도가 다름
		// scope 지원
		// page scope ; 그 페이지 안에서만 기억해 줌 
		// request scope ; 요청이 유지되는 동안에만 유지(: URL 주소가 그대로 일 때만 유지되고 바뀌면 잃어버림)
		// session scope ; URL 주소가 변경되어도 유지 - 톰캣 서버
		// application scope ; 계속해서 진행되므로 사용하면 서버가 다운 (사용 Xxx)
		HttpSession session = req.getSession(); // req.getSession이 요청 객체
		// request(요청) 객체가 있어야 session 주입 받을 수 있음
		// 시간 연장이 가능
		String myName = new String("유지민");
		int age = 24;
		Map<String, Object> rmap = new HashMap<>();
		rmap.put("mem_id", "karina");
		rmap.put("mem_pw", "123");
		rmap.put("mem_name", "유지민");
		List<Map<String, Object>> mList = new ArrayList<>();
		if (rmap != null) {
			rmap.clear(); // rmap 값 초기화
		}
		rmap = new HashMap<>();
		rmap.put("mem_id", "karina");
		rmap.put("mem_pw", "111");
		rmap.put("mem_name", "유지민");
		mList.add(rmap);
		rmap.put("mem_id", "ae_karina");
		rmap.put("mem_pw", "222");
		rmap.put("mem_name", "유지민");
		mList.add(rmap);
		session.setAttribute("myName", myName);
		session.setAttribute("age", age);
		session.setAttribute("ramp", rmap);
		session.setAttribute("mList", mList);
			res.sendRedirect("./mimeHtmlResult.jsp");
	}
	// http://localhost:9000/day1/html2.do > http://localhost:9000/day1/mimeHtmlResult.jsp
	// ; 페이지가 변경됨
}