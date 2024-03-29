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

import com.google.gson.Gson;

// 서블릿은 java인데 브라우저에 출력 가능 ; 화면 그리는데 서블릿 사용 (mime 타입이 가능하게 해 줌)
@WebServlet("/xml.do") // 웹에서 접근 가능한 맵핑 주소 설정
public class MimeXMLServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		res.setContentType("text/xml;charset=UTF-8");
		// 메서드를 통해서 객체 생성하는 코드
		PrintWriter out = res.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append("<records>");
		sb.append("<record>");
		sb.append("<mem_id>karina</mem_id>");
		sb.append("<mem_pw>111</mem_pw>");
		sb.append("<mem_name>유지민</mem_name>");
		sb.append("</record>");
		sb.append("</records>");
		out.print(sb.toString());
	}
}
