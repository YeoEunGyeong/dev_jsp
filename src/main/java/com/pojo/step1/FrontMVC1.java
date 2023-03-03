package com.pojo.step1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

// 개발자 정의한 서블릿이므로 표준 서블릿이 아님
// doService 메서드는 요청 처리에 대한 창구를 일원화하기 위해 개발자가 정의한 메서드
// 따라서, request객체와 response객체를 톰캣 서버로부터 주입 받을 수 없음
// 문제 해결을 위해 메서드 파라미터 자리를 이용하여 doGet, doPost 메서드에서 주입 받은
// req(요청), res(응답)객체를 넘겨 받아 사용할 수 있게 구현
// doService(req, resp); 메서드 없으면 실행되지 않음
public class FrontMVC1 extends HttpServlet {
	/**
	 * 이 메서드는 톰캣 서버로 부터 직접 요청, 응답 객체 주입 불가하다
	 * 따라서, doGet, doPost 메서드 안에서 doService 메서드 호출할 때 파라티머로 넘겨 받음
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(FrontMVC1.class);

	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService 호출");
		String uri = req.getRequestURI(); // 주소창에 입력된 값 중 도메인과 포트 번호가 제외된 값만 담음
		logger.info(uri); // /dept/getDeptList.st1
		String context = req.getContextPath(); // -> server.xml
		logger.info(context); // /dept/getDeptList.st1
		// http://localhost:9000/dept/getDeptList.st1
		// http://localhost:9000/member/getMemberList.st1
		// http://localhost:9000/board/getBoardList.st1
		// http://localhost:9000/board/boardInsert.st1
		// http://localhost:9000/board/boardUpdate.st1
		// http://localhost:9000/board/boardDelete.st1
		// http://localhost:9000/업무 폴더명/getDeptList.st1
		String command = uri.substring(context.length() + 1); // context 정보만 제외된 나머지 경로 정보 담음
		System.out.println(command); // /dept/getDeptList.st1
		int end = command.lastIndexOf("."); // ; end는 .st1 잘라내기 위해 선언
		System.out.println(end); // 16
		command = command.substring(0, end); // /dept/getDeptList.st1
		System.out.println(command);
		String upmu[] = null; // upmu[0] = 업무명|폴더명, upmu[1] = 요청 기능 이름
		upmu = command.split("/"); // /dept/getDeptList.st1
		for (String imsi: upmu) {
			System.out.println(imsi);
		}
		// 
		
		// 게으른 인스턴화 ; 아직 결정되지 않음 - 업무명이 Controller 클래스의 접두어
		ActionForward af = null;
		DeptController deptController = null;
		// DeptController는 서블릿이 아니어서 요청 객체(req) 응답 객체(res) 톰캣 서버로부터 주입 받을 수 없음(HttpServles 상속 받지 못했기 때문에)
		EmpController empController = null;
		if ("dept".equals(upmu[0])) {
			// request
			req.setAttribute("upmu", upmu);
			// request 객체 == 저장소
			// 담을 때 : setAttribute, 꺼내올 때 : getAttribute
			// 인스턴스화 ; execute 메서드를 호출하기 위함(안 하면 NullPointerException)
			deptController = new DeptController();
			// DeptController는 req, res 주입 받을 수 없는 이유 ??? servlet이 아니기 때문
			// 그래서, 파라미터로 doGet 메서드가 주입 받은 req, res 주소 번지 원본을 넘김
			// 이렇게 넘겨 받지 않으면 DeptController에서는 req, res 누릴 수 없음 !!
			// 서블릿(req, res 주입 받지 못함)이 아닌 이유로 메서드 하나만 가질 수 있음(장애)
			// 장애 == 다른 메서드를 정의할 수는 있지만 req, res 주입 받을 수 없음을 뜻
			// 입력, 수정, 삭제, 조회 4가지 메서드 필요
			// DeptLogic 메서드 4가지 호출해야 하기 때문에 upmu[1] 정보 필요 
			// 그렇기 때문에 req.setAttribute("upmu", upmu); 선언
			af = deptController.execute(req, res);
		} else if ("emp".equals(upmu[0])) {
			// 인스턴스화
			empController = new EmpController();
			af = empController.execute(req, res);
		}
		// 페이지 이동 처리 공통 코드 만들기
		// 1 res.sendRedirect("/dept/getDeptList.jsp"); jsp -> 서블릿 -> jsp
		//   res.sendRedirect("/dept/getDeptList.st1"); jsp -> 서블릿 -> 서블릿 -> jsp
		if (af != null) {
			if (af.isRedirect()) {
				res.sendRedirect(af.getPath());
			} else {
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());
				view.forward(req, res);
			}
		} // 페이지 이동 처리에 대한 공통 코드 부분
	} // end doService

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doGet 호출"); // 브라우저의 주소창을 통해 요청하는 것은 모두 get 방식
		doService(req, resp); // 메서드 파라미터에 자리에 있는 변수는 지역 변수
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doPost 호출");
		doService(req, resp);

	}

}
