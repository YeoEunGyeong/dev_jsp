package com.pojo.step3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pojo.step2.Board2Controller;

public class ActionSupport extends HttpServlet {
	Logger logger = Logger.getLogger(ActionSupport.class);

	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService 호출");
		String uri = req.getRequestURI(); // 주소창에 입력된 값 중 도메인과 포트 번호가 제외된 값만 담음
		logger.info(uri);
		String context = req.getContextPath(); // -> server.xml
		logger.info(context);
		String command = uri.substring(context.length() + 1); // context 정보만 제외된 나머지 경로 정보 담음
		System.out.println(command);
		int end = command.lastIndexOf("."); // ; end는 .st1 잘라내기 위해 선언
		System.out.println(end); // 16
		command = command.substring(0, end);
		System.out.println(command);
		String upmu[] = null; // upmu[0] = 업무명|폴더명, upmu[1] = 요청 기능 이름
		upmu = command.split("/");
		// http://localhost:9000/board/getBoard2.st2
		logger.info(upmu[0] + "," + upmu[1]);
		req.setAttribute("upmu", upmu);
		Object obj = "";
		try {
			obj = HandlerMapping.getController(upmu, req, res);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		}
		if (obj != null) { // redirect:XXX.jsp/ forwar:XXX.jsp
			String pageMove[] = null;
			ModelAndView mav = null;
			if (obj instanceof String ) {
				if (((String) obj).contains(":")) {
					logger.info("포함");
					pageMove = obj.toString().split(":");
				}else {
					logger.info("포함Xxxx");
					pageMove = obj.toString().split(":");
				}
				logger.info(pageMove[0] + "," + pageMove[1]);
			} else if (obj instanceof ModelAndView) {
				mav = (ModelAndView)obj;
				pageMove= new String[2];
				pageMove[0] = "forward";
				pageMove[1] = mav.getViewName();
			}
			if (pageMove != null) {
				//pageMove[0] = redirect / forward
				//pageMove[1] = XXX.jsp
				String path = pageMove[1];
				if ("redirect".equals(pageMove[0])) {
					res.sendRedirect(path);
				} else if ("forward".equals(pageMove[0])) {
					RequestDispatcher view = req.getRequestDispatcher("/" + path + ".jsp");
					view.forward(req, res);
				} else {
					path = pageMove[0] + "/" + pageMove[1];
					RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/view/" + path + ".jsp");
					view.forward(req, res);
				}
			}
		}// 페이지 이동 처리
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doGet 호출");
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doPost 호출");
		doService(req, resp);
	}

}

