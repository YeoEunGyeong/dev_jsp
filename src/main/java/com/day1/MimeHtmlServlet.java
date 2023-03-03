package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿은 java인데 브라우저에 출력 가능 ; 화면 그리는데 서블릿 사용 (mime 타입이 가능하게 해 줌)
@WebServlet("/day1/html.do?gubun=2") // 웹에서 접근 가능한 맵핑 주소 설정
public class MimeHtmlServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		String gubun = req.getParameter("gubun");
		if (gubun == null) {
			res.setContentType("text/html;charset=UTF-8");
			// 메서드를 통해서 객체 생성하는 코드
			PrintWriter out = res.getWriter();
			out.print("<h2>카리나는 신이에요</h2>"); 
		} else {
			res.sendRedirect("./mimeHtmlResult.jsp");
		}
	}
}