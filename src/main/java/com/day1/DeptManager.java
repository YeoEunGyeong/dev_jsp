package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/*
 * 자바로는 웹서비스 불가 !requset와 response 없이 실행 안 됨!
 * ; 1) http프로토콜을 지원하는 API가 없기 때문
 *   2) 자바에는 URL(프로토콜://도메인:포트번호/경로/페이지 이름 or 서블릿) 등록 불가
 * Server + Applet((JFrame==유사하게 사용); html태그에서 호출이 가능한 유일한 자바 클래스) = servlet
 * a.jsp (서버에서 동작하는 페이지) - jsp-api.jar 톰캣을 사용해 자바로 변경
 * > a_jsp.java - 컴파일(저급 언어를 고급 언어로) servlet-api.jar
 * > a_jsp.class
 * 웹페이지 출력 ? 쓰기
 * request 쿼리스트링 ; get방식 - RESTful API[get, post, put, delete]
 * response
 * 
 * document.wirte("<b></b>")
 * PrintWriter out = res.getWirter // doget/dopost 안에 res 사용자의 요청을 어쩌고 4가지 함수에서 get, post
 * document.write() / out.print("<b></b>")
 */
public class DeptManager extends HttpServlet {
	Logger logger = Logger.getLogger(DeptManager.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		logger.info("[[doGet 호출 성공]]");
		String u_deptno = req.getParameter("deptno");
		String u_dname = req.getParameter("dname");
		String u_loc = req.getParameter("loc");
		res.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print(u_deptno + ", " + u_dname + ", " + u_loc);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
	}
}