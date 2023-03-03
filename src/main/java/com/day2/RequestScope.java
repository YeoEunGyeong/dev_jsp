package com.day2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import org.apache.log4j.Logger;
// http://localhost:9000/day2/a 요청 시 RequestScope 서블릿 클래스의 doGet 메서드 호출
// doGet 메서드 안에서 sendRedirect 대신 forward 메서드 호출
// 주소는 http://localhost:9000/day2/a 가리키고 있지만 실제 출력 페이지는 http://localhost:9000/day2/b.jsp 찾음
// 이것이 sendRedirect("b.jsp")로 이동할 때와 forward로 이동할 때의 차이점
// sendRedirect로 페이지 이동 시에는 값을 유지하려면 쿠키나 세션 이용해야 함 (:비상태 프로토콜)
// forward로 이동 시에는 forward 메서드 호출 시 첫 번째 파라미터인 request 객체에 담아 넘길(유지) 수 있다
// ; 비상태 프로토콜의 문제인 값 유지를 해결할 수 있는 방법 == forward
@WebServlet("/day2/a")
public class RequestScope extends HttpServlet {
	Logger logger = Logger.getLogger(RequestScope.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doGet 호출");
		Map<String, Object> rmap = new HashMap<>();
		rmap.put("mem_id", "karina");
		req.setAttribute("rmap", rmap);
		RequestDispatcher view = req.getRequestDispatcher("b.jsp");
		// day2/a 요청한 경우 doGet 메서드를 경유하게 되고 이 요청을 받았을 때 톰캣 서버로부터 서블릿 생성
		// 생성된 서블릿은 요청 객체와 응답 객체를 갖게 되는데 b.jsp 페이지에서 응답이 나갈 때 파라미터에 요청 객체 원본이 전달
		// 그 값을 화면에서 공유 가능함
		view.forward(req, resp);
	};
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
// 셀렉트이면 forward 무조건